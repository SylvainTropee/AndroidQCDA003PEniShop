package com.example.enishop.utils

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.Date

class DateJsonAdapter {

    @FromJson
    fun jsonToDate(dateString: String): Date {
        return Date()
    }

    @ToJson
    fun dateToJson(date: Date): String {
        return ""
    }


}