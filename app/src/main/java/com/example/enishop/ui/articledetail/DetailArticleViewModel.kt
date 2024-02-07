package com.example.enishop.ui.articledetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.enishop.bo.Article
import com.example.enishop.dao.ArticleDAO
import com.example.enishop.db.ArticleDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailArticleViewModel(private val articleDAO: ArticleDAO) : ViewModel() {

    val fav = MutableLiveData<Boolean>(false)

    fun addArticleToFav(article: Article): MutableLiveData<Long> {
        val id = MutableLiveData<Long>()
        viewModelScope.launch(Dispatchers.IO) {
            id.postValue(articleDAO.addNewOne(article))
        }
        return id
    }

    fun deleteArticleFav(article: Article) {
        viewModelScope.launch(Dispatchers.IO) {
            articleDAO.delete(article)
        }
    }

    fun initCurrentArticle(article: Article){
        viewModelScope.launch(Dispatchers.IO) {
          val articleFav = articleDAO.selectById(article.id)
            if(articleFav != null){
                fav.postValue(true)
            }
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
                return DetailArticleViewModel(
                    ArticleDatabase.getInstance(context).getArticleDAO()
                ) as T
            }
        }
    }

}