package org.michaelbel.template.features.timer

import android.os.Bundle
import android.view.View
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.ktx.doOnApplyWindowInsets
import org.michaelbel.core.ktx.topPadding
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentTimerBinding

/**
 * Coroutines Timer
 */
@AndroidEntryPoint
class TimerFragment: Fragment(R.layout.fragment_timer) {

    private val binding: FragmentTimerBinding by viewBinding()

    private var timerJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.appBarLayout.doOnApplyWindowInsets { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.topPadding = systemBars.top
            WindowInsetsCompat.CONSUMED
        }
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.startTimerButton.setOnClickListener {
            timerJob?.cancel()
            timerJob = tickerFlow(TimeUnit.SECONDS.toMillis(5))
                .onEach { onTimeOver() }
                .launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        timerJob = null
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(TimerFragment::class.simpleName)
    }

    private fun tickerFlow(delay: Long): Flow<Unit> = flow {
        delay(delay)
        emit(Unit)
    }

    private fun onTimeOver() {
        Snackbar.make(requireView(), R.string.time_over, Snackbar.LENGTH_SHORT).show()
    }
}