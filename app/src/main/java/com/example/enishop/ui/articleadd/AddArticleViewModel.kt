package com.example.enishop.ui.articleadd

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.enishop.bo.Article
import com.example.enishop.repository.ArticleRepository
import com.example.enishop.utils.DateConverter

private const val TAG = "AddArticleViewModel"

class AddArticleViewModel : ViewModel() {

    var article = Article()
    var date: String = ""
    fun addArticle() {
        val currentArticle = article
        currentArticle.date = DateConverter.stringToDate(date)
        ArticleRepository.addArticle(currentArticle)
    }

}