package org.michaelbel.template.auth.vk

import android.content.Context
import androidx.startup.Initializer
import com.vk.api.sdk.VK

@Suppress("unused")
class VkInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        VK.initialize(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}