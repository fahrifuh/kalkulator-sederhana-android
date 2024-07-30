package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class LatihanKalkulator : AppCompatActivity() {
    var operasi: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_latihan_kalkulator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val input1: EditText = findViewById(R.id.input1)
        val input2: EditText = findViewById(R.id.input2)
        val btnTambah: Button = findViewById(R.id.btn1)
        val btnKurang: Button = findViewById(R.id.btn2)
        val btnKali: Button = findViewById(R.id.btn3)
        val btnBagi: Button = findViewById(R.id.btn4)
        val btnEqual: Button = findViewById(R.id.btn5)
        val txthasil: TextView = findViewById(R.id.txthasil)

        btnEqual.isEnabled = false

        btnTambah.setOnClickListener{
            operasi = "tambah"
            btnEqual.isEnabled = true
        }
        btnKurang.setOnClickListener{
            operasi = "kurang"
            btnEqual.isEnabled = true
        }
        btnKali.setOnClickListener{
            operasi = "kali"
            btnEqual.isEnabled = true
        }
        btnBagi.setOnClickListener{
            operasi = "bagi"
            btnEqual.isEnabled = true
        }
        btnEqual.setOnClickListener{
            val input1 = input1.text.toString().toDoubleOrNull()
            val input2 = input2.text.toString().toDoubleOrNull()
            if(input1 != null && input2 != null){
                val hasil = when(operasi){
                    "tambah" -> input1 + input2
                    "kurang" -> input1 - input2
                    "kali" -> input1 * input2
                    "bagi" -> input1 / input2
                    else -> 0.0
                }
                txthasil.text = "Hasil: $hasil"
            }
            else{
                txthasil.text = "Kesalahan"
                Toast.makeText(this, "Input angka terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
            btnEqual.isEnabled = false
        }
    }
}