package pt.pprojects.domain

interface UseCaseInterface<Type, Params> {
    fun execute(refresh: Boolean, params: Params): Type
}