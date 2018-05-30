package com.kdotj.viewmodelsample.data

import com.kdotj.viewmodelsample.data.detail.PlaceDetailsResponse
import com.kdotj.viewmodelsample.data.places.PlacesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("place/textsearch/json")
    fun getPlacesBySearchTerm(@Query("key") apiKey: String,
                              @Query("query") query: String): Call<PlacesResponse>

    @GET("place/details/json")
    fun getPlaceDetails(@Query("key") apiKey: String,
                        @Query("placeid") placeId: String): Call<PlaceDetailsResponse>

}