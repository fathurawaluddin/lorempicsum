package com.d121211050.lorempicsum.data

import com.d121211050.lorempicsum.network.LoremPicsumApiService
import retrofit2.Retrofit
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val loremPicsumRepository: LoremPicsumRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://picsum.photos/v2/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: LoremPicsumApiService by lazy {
        retrofit.create(LoremPicsumApiService::class.java)
    }

    /**
     * DI implementation for Mars photos repository
     */
    override val loremPicsumRepository: LoremPicsumRepository by lazy {
        NetworkLoremPicsumRepository(retrofitService)
    }
}
