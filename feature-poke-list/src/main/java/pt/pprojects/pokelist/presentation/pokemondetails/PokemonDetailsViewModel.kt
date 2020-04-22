package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import pt.pprojects.pokelist.domain.usecase.PokemonCharacteristicsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper
import pt.pprojects.pokelist.presentation.model.PokemonDetails
import pt.pprojects.domain.Result

class PokemonDetailsViewModel(
    private val scheduler: Scheduler,
    private val pokemonCharacteristicsUseCase: PokemonCharacteristicsUseCase,
    private val pokemonMapper: PokemonDomainPresentationMapper
) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val mutablePokemonDetails =
        MutableLiveData<Result<PokemonDetails>>()
    val pokemonDetails: LiveData<Result<PokemonDetails>>
        get() = mutablePokemonDetails

    fun getPokemonDetails(pokemonId: Int) {
        val disposable = pokemonCharacteristicsUseCase.execute(refresh = false, params = pokemonId)
            .subscribeOn(scheduler)
            .doOnSubscribe { mutablePokemonDetails.postValue(Result.Loading) }
            .map<Result<PokemonDetails>> { pokemonDetails ->
                Result.Success(
                    pokemonMapper.mapPokemonDetailsToPresentation(pokemonDetails)
                )
            }
            .onErrorReturn { err -> Result.Error(err) }
            .subscribe(mutablePokemonDetails::postValue)

        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
