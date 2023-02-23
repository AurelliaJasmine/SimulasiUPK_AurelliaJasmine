package com.example.simulasiupk_aurelliajasmine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var Bbdn : Int = 0
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var nama  = findViewById<EditText>(R.id.txtNama)
        var tbBdn = findViewById<EditText>(R.id.txtTinggiBdn)
        var hasil = findViewById<TextView>(R.id.txtHasil)
        var jkLK  = findViewById<RadioButton>(R.id.rbLK)
        var jkPR = findViewById<RadioButton>(R.id.rbPR)
        var hitung = findViewById<Button>(R.id.btnHitung)
        var simpan = findViewById<Button>(R.id.btnSimpan)
        var reset = findViewById<Button>(R.id.btnReset)
        recyclerView = findViewById(R.id.ListData)

        val data = mutableListOf<DataBBI>()
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerAdapter = AdapterBBI(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager

        simpan.setOnClickListener {
            val nama = nama.text.toString()
            val tbBdn = tbBdn.text.toString()
            val hasil = hasil.text.toString()

            val dataBbi = DataBBI (nama, tbBdn, hasil)
            data.add(dataBbi)
            recyclerAdapter.notifyDataSetChanged()
        }

        hitung.setOnClickListener {
            var tinggi = tbBdn.text.toString().toInt()

            if (jkLK.isChecked) {
                Bbdn = (tinggi - 100) - ((tinggi - 100) * 10/100)
                hasil.setText(Bbdn.toString() + "kg")
            } else if (jkPR.isChecked) {
                Bbdn = (tinggi - 100) - ((tinggi - 100) * 15/100)
                hasil.setText(Bbdn.toString() + "kg")
            } else {
                hasil.setText("Pilih Jenis Kelamin terlebih dahulu")
            }

        }

        reset.setOnClickListener {
            hasil.text = 0.toString()
            nama.text.clear()
            tbBdn.text.clear()
        }
    }
}