package com.example.enishop.services

import com.example.enishop.bo.Article
import com.example.enishop.utils.DateJsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    companion object {

        val BASE_URL = "https://fakestoreapi.com/"

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).add(DateJsonAdapter()).build()

        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .baseUrl(BASE_URL)
                .build()
    }

    @GET("products")
    suspend fun getAllArticles(): List<Article>

    @GET("products/{id}")
    suspend fun getArticleById(@Path("id") id: Long): Article

    @POST("products")
    suspend fun addArticle(@Body article: Article): Article

    object ArticleApi {
        val retrofitService by lazy { retrofit.create(ArticleService::class.java) }
    }

}