package com.example.enishop.dao

import com.example.enishop.dao.memory.ArticleDaoMemoryImpl
import com.example.enishop.dao.network.ArticleDaoNetworkImpl

abstract class DaoFactory {

    companion object{
        fun createArticleDAO(type: DaoType): ArticleDAO {
            val articleDAO: ArticleDAO = when (type) {
                DaoType.MEMORY -> ArticleDaoMemoryImpl()
                DaoType.NETWORK -> ArticleDaoNetworkImpl()
            }
            return articleDAO
        }

    }

}