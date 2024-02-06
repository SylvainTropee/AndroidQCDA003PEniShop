package com.example.enishop.utils

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

private const val TAG = "DateConverter"

object DateConverter {

    private val format = SimpleDateFormat("dd/MM/yyyy")

    @JvmStatic
    fun dateToString(date: Date): String {
        return format.format(date)
    }

    fun stringToDate(text: String): Date {

        var date: Date
        try {
            date = format.parse(text)
        } catch (e: ParseException) {
            Log.i(TAG, "stringToDate: ")
            date = Date()
        }

        return date
    }


}