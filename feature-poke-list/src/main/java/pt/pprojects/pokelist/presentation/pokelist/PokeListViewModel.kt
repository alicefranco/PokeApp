package pt.pprojects.pokelist.presentation.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase
import pt.pprojects.domain.Result
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.PokemonItem

class PokeListViewModel(
    private val scheduler: Scheduler,
    private val pokemonsUseCase: PokemonsUseCase,
    private val pokemonMapper: PokemonDomainPresentationMapper
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val PAGE_SIZE = 20
    private val START_OFFSET = 0
    private val TOTAL_POKEMONS = 984

    private var offset = START_OFFSET

    var loadedAll = false

    private val mutablePokemons =
        MutableLiveData<Result<List<PokemonItem>>>()
    val pokemons: LiveData<Result<List<PokemonItem>>>
        get() = mutablePokemons

    fun getPokemons(refresh: Boolean = false) {
        if (offset < TOTAL_POKEMONS) {
            val disposable = pokemonsUseCase.execute(refresh, offset)
                .subscribeOn(scheduler)
                .doOnSubscribe { mutablePokemons.postValue(Result.Loading) }
                .map<Result<List<PokemonItem>>> { pokemons ->
                    updateOffset()
                    Result.Success(
                        pokemonMapper.mapPokemonsToPresentation(pokemons)
                    )
                }
                .onErrorReturn { err -> Result.Error(err) }
                .subscribe(mutablePokemons::postValue)

            compositeDisposable.add(disposable)
        }
    }

    private fun updateOffset() {
        offset += PAGE_SIZE
        if (offset == TOTAL_POKEMONS)
            loadedAll = true
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}