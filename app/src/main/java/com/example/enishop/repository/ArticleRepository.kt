package com.example.enishop.repository

import com.example.enishop.bo.Article
import com.example.enishop.dao.ArticleDAO
import com.example.enishop.dao.DaoFactory
import com.example.enishop.dao.DaoType

object ArticleRepository {

    val articleDAO : ArticleDAO = DaoFactory.createArticleDAO(DaoType.MEMORY)

    fun getArticle(id : Long) : Article {
        return articleDAO.selectById(id)
    }

    fun addArticle(article: Article) : Long{
        return articleDAO.addNewOne(article)
    }
}