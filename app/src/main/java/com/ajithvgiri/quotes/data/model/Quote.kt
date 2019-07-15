/*------------------------------------------------------------------------------
 -  Created by ajithvgiri on 22/11/18 10:44 PM
 -  Copyright (c) 2018 . All rights reserved.
 -  Last modified 21/11/18 1:08 AM
 -
 -----------------------------------------------------------------------------*/
package com.ajithvgiri.quotes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

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