package com.timkhakimov.panorama360sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.BitmapFactory
import com.google.vr.sdk.widgets.pano.VrPanoramaView
import kotlinx.android.synthetic.main.activity_panorama.*
import java.io.InputStream


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
        loadPhotoSphere(ImageUtils.getAssetsImagePath(image))
    }

    private fun loadPhotoSphere(imagePath : String) {
        val options = VrPanoramaView.Options()
        try {
            val inputStream = getAssets().open(imagePath)
            options.inputType = VrPanoramaView.Options.TYPE_MONO
            pano_view.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options)
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}