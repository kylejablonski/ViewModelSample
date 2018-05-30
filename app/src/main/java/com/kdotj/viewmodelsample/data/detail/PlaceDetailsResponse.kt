package com.kdotj.viewmodelsample.data.detail


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlaceDetailsResponse(
        @SerializedName("html_attributions") val htmlAttributions: Array<String>,
        @SerializedName("result") val result: PlaceDetail,
        @SerializedName("status") val status: String
) : Parcelable