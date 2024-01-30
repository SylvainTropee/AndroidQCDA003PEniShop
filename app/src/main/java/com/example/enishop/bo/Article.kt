package com.example.enishop.bo

import java.util.Date

data class Article(
    var id : Long,
    var title : String,
    var description : String,
    var price : Double,
    var urlPicture : String,
    var date: Date
){
//    var id : Long
//        get() = _id
//        set(value){
//            _id = value
//        }
}
