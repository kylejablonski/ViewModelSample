package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Close(
        @SerializedName("day") val day: Int,
        @SerializedName("time") val time: String
) : Parcelable