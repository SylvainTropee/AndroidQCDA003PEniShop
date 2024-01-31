package com.example.enishop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.enishop.bo.Article
import com.example.enishop.databinding.ActivityMainBinding
import com.example.enishop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.util.Date

private const val TAG = "MainActivity"

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val article = ArticleRepository.getArticle(2)
//        Log.i(TAG, article.toString())
        binding.article = Article()

        binding.button.setOnClickListener {
            val currentArticle = binding.article
            Snackbar.make(
                it,
                "Vous venez de créer ${currentArticle?.title} au prix de ${currentArticle?.price} €",
                Snackbar.LENGTH_LONG
            ).show()
        }

    }
}