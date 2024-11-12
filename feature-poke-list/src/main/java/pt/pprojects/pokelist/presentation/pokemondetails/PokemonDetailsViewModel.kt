package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.lifecycle.ViewModel
import pt.pprojects.pokelist.domain.usecase.PokemonCharacteristicsUseCase
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper

class PokemonDetailsViewModel(
    private val pokemonCharacteristicsUseCase: PokemonCharacteristicsUseCase,
    private val pokemonMapper: PokemonDomainPresentationMapper
) : ViewModel() {
//    private val compositeDisposable = CompositeDisposable()
//
//    private val mutablePokemonDetails =
//        MutableLiveData<DomainResult<PokemonDetails>>()
//    val pokemonDetails: LiveData<DomainResult<PokemonDetails>>
//        get() = mutablePokemonDetails
//
//    fun getPokemonDetails(pokemonId: Int) {
//        val disposable = pokemonCharacteristicsUseCase.execute(refresh = false, params = pokemonId)
//            .subscribeOn(scheduler)
//            .doOnSubscribe { mutablePokemonDetails.postValue(DomainResult.Loading) }
//            .map<DomainResult<PokemonDetails>> { pokemonDetails ->
//                DomainResult.Success(
//                    pokemonMapper.mapPokemonDetailsToPresentation(pokemonDetails)
//                )
//            }
//            .onErrorReturn { err -> DomainResult.Error(err) }
//            .subscribe(mutablePokemonDetails::postValue)
//
//        compositeDisposable.add(disposable)
//    }
//
//    override fun onCleared() {
//        compositeDisposable.clear()
//        super.onCleared()
//    }
}
