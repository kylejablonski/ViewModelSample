package com.kdotj.viewmodelsample.data.places

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Place(@SerializedName("icon") val icon: String,
            @SerializedName("place_id") val placeId: String,
            @SerializedName("name") val name: String,
            @SerializedName("price_level") val priceLevel: Int,
            @SerializedName("rating") val rating: Float,
            @SerializedName("vicinity") val vicinity: String) : Parcelable