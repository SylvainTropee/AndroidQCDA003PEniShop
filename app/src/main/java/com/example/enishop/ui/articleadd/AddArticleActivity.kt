package com.example.enishop.ui.articleadd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.enishop.bo.Article
import com.example.enishop.databinding.ActivityAddArticleBinding
import com.example.enishop.repository.ArticleRepository
import com.example.enishop.ui.HomeActivity
import com.google.android.material.snackbar.Snackbar

private const val TAG = "MainActivity"

class ActivityAddArticle : AppCompatActivity() {

    lateinit var binding: ActivityAddArticleBinding
    lateinit var vm: AddArticleViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[AddArticleViewModel::class.java]

//        val article = ArticleRepository.getArticle(2)
//        Log.i(TAG, article.toString())
        binding.vm = vm

        binding.button.setOnClickListener {
            val currentArticle = vm.article
            vm.addArticle()
            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title", currentArticle.title)
                it.putExtra("price", currentArticle.price.toString())
                startActivity(it)
            }


        }

    }
}