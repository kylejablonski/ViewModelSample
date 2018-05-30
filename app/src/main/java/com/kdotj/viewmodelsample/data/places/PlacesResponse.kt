package com.kdotj.viewmodelsample.data.places

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlacesResponse(@SerializedName("status") val status: String,
                     @SerializedName("results") val places: List<Place>,
                     @SerializedName("next_page_token") val nextPageToken: String) : Parcelable