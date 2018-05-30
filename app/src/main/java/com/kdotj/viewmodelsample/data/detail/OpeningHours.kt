package com.kdotj.viewmodelsample.data.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class OpeningHours(
        @SerializedName("open_now") val openNow: Boolean,
        @SerializedName("periods") val periods: Array<Period>,
        @SerializedName("weekday_text") val weekdayText: Array<String>
) : Parcelable