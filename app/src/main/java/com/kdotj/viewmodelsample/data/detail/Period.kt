package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Period(
        @SerializedName("close") val close: Close,
        @SerializedName("open") val open: Open
) : Parcelable