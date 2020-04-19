package pt.pprojects.pokelist.presentation.pokelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import pt.pprojects.pokelist.domain.model.Pokemon
import pt.pprojects.pokelist.domain.usecase.PokemonsUseCase
import pt.pprojects.domain.Result

class PokeListViewModel(
    private val scheduler: Scheduler,
    private val pokemonsUseCase: PokemonsUseCase
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val mutablePokemons =
        MutableLiveData<Result<List<Pokemon>>>()
    val pokemons: LiveData<Result<List<Pokemon>>>
        get() = mutablePokemons

    fun getPokemons(refresh: Boolean = false, offset: Int) {
        val disposable = pokemonsUseCase.execute(refresh, offset)
            .subscribeOn(scheduler)
            .doOnSubscribe { mutablePokemons.postValue(Result.Loading) }
            .map<Result<List<Pokemon>>> { pokemons ->
                Result.Success(
                    pokemons
                )
            }
            .onErrorReturn { err -> Result.Error(err) }
            .subscribe(mutablePokemons::postValue)

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}