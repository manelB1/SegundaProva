package com.example.segundaprova.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.R

class TelevisaoHolder(v: View, idRecevied: Long) : RecyclerView.ViewHolder(v) {
    var id: Long
    var textNomeTelevisao: TextView

    init {
        textNomeTelevisao = v.findViewById(R.id.nomeTelevisao)
        id = idRecevied
    }
}