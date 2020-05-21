package com.timkhakimov.panorama360sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    private val adapter = ImagesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpList()
        logImages()
    }

    private fun setUpList() {
        rvImages.adapter = adapter
        rvImages.layoutManager = GridLayoutManager(this, 2)
    }

    private fun logImages() {
        val images = ImageUtils.getImagesList(this)
        images?.let { adapter.setData(it)}
    }

    private class ImagesAdapter : RecyclerView.Adapter<ImageHolder>() {

        var selectImageListener : (String) -> Unit = {}
        var images = mutableListOf<String>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
            return ImageHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_image_preview, parent, false))
        }

        override fun getItemCount(): Int {
            return images.size
        }

        override fun onBindViewHolder(holder: ImageHolder, position: Int) {
            holder.bindImage(images[position])
            holder.itemView.setOnClickListener { selectImageListener.invoke(images[position]) }
        }

        fun setData(items : List<String>) {
            images.clear()
            images.addAll(items)
            notifyDataSetChanged()
        }
    }

    private class ImageHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindImage(image : String) {
            Picasso.get()
                .load(ImageUtils.getFullImageUrl(image))
                .resizeDimen(R.dimen.image_preview_size, R.dimen.image_preview_size)
                .into(itemView.findViewById<ImageView>(R.id.ivImage))
        }
    }
}
