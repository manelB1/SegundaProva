package com.example.segundaprova.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Televisao(
    var nome: String,
    var canal: String,
    var classificacao: String,
    var diretor: String,
    var descricao: String,
    var ano: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}
