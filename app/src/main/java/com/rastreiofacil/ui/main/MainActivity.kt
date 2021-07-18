package com.rastreiofacil.ui.main

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.rastreiofacil.R
import com.rastreiofacil.model.Track
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {
    lateinit var dialogNewTrack: Dialog
    private val presenter = MainPresenter()
    private val trackingList: MutableList<Track> = mutableListOf()
    lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.view = this

        configListeners()
        configAuth()
        verifyListTrack()

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        recyclerViewPacotes.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(trackingList)
        recyclerViewPacotes.adapter = adapter
    }

    private fun verifyListTrack() {
        presenter.requestListOfTracks()
    }

    private fun configAuth() {
        if (FirebaseAuth.getInstance().currentUser == null){
            FirebaseAuth.getInstance().signInAnonymously()
        }
    }

    private fun configListeners() {
        imageViewAddNewTrack.setOnClickListener { openDialogAddTrack() }
    }

    private fun openDialogAddTrack() {
        dialogNewTrack = Dialog(this)
        dialogNewTrack.setCancelable(false)
        dialogNewTrack.setTitle("rastrear novo pacote")
        dialogNewTrack.setContentView(R.layout.dialog_add_tracking)

        val editTextAddNewTrack = dialogNewTrack.findViewById<EditText>(R.id.editTextAddNewTrack)
        val buttonAddTrack = dialogNewTrack.findViewById<Button>(R.id.buttonAddTrack)

        buttonAddTrack.setOnClickListener {
            presenter.saveTrackCode(editTextAddNewTrack.text.toString())
        }

        dialogNewTrack.show()
    }

    override fun onSuccess() {
        dialogNewTrack.dismiss()
        trackingList.clear()
        verifyListTrack()
    }

    override fun encomendaJaAdicionada() {

    }

    override fun updateRecyclerView() {
        adapter.notifyDataSetChanged()
    }

    override fun updateList(track: Track) {
        trackingList.add(track)
    }


}