package com.example.enishop.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.enishop.bo.Article
import com.example.enishop.dao.ArticleDAO
import com.example.enishop.db.ArticleDatabase
import com.example.enishop.repository.ArticleRepository
import com.example.enishop.services.ArticleService
import com.example.enishop.ui.articledetail.DetailArticleViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListArticleViewModel(private val articleDAO: ArticleDAO) : ViewModel() {

    var articles = MutableLiveData<List<Article>>(emptyList())
    fun getArticleList() {
        viewModelScope.launch(Dispatchers.IO) {
            articles.postValue(ArticleService.ArticleApi.retrofitService.getAllArticles())
        }

    }

    fun getRandomArticle(): Article {
        return articles.value!!.random()
    }

    fun getArticlesFav(){
        viewModelScope.launch(Dispatchers.IO) {
            articles.postValue(articleDAO.selectAll())
        }
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {

                val context =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return ListArticleViewModel(
                    ArticleDatabase.getInstance(context).getArticleDAO()
                ) as T
            }
        }
    }

}