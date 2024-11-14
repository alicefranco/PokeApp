package pt.pprojects.domain

interface UseCaseInterface<Type, Params> {
    suspend fun execute(refresh: Boolean = false, params: Params): Type
}