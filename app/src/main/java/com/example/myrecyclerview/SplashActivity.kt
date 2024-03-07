package com.example.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay untuk menampilkan splash screen selama beberapa detik
        Handler().postDelayed({
            // Setelah delay, buka MainActivity dan tutup SplashActivity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000) // Delay selama 3 detik (3000 milidetik)
    }
}
