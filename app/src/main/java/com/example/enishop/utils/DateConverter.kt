package com.example.enishop.utils

import java.text.SimpleDateFormat
import java.util.Date

object DateConverter {

        private val format = SimpleDateFormat("dd/MM/yyyy")
        @JvmStatic
        fun dateToString(date: Date): String {
            return format.format(date)
        }



}