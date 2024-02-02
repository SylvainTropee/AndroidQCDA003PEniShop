package com.example.enishop.ui.articleadd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.enishop.bo.Article
import com.example.enishop.databinding.ActivityAddArticleBinding
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

lateinit var binding: ActivityAddArticleBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
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