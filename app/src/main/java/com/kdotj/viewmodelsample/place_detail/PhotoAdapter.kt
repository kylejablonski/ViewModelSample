package com.kdotj.viewmodelsample.place_detail

import android.content.Context
import android.net.Uri
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kdotj.viewmodelsample.BuildConfig
import com.kdotj.viewmodelsample.R
import com.kdotj.viewmodelsample.data.detail.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(private val context: Context, private val photos: Array<Photo>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_photo, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        val photoUri = Uri.parse(String.format(context.getString(R.string.photos_url), photo.width, photo.photoReference, BuildConfig.MAPS_API_KEY))
        Picasso.get().load(photoUri).into(holder.imageViewPhoto)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewPhoto = view.findViewById<AppCompatImageView>(R.id.imageViewPhoto)
    }
}