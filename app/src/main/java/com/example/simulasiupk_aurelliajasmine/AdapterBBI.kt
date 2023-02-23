package com.example.simulasiupk_aurelliajasmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterBBI (private val dataSet: MutableList<DataBBI>) :
        RecyclerView.Adapter<AdapterBBI.BBIHolder>() {
    class BBIHolder (view: View) : RecyclerView.ViewHolder(view) {
        var nama  = view.findViewById<TextView>(R.id.txtNamaRV)
        var tbBdn = view.findViewById<TextView>(R.id.txtTinggiBdnRV)
        var hasil = view.findViewById<TextView>(R.id.txtHasilRV)
        var hapus = view.findViewById<ImageView>(R.id.ImgHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BBIHolder {
        val view = LayoutInflater.from(parent.context).inflate (
            R.layout.activity_adapter_bbi, parent,false
        )
        return BBIHolder(view)
    }

    override fun onBindViewHolder(holder: BBIHolder, position: Int) {
        val data = dataSet[position]
        holder.nama.text = dataSet[position].nama
        holder.tbBdn.text = dataSet[position].tbBdn
        holder.hasil.text = dataSet[position].hasil
        holder.hapus.setOnClickListener {
            dataSet.removeAt(position)
            notifyItemRangeRemoved(position, dataSet.size)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}