package com.example.enishop.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date


@Parcelize
data class Article(
    var id : Long = 0,
    var title : String ="",
    var description : String ="",
    var price : Double = 0.0,
    var urlPicture : String = "",
    var date: Date = Date()
) : Parcelable {
//    var id : Long
//        get() = _id
//        set(value){
//            _id = value
//        }
}
