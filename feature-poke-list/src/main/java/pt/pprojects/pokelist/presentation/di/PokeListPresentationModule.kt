package pt.pprojects.pokelist.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pt.pprojects.pokelist.presentation.mapper.PokemonDomainPresentationMapper

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule() {
    @Provides
    fun providePokemonDomainPresentationMapper() = PokemonDomainPresentationMapper()
}