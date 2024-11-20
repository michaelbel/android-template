@file:Suppress("unused", "UnusedReceiverParameter")

package org.michaelbel.core.ktx

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.reflect.KProperty

inline fun <reified T> Activity.argumentDelegate(): LazyProvider<Activity, T> {
    return argumentDelegate { activity: Activity -> activity.intent?.extras }
}

inline fun <reified T> Fragment.argumentDelegate(): LazyProvider<Fragment, T> {
    return argumentDelegate { fragment: Fragment -> fragment.requireArguments() }
}

inline fun <F, reified T> argumentDelegate(
    crossinline provideArguments: (F) -> Bundle?
): LazyProvider<F, T> {
    return object: LazyProvider<F, T> {
        override fun provideDelegate(thisRef: F, prop: KProperty<*>): Lazy<T> = lazy {
            val bundle: Bundle? = provideArguments(thisRef)
            bundle?.get(prop.name) as T
        }
    }
}

interface LazyProvider<A, T> {
    operator fun provideDelegate(thisRef: A, prop: KProperty<*>): Lazy<T>
}

inline fun <reified T> Bundle.requireParcelable(key: String): T {
    return if (Build.VERSION.SDK_INT >= 33) {
        getParcelable(key, T::class.java) as T
    } else {
        requireNotNull(getParcelable(key))
    }
}

inline fun <reified T> Bundle.requireSerializable(key: String): T {
    return if (Build.VERSION.SDK_INT >= 33) {
        getParcelable(key, T::class.java) as T
    } else {
        requireNotNull(getSerializable(key)) as T
    }
}