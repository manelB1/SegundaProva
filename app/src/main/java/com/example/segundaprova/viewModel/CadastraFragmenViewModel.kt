package com.example.segundaprova.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import com.example.segundaprova.database.AppDatabase
import com.example.segundaprova.database.Televisao

class CadastraFragmenViewModel(application: Application) : AndroidViewModel(application) {

        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "Televisao.sqlite")
                .allowMainThreadQueries()
                .build()
        }

    fun cadastra(televisao: Televisao) {
        db.televisaoDao().inserir(televisao)
    }
}