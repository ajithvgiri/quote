package com.ajithvgiri.quotes.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

//data class Quote(val id: Int, val author: String, val quote: String)

@Entity(
    tableName = "quotes"
)
data class Quote(

    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "author")
    val author: String,


    @Json(name = "quote")
    val quote: String


) : Serializable