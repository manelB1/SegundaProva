package com.example.segundaprova.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Televisao::class], version = 1)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun televisaoDao(): TelevisaoDAO
}