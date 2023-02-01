package com.example.admobaddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.admobaddemo.databinding.ActivityMainBinding
import com.google.ads.AdSize
import com.google.android.gms.ads.*
import com.google.android.gms.ads.initialization.InitializationStatus
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        try {

            binding.textview.setOnClickListener(View.OnClickListener {

                startActivity(Intent(this,SecondActivity::class.java))

            })



            MobileAds.initialize(this) {}

            val request = AdRequest.Builder().build()
            binding.adView.loadAd(request)

            binding.adView.adListener = object : AdListener() {
                override fun onAdClicked() {
                    super.onAdClicked()
                    // Code to be executed when the user clicks on an ad.
                }

                override fun onAdClosed() {
                    // Code to be executed when the user is about to return
                    // to the app after tapping on an ad.
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    super.onAdFailedToLoad(adError)

                    // Code to be executed when an ad request fails.
                }
                var a = 0;
                override fun onAdImpression() {

                    ++a
                    Log.d("GSFS", "on $a")
                    // Code to be executed when an impression is recorded
                    // for an ad.
                }

                override fun onAdLoaded() {
                    super.onAdLoaded()
                    binding.adView.loadAd(request)
                    // Code to be executed when an ad finishes loading.
                }

                override fun onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                }
            }

        }catch (e:Exception)
        {
            Toast.makeText(this, "error ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }
}