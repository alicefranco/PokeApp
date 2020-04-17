package pt.pprojects.domain

interface UseCaseInterface<out Type, in Params> {
    fun execute(params: Params?): Type
}