package com.kdotj.viewmodelsample.place_list

import android.content.Context
import android.support.v7.widget.*
import android.view.*
import android.widget.Toast
import com.kdotj.viewmodelsample.R
import com.kdotj.viewmodelsample.data.places.Place
import com.kdotj.viewmodelsample.priceArray
import com.squareup.picasso.Picasso

class PlaceAdapter(private val context: Context,
                   private val placeList: List<Place>) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    interface Listener {
        fun onClick(place: Place)
    }

    private lateinit var listener: Listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_place_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = placeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        Picasso.get().load(place.icon).resize(56, 56).into(holder.placeIcon)
        holder.placeName.text = place.name
        holder.placeRating.rating = place.rating
        holder.placePriceLevel.text = priceArray[place.priceLevel]

        holder.itemView.setOnClickListener {
            listener.onClick(place)
        }

        holder.placeOptionsButton.setOnClickListener {
            val popupMenu = PopupMenu(context, holder.placeOptionsButton, Gravity.START)
            popupMenu.menuInflater.inflate(R.menu.menu_place_options, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.action_save -> {
                        Toast.makeText(context, context.getString(R.string.options_save), Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_share -> {
                        Toast.makeText(context, context.getString(R.string.options_share), Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_cancel -> {
                        Toast.makeText(context, context.getString(R.string.options_cancel), Toast.LENGTH_SHORT).show()
                        popupMenu.dismiss()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
            popupMenu.show()
        }
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val placeName = view.findViewById(R.id.textViewPlaceName) as AppCompatTextView
        val placeIcon = view.findViewById(R.id.imageViewPlaceIcon) as AppCompatImageView
        val placeRating = view.findViewById(R.id.ratingBarPlace) as AppCompatRatingBar
        val placePriceLevel = view.findViewById(R.id.textViewPriceLevel) as AppCompatTextView
        val placeOptionsButton = view.findViewById(R.id.btnMoreOptions) as AppCompatImageButton
    }
}