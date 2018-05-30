package com.kdotj.viewmodelsample

import android.arch.lifecycle.ViewModel
import com.kdotj.viewmodelsample.data.WebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.kdotj.viewmodelsample.data.detail.PlaceDetailsResponse
import com.kdotj.viewmodelsample.data.places.PlacesResponse

class MainViewModel : ViewModel() {

    private lateinit var webservice: WebService

    private var placeResponse = MutableLiveData<PlacesResponse>()
    private var placeDetails = MutableLiveData<PlaceDetailsResponse>()

    private var searchTerms: String? = null
    private var type: String? = null
    private var placeId: String? = null

    fun injectWebService(webservice: WebService) {
        this.webservice = webservice
    }

    fun getPlacesList(searchTerms: String, type: String): MutableLiveData<PlacesResponse> {
        /*
            Check for changes in the parameters
         */
        var requestChanged = false
        if (this.searchTerms != searchTerms) {
            requestChanged = true
            this.searchTerms = searchTerms
        }

        if (this.type != type) {
            requestChanged = true
            this.type = type
        }

        if (placeResponse.value == null || requestChanged) {

            requestPlaces(searchTerms, type)
        }
        return placeResponse
    }

    fun getPlaceDetails(placeId: String): MutableLiveData<PlaceDetailsResponse> {
        /*
            Check for changes to the placeId
         */
        var requestChanged = false
        if (this.placeId != placeId) {
            this.placeId = placeId
            requestChanged = true
        }

        if (placeDetails.value == null || requestChanged) {

            requestPlaceDetails(placeId)
        }
        return placeDetails
    }

    private fun requestPlaces(searchTerms: String, type: String) {
        // Clear current value
        placeResponse = MutableLiveData()

        // Request the list of places
        webservice.getPlacesBySearchTerm(BuildConfig.MAPS_API_KEY, searchTerms).enqueue(object : Callback<PlacesResponse> {
            override fun onFailure(call: Call<PlacesResponse>, t: Throwable) {
                Log.d("DATA", t.localizedMessage)
            }

            override fun onResponse(call: Call<PlacesResponse>, response: Response<PlacesResponse>) {
                placeResponse.value = response.body()
            }
        })
    }

    private fun requestPlaceDetails(placeId: String) {
        // Clear current value
        placeDetails = MutableLiveData()

        // Request Details
        webservice.getPlaceDetails(BuildConfig.MAPS_API_KEY, placeId).enqueue(object : Callback<PlaceDetailsResponse> {
            override fun onFailure(call: Call<PlaceDetailsResponse>, t: Throwable) {
                Log.d("DATA", t.localizedMessage)
            }

            override fun onResponse(call: Call<PlaceDetailsResponse>, response: Response<PlaceDetailsResponse>) {
                placeDetails.value = response.body()
            }
        })
    }

}