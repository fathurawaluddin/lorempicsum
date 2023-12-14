package com.d121211050.lorempicsum.network;

import com.d121211050.lorempicsum.model.LoremPicsumPhoto
import retrofit2.http.GET

/**
 * A public interface that exposes the [getPhotos] method
 */
interface LoremPicsumApiService {
    /**
     * Returns a [List] of [LoremPicsumPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("list")
    suspend fun getPhotos(): List<LoremPicsumPhoto>
}
