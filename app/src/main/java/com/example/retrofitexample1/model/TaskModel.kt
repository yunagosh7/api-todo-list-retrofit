package com.example.retrofitexample1.model

import com.squareup.moshi.Json

data class TaskModel(
    @Json(name = "userId") val userId: Int,
    @Json(name = "title") val title: String,
    @Json(name = "completed") val completed: Boolean
)
