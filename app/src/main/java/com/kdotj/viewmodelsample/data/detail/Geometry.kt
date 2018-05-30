package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Geometry(
        @SerializedName("location") val location: Location,
        @SerializedName("viewport") val viewPort: ViewPort
) : Parcelable