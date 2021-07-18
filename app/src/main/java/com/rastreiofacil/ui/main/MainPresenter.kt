package com.rastreiofacil.ui.main

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.rastreiofacil.model.AddTrack
import com.rastreiofacil.model.FirebaseUserTracking
import com.rastreiofacil.model.Track
import com.rastreiofacil.model.TrackObject
import com.rastreiofacil.service.Api
import com.rastreiofacil.service.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainPresenter: MainContract.Presenter {
    lateinit var view: MainContract.View

    override fun saveTrackCode(trackId: String) {
        val retrofitClient = Service.getBarbeiroServiceInstance()

        val endpoint = retrofitClient.create(Api::class.java)
        val callback = endpoint.addNewPackage(TrackObject(AddTrack(trackId)))

        callback.enqueue(object : Callback<Track> {
            override fun onResponse(call: Call<Track>, response: Response<Track>) {
              when (response.code()){
                  201 -> onSuccess(response.body())
                  400 -> view.encomendaJaAdicionada()
              }
            }

            override fun onFailure(call: Call<Track>, t: Throwable) {

            }

        })
    }

    override fun requestListOfTracks() {
        val uidUser = FirebaseAuth.getInstance().currentUser?.uid
        val firebaseDatabase = FirebaseDatabase.getInstance().getReference("$uidUser")
        firebaseDatabase.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                snapshot.children.forEach {
                    var firebaseUserTracking = it.getValue(FirebaseUserTracking::class.java)
                    firebaseUserTracking?.let {
                        callApi(it)
                    }
                }


            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    private fun callApi(firebaseUserTracking: FirebaseUserTracking) {
        val retrofitClient = Service.getBarbeiroServiceInstance()

        val endpoint = retrofitClient.create(Api::class.java)
        val callback = endpoint.getPackages(firebaseUserTracking.shippingCompany, firebaseUserTracking.trackId)

        callback.enqueue(object: Callback<Track>{
            override fun onResponse(call: Call<Track>, response: Response<Track>) {
                response.body()?.let {
                    view.updateList(it)
                    view.updateRecyclerView()
                }
            }

            override fun onFailure(call: Call<Track>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun onSuccess(track: Track?) {
        val UUID = UUID.randomUUID().toString()
        val uuidUser = FirebaseAuth.getInstance().currentUser?.uid
        track?.data?.tracking?.trackingNumber?.let { trackingNumber ->
            val firebaseUserTracking =
                FirebaseUserTracking()
            firebaseUserTracking.shippingCompany = track?.data?.tracking?.slug
            firebaseUserTracking.trackId = trackingNumber
            uuidUser?.let {
                val firebaseDatabase = FirebaseDatabase.getInstance().getReference("$uuidUser/$UUID")
                firebaseDatabase.setValue(firebaseUserTracking).addOnSuccessListener {
                    view.onSuccess()
                }
            }
        }

    }
}