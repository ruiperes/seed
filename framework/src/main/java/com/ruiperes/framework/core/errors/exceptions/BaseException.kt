package com.ruiperes.framework.core.errors.exceptions

/**
 * Exceptions should only be used until Use Cases
 */
sealed class BaseException(val code: ExceptionCode) : Exception() {
    object RepositoryException : BaseException(ExceptionCode.RepositoryCode)
    object DomainException : BaseException(ExceptionCode.DomainCode)

    open class FeatureException(code: ExceptionCode) : BaseException(code)
}