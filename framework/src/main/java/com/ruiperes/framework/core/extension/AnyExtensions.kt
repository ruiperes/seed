package com.ruiperes.framework.core.extension

import com.ruiperes.framework.core.errors.failures.Failure
import com.ruiperes.framework.core.funcional.Either

fun <T : Any> T.toRight(): Either<Failure, T> {
    return Either.Right(this)
}

fun Any?.isNull(): Boolean {
    return this == null
}

fun Any?.isNullOrEmpty(): Boolean {
    return this == null || (this is String && this.isEmpty())
}