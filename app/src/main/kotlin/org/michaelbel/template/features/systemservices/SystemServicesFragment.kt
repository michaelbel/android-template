package org.michaelbel.template.features.systemservices

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.speech.RecognizerIntent
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.googleapi.GoogleApi
import org.michaelbel.core.ktx.doOnApplyWindowInsets
import org.michaelbel.core.ktx.topPadding
import org.michaelbel.core.system.Connectivity
import org.michaelbel.template.R
import org.michaelbel.template.databinding.FragmentSystemServicesBinding

// todo добавить flow для состояния интернета
// todo добавить flow для состояния типа сети (мобильная, вайфай, езернет)
// todo ресивер для отслеживания зарядки
// todo Requires the PackageManager#FEATURE_FINGERPRINT feature which can
//  be detected using PackageManager.hasSystemFeature(String).
// todo камера, микрофон и т д разные сенсоры
@AndroidEntryPoint
class SystemServicesFragment: Fragment(R.layout.fragment_system_services) {

    @Inject lateinit var analytics: Analytics
    @Inject lateinit var vibrator: Vibrator
    @Inject lateinit var googleApi: GoogleApi
    @Inject lateinit var connectivity: Connectivity

    private val speechRecognizeContract = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        val data: Intent? = activityResult.data
        val spokenText: String? =
            data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.let { results ->
                results[0]
            }
        Toast.makeText(requireContext(), spokenText, Toast.LENGTH_SHORT).show()
    }

    private val binding: FragmentSystemServicesBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analytics.trackScreen(SystemServicesFragment::class.simpleName)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.appBarLayout.doOnApplyWindowInsets { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.topPadding = systemBars.top
            WindowInsetsCompat.CONSUMED
        }
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        binding.vibrateButton.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(150L, 10))
            } else {
                @Suppress("Deprecation")
                vibrator.vibrate(150L)
            }
        }

        binding.voiceButton.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
            }
            speechRecognizeContract.launch(intent)
        }

        binding.playServicesTextView.setText(
            if (googleApi.isPlayServicesAvailable) {
                R.string.play_services_available
            } else {
                R.string.play_services_not_available
            }
        )
        binding.internetTextView.setText(
            if (connectivity.isOnline) {
                R.string.internet_connected
            } else {
                R.string.internet_not_connected
            }
        )
        binding.wifiTextView.setText(
            if (connectivity.isConnectedWifi) {
                R.string.wifi_connected
            } else {
                R.string.wifi_not_connected
            }
        )
        binding.bluetoothTextView.setText(
            if (connectivity.isBluetoothEnabled) {
                R.string.bluetooth_enabled
            } else {
                R.string.bluetooth_disabled
            }
        )
        binding.batteryChargingTextView.setText(
            if (connectivity.isBatteryCharging) {
                R.string.battery_charging
            } else {
                R.string.battery_not_charging
            }
        )
        binding.batteryLevelTextView.text = getString(R.string.battery_level, connectivity.batteryLevel).plus("%")
    }
}