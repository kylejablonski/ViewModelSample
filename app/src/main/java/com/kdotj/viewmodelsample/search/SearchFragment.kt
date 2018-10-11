package com.kdotj.viewmodelsample.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.kdotj.viewmodelsample.R
import kotlinx.android.synthetic.main.fragment_search.*
import android.view.inputmethod.EditorInfo
import android.widget.TextView


class SearchFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewPlaceSearchText.setImeActionLabel(getString(R.string.search), EditorInfo.IME_ACTION_DONE)
        textViewPlaceSearchText.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val query = textViewPlaceSearchText.text.toString()

                if (query.isEmpty()) {
                    Toast.makeText(activity!!, getString(R.string.provide_a_search_term), Toast.LENGTH_SHORT).show()
                    return@OnEditorActionListener false
                }

                val bundle = Bundle()
                bundle.putString("query", query)
                bundle.putString("category", "")
                val navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
                navController.navigate(R.id.action_searchFragment_to_placeListFragment, bundle)


                return@OnEditorActionListener true
            }
            false
        })
    }


}