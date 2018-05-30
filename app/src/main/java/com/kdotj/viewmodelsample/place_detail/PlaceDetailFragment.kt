package com.kdotj.viewmodelsample.place_detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kdotj.viewmodelsample.MainViewModel
import com.kdotj.viewmodelsample.R
import com.kdotj.viewmodelsample.data.WebService
import com.kdotj.viewmodelsample.data.detail.PlaceDetailsResponse
import com.kdotj.viewmodelsample.data.places.Place
import com.kdotj.viewmodelsample.place_list.ReviewAdapter
import com.kdotj.viewmodelsample.priceArray
import kotlinx.android.synthetic.main.fragment_place_detail.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaceDetailFragment : Fragment() {


    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val webService = retrofit.create(WebService::class.java)
        mainViewModel = ViewModelProviders.of(activity!!).get(MainViewModel::class.java)
        mainViewModel.injectWebService(webService)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarSearchDetails.setNavigationOnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
            navController.navigateUp()
        }

        val place = arguments!!.getParcelable<Place>("place")
        mainViewModel.getPlaceDetails(place.placeId).observe(this, Observer<PlaceDetailsResponse> { it ->
            textViewDetailsPlaceTitle.text = it!!.result.name
            textViewDetailsPriceLevel.text = priceArray[it.result.priceLevel]
            textViewDetailsReviewCount.text = "(${it.result.reviews.size})"
            ratingBarDetails.rating = it.result.rating
            textViewDetailsAddress.text = it.result.formattedAddress

            recyclerViewPhotos.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewPhotos.adapter = PhotoAdapter(activity!!, it.result.photos)

            recyclerViewRatings.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewRatings.adapter = ReviewAdapter(activity!!, it.result.reviews)
        })
    }
}