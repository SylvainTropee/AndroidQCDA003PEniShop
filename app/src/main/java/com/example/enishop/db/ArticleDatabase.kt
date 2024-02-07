package com.example.enishop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.enishop.bo.Article
import com.example.enishop.dao.ArticleDAO
import com.example.enishop.utils.DateRoomConverter

@Database(entities = [Article::class], version = 1)
@TypeConverters(DateRoomConverter::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDAO(): ArticleDAO

    companion object {

        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase {

            var instance = INSTANCE

            if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "eni_shop"
                ).fallbackToDestructiveMigration().build()

                INSTANCE = instance
            }
            return instance
        }

    }


}