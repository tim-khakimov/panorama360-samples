package com.timkhakimov.panorama360sample

import android.content.Context
import java.io.IOException


/**
 * Created by Timur Khakimov on 21.05.2020
 */
val ASSETS_DIR = "android_asset"
val IMAGES_DIR = "images360"
val ARG_IMAGE = "arg_image"

object ImageUtils {

    fun getImagesList(context: Context) : List<String>? {
        val images = mutableListOf<String>()
        val myAssetManager = context.getAssets()
        try {
            val files = myAssetManager.list(IMAGES_DIR) // массив имен файлов
            images.addAll(files!!.toMutableList())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return images
    }

    fun getFullImageUrl(fileName : String) : String {
        return "file:///android_asset/$IMAGES_DIR/$fileName"
    }
}