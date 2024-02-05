package com.example.enishop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.enishop.R
import com.example.enishop.ui.articleadd.ActivityAddArticle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")

        findViewById<FloatingActionButton>(R.id.fabToDetailArticle).setOnClickListener {
            Intent(this, ActivityAddArticle::class.java).also {
                startActivity(it)
            }
        }

        if (title != null && price != null) {
            Snackbar.make(
                findViewById(R.id.homeLayout),
                "Vous venez de créer ${title} au prix de ${price} €",
                Snackbar.LENGTH_LONG
            ).show()
        }


    }
}