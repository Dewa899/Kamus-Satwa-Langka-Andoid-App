package com.example.myrecyclerview

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Mendapatkan referensi tombol tutup
        val buttonClose: Button = findViewById(R.id.button_close)

        // Menambahkan listener klik pada tombol tutup
        buttonClose.setOnClickListener {
            // Menutup AboutActivity dan kembali ke MainActivity
            finish()
        }
    }
}