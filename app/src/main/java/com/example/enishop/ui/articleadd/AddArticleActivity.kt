package com.example.enishop.ui.articleadd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.enishop.bo.Article
import com.example.enishop.databinding.ActivityAddArticleBinding
import com.example.enishop.repository.ArticleRepository
import com.example.enishop.ui.HomeActivity
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

lateinit var binding: ActivityAddArticleBinding

class ActivityAddArticle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val article = ArticleRepository.getArticle(2)
//        Log.i(TAG, article.toString())
        binding.article = Article()

        binding.button.setOnClickListener {
            val currentArticle = binding.article
            //!! force la non nullité d'un élément
            ArticleRepository.addArticle(currentArticle!!)
            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title", currentArticle.title)
                it.putExtra("price", currentArticle.price.toString())
                startActivity(it)
            }


        }

    }
}