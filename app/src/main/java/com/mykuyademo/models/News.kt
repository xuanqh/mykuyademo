package com.mykuyademo.models

import java.io.Serializable

data class News(
    val title: String,
    val demand: String,
    val image_name: String
) : Serializable