package com.mykuyademo.models

import java.io.Serializable

data class Product(
    val name: String,
    val image_name: String
) : Serializable