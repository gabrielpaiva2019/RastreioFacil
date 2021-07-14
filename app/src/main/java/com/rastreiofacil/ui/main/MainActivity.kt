package com.rastreiofacil.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rastreiofacil.R
import com.rastreiofacil.model.AddTrack
import com.rastreiofacil.model.Track
import com.rastreiofacil.model.TrackObject
import com.rastreiofacil.service.Business
import com.rastreiofacil.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MainContract.View {
    val presenter = MainPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.view = this

        val retrofitClient = Service.getBarbeiroServiceInstance()

        val endpoint = retrofitClient.create(Business::class.java)
        val callback = endpoint.addNewPackage(TrackObject(AddTrack("NX105031197BR")))

        callback.enqueue(object : Callback<Track>{
            override fun onResponse(call: Call<Track>, response: Response<Track>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<Track>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}