package com.cardinal.seed.core.domain.exceptions

sealed class Failure(private val exception: Exception = Exception("Failure")) {
    object None : Failure()
    object NetworkConnection : Failure()
    object ServerError : Failure()

    /** * Extend this class for feature specific failures.*/
    open class FeatureFailure(featureException: Exception = Exception("Feature failure")) : Failure(featureException)

    override fun equals(other: Any?): Boolean {
        return other is Failure
    }

    override fun hashCode(): Int {
        return exception.hashCode()
    }
}