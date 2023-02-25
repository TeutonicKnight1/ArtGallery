package com.example.artgallery.data.network

import com.example.artgallery.data.models.Arts
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/shows")
    suspend fun getAllArts() : Response<List<Arts>>
}