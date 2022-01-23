package org.michaelbel.template

object KotlinOptions {
    private const val ExperimentalCoroutinesApi = "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
    private const val ObsoleteCoroutinesApi = "-Xuse-experimental=kotlinx.coroutines.ObsoleteCoroutinesApi"
    private const val ExperimentalPagingApi = "-Xuse-experimental=androidx.paging.ExperimentalPagingApi"
    private const val ExperimentalComposeUiApi = "-Xuse-experimental=androidx.compose.ui.ExperimentalComposeUiApi"
    private const val ExperimentalMaterialApi = "-Xuse-experimental=androidx.compose.material.ExperimentalMaterialApi"
    private const val ExperimentalMaterial3Api = "-Xuse-experimental=androidx.compose.material3.ExperimentalMaterial3Api"
    private const val ExperimentalCoilApi = "-Xuse-experimental=coil.annotation.ExperimentalCoilApi"
    private const val ExperimentalSerializationApi = "-Xuse-experimental=kotlinx.serialization.ExperimentalSerializationApi"
    private const val FlowPreview = "-Xopt-in=kotlinx.coroutines.FlowPreview"

    val all: String
        get() = ExperimentalCoroutinesApi +
                ObsoleteCoroutinesApi +
                ExperimentalPagingApi +
                ExperimentalComposeUiApi +
                ExperimentalMaterialApi +
                ExperimentalMaterial3Api +
                ExperimentalCoilApi +
                ExperimentalSerializationApi +
                FlowPreview
}