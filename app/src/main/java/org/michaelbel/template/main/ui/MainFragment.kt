package org.michaelbel.template.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver
import dagger.hilt.android.AndroidEntryPoint
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.template.R
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment: Fragment() {

    @Inject lateinit var analytics: Analytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(MainFragment::class.simpleName)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(inflater.context).apply {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val windowInsets = ViewWindowInsetObserver(this).start()

        setContent {
            CompositionLocalProvider(LocalWindowInsets provides windowInsets) {
                MaterialTheme {
                    Box(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(
                            title = { Text(text = "Template App") },
                            modifier = Modifier.align(Alignment.TopCenter),
                            navigationIcon = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        imageVector = Icons.Filled.Menu,
                                        contentDescription = "Menu"
                                    )
                                }
                            },
                            elevation = 2.dp
                        )
                        LazyColumn(
                            modifier = Modifier.align(Alignment.TopCenter).padding(top = 100.dp)
                        ) {
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_reviewFragment
                                        )
                                    }
                                ) {
                                    Text(text = "In-App Review")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_updateFragment
                                        )
                                    }
                                ) {
                                    Text(text = "In-App Update")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_savedStateFragment
                                        )
                                    }
                                ) {
                                    Text(text = "ViewModel Saved State")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_toastFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Toast")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_insetsFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Window Insets")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_pagingFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Paging")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_adsFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Ads")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_navArgsFragment,
                                            bundleOf(
                                                "firstText" to "Some Text",
                                                "secondNumber" to 100
                                            )
                                        )
                                    }
                                ) {
                                    Text(text = "Nav Args")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_configFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Remote Config")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_materialYouColorsFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Material You Colors")
                                }
                            }
                            item {
                                Button(
                                    onClick = {
                                        findNavController().navigate(
                                            R.id.action_mainFragment_to_fontsFragment
                                        )
                                    }
                                ) {
                                    Text(text = "Fonts")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}