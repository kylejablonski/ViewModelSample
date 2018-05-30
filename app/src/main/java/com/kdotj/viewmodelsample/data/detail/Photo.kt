package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Photo(
        @SerializedName("height") val height: Int,
        @SerializedName("html_attributes") val htmlAttributes: Array<String>,
        @SerializedName("photo_reference") val photoReference: String,
        @SerializedName("width") val width: Int
) : Parcelable