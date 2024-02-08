package com.example.enishop.bo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.util.Date


@Parcelize
@Entity
data class Article(
    @PrimaryKey(autoGenerate = false)
    var id: Long = 0,
    var title: String = "",
    var description: String = "",
    var price: Double = 0.0,
    @Json(name = "image")
    var urlPicture: String = "",
    var date: Date = Date()
) : Parcelable {
//    var id : Long
//        get() = _id
//        set(value){
//            _id = value
//        }
}
