package com.example.apicalls.data.remote

import com.example.apicalls.data.model.GotCharacter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//whole URL except last endpoint.
const val BASE_URL = "https://thronesapi.com/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GotApiService {
    //@GET = gets the endpoint we want from the BASE_URL.
    @GET("Characters")
    suspend fun getCharacter(): List<GotCharacter>
}

//This is an instance of the ApiService and this object allows the entire app to access the API.
object GotApi {
    val retrofitService: GotApiService by lazy { retrofit.create(GotApiService::class.java) }
}
