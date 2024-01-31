package com.example.enishop.bo

import java.util.Date

data class Article(
    var id : Long = 0,
    var title : String ="",
    var description : String ="",
    var price : Double = 0.0,
    var urlPicture : String = "",
    var date: Date = Date()
){
//    var id : Long
//        get() = _id
//        set(value){
//            _id = value
//        }
}
