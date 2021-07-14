package com.rastreiofacil.model

import com.google.gson.annotations.SerializedName

data class AddTrack(
    @SerializedName("tracking_number")
    val tracking: String
    )

data class TrackObject(
    @SerializedName("tracking")
    val trackObject: AddTrack
    )
