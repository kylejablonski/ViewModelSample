package com.kdotj.viewmodelsample.place_list

import android.content.Context
import android.net.Uri
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatRatingBar
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kdotj.viewmodelsample.R
import com.kdotj.viewmodelsample.data.detail.Review
import com.squareup.picasso.Picasso


class ReviewAdapter(private val context: Context, private val reviews: Array<Review>) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_review, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val review = reviews[position]

        Picasso.get().load(Uri.parse(review.profilePhotoUrl))
                .into(holder.imageViewAuthorProfile)
        holder.textViewAuthorName.text = review.authorName
        holder.ratingBarReview.rating = review.rating.toFloat()
        holder.textViewReviewDate.text = review.relativeTimeDescription
        holder.textViewReviewText.text = review.text
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewAuthorProfile = view.findViewById<AppCompatImageView>(R.id.imageViewReviewProfile)
        val textViewAuthorName = view.findViewById<AppCompatTextView>(R.id.textViewAuthorName)
        val textViewReviewDate = view.findViewById<AppCompatTextView>(R.id.textViewReviewDate)
        val ratingBarReview = view.findViewById<AppCompatRatingBar>(R.id.ratingBarAuthorReview)
        val textViewReviewText = view.findViewById<AppCompatTextView>(R.id.textViewReviewText)
    }
}