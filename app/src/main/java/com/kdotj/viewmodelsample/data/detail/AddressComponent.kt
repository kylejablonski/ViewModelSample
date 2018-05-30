package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class AddressComponent(
        @SerializedName("long_name") val longName: String,
        @SerializedName("short_name") val shortName: String,
        @SerializedName("types") val types: Array<String>
) : Parcelable