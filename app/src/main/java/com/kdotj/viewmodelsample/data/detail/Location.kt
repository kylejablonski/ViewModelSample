package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Location(
        @SerializedName("lat") val lat: Float,
        @SerializedName("lng") val lng: Float
) : Parcelable