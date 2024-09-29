package com.gema.latihan_10

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailJepunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_jepun)
        val image = intent.getIntExtra("image",0)
        val titlelist = intent.getStringExtra("title")
        val locationlist = intent.getStringExtra("location")
        val tgllist = intent.getStringExtra("tgl")
        val des = intent.getStringExtra("des")

        val imageDetail = findViewById<ImageView>(R.id.a2)
        val a = findViewById<TextView>(R.id.a1)
        val b = findViewById<TextView>(R.id.a3)
        val c = findViewById<TextView>(R.id.a4)
        val d = findViewById<TextView>(R.id.a5)
        imageDetail.setImageResource(image)
        a.setText(titlelist)
        b.setText(locationlist)
        c.setText(tgllist)
        d.setText(des)
       


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}