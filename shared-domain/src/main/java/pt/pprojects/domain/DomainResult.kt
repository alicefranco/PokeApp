package pt.pprojects.domain

sealed class DomainResult<out T> {
    data class Error(val cause: Throwable) : DomainResult<Nothing>()
    data class Success<T>(val data: T) : DomainResult<T>()
}
