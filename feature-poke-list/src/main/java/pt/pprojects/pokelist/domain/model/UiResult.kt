package pt.pprojects.pokelist.domain.model

sealed class UiResult<out T> {
    object Loading : UiResult<Nothing>()
    data class Error(val cause: Throwable) : UiResult<Nothing>()
    data class Success<T>(val data: T) : UiResult<T>()
}
