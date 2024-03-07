package com.example.myrecyclerview

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var photo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) R.layout.activity_detail_land else R.layout.activity_detail)

        // Inisialisasi tampilan UI
        name = findViewById(R.id.tv_item_name)
        description = findViewById(R.id.tv_item_description)
        photo = findViewById(R.id.img_item_photo)

        // Ambil data yang dikirimkan dari MainActivity
        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)

        // Atur data yang diambil ke tampilan UI
        this.name.text = name
        this.description.text = description
        this.photo.setImageResource(photo)

        val shareButton = findViewById<Button>(R.id.action_share)

        shareButton.setOnClickListener {
            val description = findViewById<TextView>(R.id.tv_item_description).text.toString()

            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, description)

            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_PHOTO = "extra_photo"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed() // Kembali ke activity sebelumnya
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }




}