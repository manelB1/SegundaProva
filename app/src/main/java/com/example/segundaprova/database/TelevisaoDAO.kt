package com.example.segundaprova.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TelevisaoDAO {
    @Insert
    fun inserir(televisao: Televisao): Long

    @Delete
    fun deletar(televisao: Televisao): Int

    @Update
    fun atualizar(televisao: Televisao)

    @Query("SELECT * FROM Televisao")
    fun listAll(): LiveData<List<Televisao>>

    @Query("SELECT * FROM Televisao WHERE id = :id")
    fun findById(id: Long): Televisao
}