package com.timkhakimov.panorama360sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Timur Khakimov on 21.05.2020
 */
class PanoramaActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panorama)
        intent.getStringExtra(ARG_IMAGE)?.let { showPanorama(it) }
    }

    private fun showPanorama(image : String) {
        //todo показать панораму
    }
}