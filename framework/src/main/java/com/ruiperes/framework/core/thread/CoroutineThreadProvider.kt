package com.ruiperes.framework.core.thread

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class CoroutineThreadProvider : ThreadProvider {
    override val scope: CoroutineScope by lazy { CoroutineScope(Dispatchers.Main + Job()) }
    override val context: CoroutineContext by lazy { Dispatchers.IO }
}