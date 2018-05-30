package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class ViewPort(
        @SerializedName("northeast") val northEast: Location,
        @SerializedName("southwest") val southWest: Location
) : Parcelable