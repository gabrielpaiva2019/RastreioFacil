package com.rastreiofacil.service

import com.rastreiofacil.model.AddTrack
import com.rastreiofacil.model.Track
import com.rastreiofacil.model.TrackObject
import retrofit2.Call
import retrofit2.http.*

interface Business {
    @Headers( "aftership-api-key: f86bda08-f035-4d8f-b4a1-b4a83b744135")
    @POST("v4/trackings")
    fun addNewPackage(@Body tracking: TrackObject
    ): Call<Track>


}