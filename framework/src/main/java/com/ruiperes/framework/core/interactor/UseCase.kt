package com.ruiperes.framework.core.interactor

import com.ruiperes.framework.core.errors.failures.Failure
import com.ruiperes.framework.core.funcional.Either
import com.ruiperes.framework.core.thread.ThreadProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means than any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params>(private val threadProvider: ThreadProvider) where Type : Any {

    var running: Boolean = false
    abstract suspend fun run(params: Params): Either<Failure, Type>


    open operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        if (!running) {
            running = true
            threadProvider.scope.launch { onResult(withContext(threadProvider.context) { run(params) }) }
                .invokeOnCompletion {
                    running = false
                }
        }
    }

    open operator fun invoke(
        viewModelScope: CoroutineScope,
        params: Params,
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        val backgroundJob = viewModelScope.async { run(params) }
        viewModelScope.launch { onResult(backgroundJob.await()) }
    }
}