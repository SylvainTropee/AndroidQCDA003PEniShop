package com.example.enishop.dao

import com.example.enishop.bo.Article

interface ArticleDAO {

    fun selectById(id :Long) : Article

    fun addNewOne(article: Article) : Long
}