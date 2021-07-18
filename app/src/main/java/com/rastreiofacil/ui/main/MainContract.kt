package com.rastreiofacil.ui.main

import com.rastreiofacil.model.Track

interface MainContract {
    interface View {
        fun onSuccess()
        fun encomendaJaAdicionada()
        fun updateRecyclerView()
        fun updateList(body: Track)

    }

    interface Presenter {
        fun saveTrackCode(text: String)
        fun requestListOfTracks()
    }
}