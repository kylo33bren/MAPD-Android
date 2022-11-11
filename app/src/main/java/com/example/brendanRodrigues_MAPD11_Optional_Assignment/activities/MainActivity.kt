package com.example.brendanRodrigues_MAPD11_Optional_Assignment.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.adapter.FragranceListAdapter
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.R
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.retrofit.RetroInstance
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.interfaces.RetroServiceInterface
import com.example.brendanRodrigues_MAPD11_Optional_Assignment.model.ApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FragranceListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)

        makeAPICall()
    }

    // function for API call
    private fun makeAPICall() {
        val retroInstance: Retrofit? = RetroInstance.getRetroInstance()
        val retroService = retroInstance?.create(RetroServiceInterface::class.java)
        val call = retroService?.getFragrances()
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        call?.enqueue(object : Callback<ApiModel?> {
            override fun onResponse(call: Call<ApiModel?>, response: Response<ApiModel?>) {
               // if else statement for checking response

                if (response.isSuccessful){
                    var result = response.body()?.products
                    result?.let {
                        adapter = FragranceListAdapter(it)
                    }
                    Log.d("##TAG", "onResponse: "+response.body())
                    recyclerView.adapter = adapter
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@MainActivity, "result", Toast.LENGTH_SHORT).show()
                }

            }

            // failure statement
            override fun onFailure(call: Call<ApiModel?>, t: Throwable) {
                Log.d("MakeAPICall", "onFailure$t")
            }
        })
    }
}