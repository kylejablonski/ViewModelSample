package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Review(
        @SerializedName("author_name") val authorName: String,
        @SerializedName("author_url") val authorUrl: String,
        @SerializedName("language") val language: String,
        @SerializedName("profile_photo_url") val profilePhotoUrl: String,
        @SerializedName("rating") val rating: Int,
        @SerializedName("relative_time_description") val relativeTimeDescription: String,
        @SerializedName("text") val text: String,
        @SerializedName("time") val time: Long

) : Parcelable