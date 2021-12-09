package com.developx.poi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class POIDetailActivity : AppCompatActivity() {

    companion object{
        const val NAME_PLACE        = "name"
        const val PLACE_DESCRIPTION = "description"
        const val PLACE_INFORMATION = "information"
        const val PLACE_TEMPERATURE = "temperature"
        const val PLACE_LOCATION    = "location"
        const val PLACE_IMAGE_URL   = "image_url"
        const val PLACE_LATITUDE   = "latitude"
        const val PLACE_LONGITUDE   = "longitude"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poi_detail)

        var tvTitlePlace = findViewById<TextView>( R.id.tv_title_place )
        var tvInfoGral = findViewById<TextView>( R.id.tv_info_gral )
        var tvUbication = findViewById<TextView>( R.id.tv_ubication )
        var tvTemperature = findViewById<TextView>( R.id.tv_temperature )
        var tvDescription = findViewById<TextView>( R.id.tv_description )
        var ivImagePlace = findViewById<ImageView>( R.id.iv_image_place )

        var bundle = intent.extras

        var name = bundle?.getString( NAME_PLACE )
        var description = bundle?.getString( PLACE_DESCRIPTION )
        var information = bundle?.getString( PLACE_INFORMATION )
        var temperature = bundle?.getDouble( PLACE_TEMPERATURE )
        var location = bundle?.getString( PLACE_LOCATION )
        var image_url = bundle?.getString( PLACE_IMAGE_URL )

        var latitude = bundle?.getDouble( PLACE_LATITUDE )
        var longitude = bundle?.getDouble( PLACE_LONGITUDE )

        /*Log.d("Paquito ", latitude.toString())*/
        tvTitlePlace.text = name
        tvInfoGral.text= information
        tvUbication.text = location
        tvTemperature.text = temperature.toString()
        tvDescription.text = description
        Picasso.get().load( image_url ).into( ivImagePlace )

        val icLocation = findViewById<ImageView>(R.id.iv_location)
        icLocation.setOnClickListener {
            val intent = Intent(this,POIMapActivity::class.java)
            intent.putExtra(PLACE_LATITUDE, latitude)
            intent.putExtra(PLACE_LONGITUDE, longitude)
            intent.putExtra(NAME_PLACE, name)
            startActivity(intent)
        }
    }
}