@file:Suppress("unused")

package org.michaelbel.core.ktx

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun <T> Flow<T>.launchWhenCreated(lifecycleCoroutineScope: LifecycleCoroutineScope) {
    lifecycleCoroutineScope.launchWhenCreated {
        this@launchWhenCreated.collect()
    }
}

fun <T> Flow<T>.launchWhenStarted(lifecycleCoroutineScope: LifecycleCoroutineScope) {
    lifecycleCoroutineScope.launchWhenStarted {
        this@launchWhenStarted.collect()
    }
}

fun <T> Flow<T>.launchWhenResumed(lifecycleCoroutineScope: LifecycleCoroutineScope) {
    lifecycleCoroutineScope.launchWhenResumed {
        this@launchWhenResumed.collect()
    }
}

inline fun <T> Flow<T>.launchAndCollectIn(
    owner: LifecycleOwner,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline action: suspend CoroutineScope.(T) -> Unit
) = owner.lifecycleScope.launch {
    owner.repeatOnLifecycle(minActiveState) {
        collect {
            action(it)
        }
    }
}