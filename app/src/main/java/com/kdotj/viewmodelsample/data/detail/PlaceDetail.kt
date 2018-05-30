package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class PlaceDetail(
        @SerializedName("address_components") val addressComponents: Array<AddressComponent>,
        @SerializedName("adr_address") val adrAddress: String,
        @SerializedName("formatted_address") val formattedAddress: String,
        @SerializedName("formatted_phone_number") val formattedPhoneNumber: String,
        @SerializedName("geometry") val geometry: Geometry,
        @SerializedName("icon") val icon: String,
        @SerializedName("id") val id: String,
        @SerializedName("international_phone_number") val internationalPhoneNumber: String,
        @SerializedName("name") val name: String,
        @SerializedName("opening_hours") val openingHours: OpeningHours,
        @SerializedName("photos") val photos: Array<Photo>,
        @SerializedName("place_id") val placeId: String,
        @SerializedName("price_level") val priceLevel: Int,
        @SerializedName("rating") val rating: Float,
        @SerializedName("reference") val reference: String,
        @SerializedName("reviews") val reviews: Array<Review>,
        @SerializedName("scope") val scope: String,
        @SerializedName("types") val types: Array<String>,
        @SerializedName("url") val url: String,
        @SerializedName("utc_offset") val utcOffset: Int,
        @SerializedName("vicinity") val vicinity: String,
        @SerializedName("website") val website: String
) : Parcelable