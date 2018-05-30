package com.kdotj.viewmodelsample.place_list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kdotj.viewmodelsample.MainViewModel
import com.kdotj.viewmodelsample.R
import com.kdotj.viewmodelsample.data.places.Place
import com.kdotj.viewmodelsample.data.places.PlacesResponse
import com.kdotj.viewmodelsample.data.WebService
import kotlinx.android.synthetic.main.fragment_place_list.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class PlaceListFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_place_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        toolbarSearchResults.setNavigationOnClickListener {
            val navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
            navController.navigateUp()
        }
        val searchTerm = arguments!!.getString("query")
        toolbarSearchResults.title = getString(R.string.search_results_title)
        toolbarSearchResults.subtitle = String.format(Locale.getDefault(), getString(R.string.search_results_subtitle), searchTerm)
        val type = arguments!!.getString("type")
        mainViewModel.getPlacesList(searchTerm, type).observe(activity!!, Observer<PlacesResponse> { t ->
            if (t!!.status == "ZERO_RESULTS") {
                rlEmptyState.visibility = View.VISIBLE
            } else {
                rlEmptyState.visibility = View.GONE
                applyData(t.places)
            }
            progressBarSearch.visibility = View.GONE
        })
    }

    private fun applyData(places: List<Place>) {
        recyclerViewPlaces.layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)
        recyclerViewPlaces.addItemDecoration(DividerItemDecoration(activity!!, DividerItemDecoration.VERTICAL))
        val adapter = PlaceAdapter(activity!!, places)
        recyclerViewPlaces.adapter = adapter
        adapter.setListener(listener)
    }

    private val listener = object : PlaceAdapter.Listener {
        override fun onClick(place: Place) {
            val navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
            val bundle = Bundle()
            bundle.putParcelable("place", place)
            navController.navigate(R.id.action_placeListFragment_to_placeDetailFragment, bundle)
        }
    }
}