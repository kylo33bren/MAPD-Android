package com.example.brendanRodrigues_MAPD11_Optional_Assignment.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.R
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.model.Product

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        initialization()
    }

    private fun initialization(){
        val itemName = findViewById<TextView>(R.id.itemName)
        val brand = findViewById<TextView>(R.id.brand)
        val rating = findViewById<TextView>(R.id.rating)
        val description = findViewById<TextView>(R.id.desc)
        var thumbnailIV = findViewById<ImageView>(R.id.thumbnailIV)

        val intent = intent
        val product: Product? = intent.getSerializableExtra("model") as Product?

        // display card
        product?.let {
            itemName.text = it.title
            brand.text = it.brand
            rating.text = it.rating.toString()
            description.text = it.description
            Glide.with(this).load(it.thumbnail).into(thumbnailIV)
        }



    }
}