package org.michaelbel.template.ads

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import javax.inject.Inject
import org.michaelbel.core.analytics.Analytics
import org.michaelbel.core.ktx.doOnApplyWindowInsets
import org.michaelbel.core.ktx.topPadding
import org.michaelbel.template.ads.databinding.FragmentAdsBinding

@AndroidEntryPoint
class AdsFragment: Fragment(R.layout.fragment_ads) {

    private val binding: FragmentAdsBinding by viewBinding()

    private var interstitialAd: InterstitialAd? = null

    private val interstitialAdLoadCallback = object: InterstitialAdLoadCallback() {
        override fun onAdLoaded(ad: InterstitialAd) {
            interstitialAd = ad
            Toast.makeText(requireContext(), "onAdLoaded()", Toast.LENGTH_SHORT).show()
            ad.fullScreenContentCallback = fullScreenContentCallback
        }

        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            interstitialAd = null
            val error: String = String.format(
                Locale.ENGLISH,
                "domain: %s, code: %d, message: %s",
                loadAdError.domain,
                loadAdError.code,
                loadAdError.message
            )
            Toast.makeText(
                requireContext(),
                "onAdFailedToLoad() with error: $error",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private val fullScreenContentCallback = object: FullScreenContentCallback() {
        override fun onAdDismissedFullScreenContent() {
            interstitialAd = null
        }

        override fun onAdFailedToShowFullScreenContent(adError: AdError) {
            interstitialAd = null
        }

        override fun onAdShowedFullScreenContent() {
            /* do nothing */
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MobileAds.initialize(requireContext()) {}
        loadInterstitialAd()

        binding.appBarLayout.doOnApplyWindowInsets { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.topPadding = systemBars.top
            WindowInsetsCompat.CONSUMED
        }
        binding.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }

        binding.adsButton.setOnClickListener {
            if (interstitialAd != null) {
                interstitialAd?.show(requireActivity())
            } else {
                Toast.makeText(requireContext(), "Ad did not load", Toast.LENGTH_SHORT).show()
                if (interstitialAd == null) {
                    loadInterstitialAd()
                }
            }
        }
    }

    @Inject
    fun trackScreen(analytics: Analytics) {
        analytics.trackScreen(AdsFragment::class.simpleName)
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            requireContext(),
            getString(R.string.interstitial_ad_unit_id),
            adRequest,
            interstitialAdLoadCallback
        )
    }
}