package com.ruiperes.framework.core.thread

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

interface ThreadProvider {
    val scope: CoroutineScope
    val context: CoroutineContext
}

