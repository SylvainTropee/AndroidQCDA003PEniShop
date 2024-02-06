package com.example.enishop.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enishop.bo.Article
import com.example.enishop.repository.ArticleRepository

class ListArticleViewModel : ViewModel() {

    var articles = MutableLiveData<List<Article>>(emptyList())
    fun getArticleList(): MutableLiveData<List<Article>> {
        articles.value = ArticleRepository.getAllArticles()
        return articles
    }
    fun getRandomArticle() : Article {
        return articles.value!!.random()
    }
}