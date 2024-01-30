package com.example.enishop.dao.memory

import com.example.enishop.bo.Article
import com.example.enishop.dao.ArticleDAO
import java.util.Date
import java.util.NoSuchElementException

class ArticleDaoMemoryImpl : ArticleDAO {

    private val articlesInMemory: MutableList<Article> = mutableListOf(
        Article(
            1,
            "Souris",
            "Souris sans fil",
            10.0,
            "https://m.media-amazon.com/images/I/61ARJDf28dL.__AC_SX300_SY300_QL70_ML2_.jpg",
            Date()
        ),
        Article(
            2,
            "Ecran",
            "Ecran sans fil",
            800.0,
            "https://m.media-amazon.com/images/I/61uifoCLNtL._SY500_.jpg",
            Date()
        ),
        Article(
            3,
            "Clavier",
            "Clavier sans fil",
            80.0,
            "https://m.media-amazon.com/images/I/71aVWYHmYVL.__AC_SX300_SY300_QL70_ML2_.jpg",
            Date()
        )
    )

    override fun selectById(id: Long): Article {

        var article: Article

        try {
            article = articlesInMemory.first() {
                it.id == id
            }
        } catch (e: NoSuchElementException) {
            article = articlesInMemory[1]
        }
        return article
    }

    override fun addNewOne(article: Article): Long {
        articlesInMemory.add(article)
        article.id = articlesInMemory.size.toLong()
        return article.id
    }
}