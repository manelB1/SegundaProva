package com.example.segundaprova.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.R
import com.example.segundaprova.database.Televisao

class TelevisaoAdapter() : RecyclerView.Adapter<TelevisaoHolder>() {
    var televisaos: List<Televisao> = ArrayList();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelevisaoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.televisao_item, parent, false)

        return TelevisaoHolder(view, 1)
    }

    override fun onBindViewHolder(holder: TelevisaoHolder, position: Int) {
        val empresa = televisaos[position]
        holder.textNomeTelevisao.text = empresa.nome
        holder.id = empresa.id.toLong()
    }

    override fun getItemCount(): Int {
        return televisaos.size
    }
}