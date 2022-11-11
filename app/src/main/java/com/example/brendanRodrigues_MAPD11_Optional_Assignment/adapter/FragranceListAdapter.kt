package com.example.brendanRodrigues_MAPD11_Optional_Assignment.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.R
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.activities.DetailsActivity
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.model.Product

// function for adapter
class FragranceListAdapter (private val liveDataList: List<Product>):
    RecyclerView.Adapter<FragranceListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.list_adapter_layout, parent, false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(liveDataList[holder.adapterPosition])
    }

    override fun getItemCount(): Int {
        return liveDataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var brand: TextView
        var rating: TextView
        var desc: TextView
        var image: ImageView
        var parent:CardView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            brand = itemView.findViewById(R.id.brand)
            rating = itemView.findViewById(R.id.rating)
            desc = itemView.findViewById(R.id.desc)
            image = itemView.findViewById(R.id.image)
            parent = itemView.findViewById(R.id.parentContainer)

        }

        fun bind(data: Product) {
            itemName.text = data.title
            brand.text = data.brand
            rating.text = data.rating.toString()
            desc.text = data.description
            var uri = Uri.parse(data.thumbnail)
            Log.d("##TAG", "bind: $uri")
            Glide.with(image.context)
                .load(uri)
                .into(image)

            parent.setOnClickListener {
                parent.context.startActivity(Intent(parent.context,DetailsActivity::class.java).putExtra("model",data))
            }


        }
    }
}