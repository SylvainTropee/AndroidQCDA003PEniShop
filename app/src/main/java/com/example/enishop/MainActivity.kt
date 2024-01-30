package com.example.enishop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.enishop.repository.ArticleRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val article = ArticleRepository.getArticle(2)
        println(article)


    }
}