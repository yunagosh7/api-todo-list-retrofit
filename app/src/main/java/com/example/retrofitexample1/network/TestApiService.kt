package com.example.retrofitexample1.network

import com.example.retrofitexample1.model.TaskModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface TestApiService {
    @GET("todos")
    suspend fun getData(): List<TaskModel>
}


// Singleton del objeto que va a hacer las peticiones
object TestApi {
    /**
     * El by lazy se utiliza crear una propiedad delegada que solo se inicializa cuando se accede a
     * ella por primera vez. Esto es util en casos en el que la funcion va a realizar un proceso que
     * va a tardar mucho en inicializarse.
     * La delegacion de propiedades permite que un objeto auxiliar se encargue de la logica de los getters
     * y setters de una propiedad.
     */
    val retrofitService: TestApiService by lazy {
        retrofit.create(TestApiService::class.java)
    }
}

