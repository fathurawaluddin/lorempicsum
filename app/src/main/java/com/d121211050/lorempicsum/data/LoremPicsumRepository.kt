package com.d121211050.lorempicsum.data

import com.d121211050.lorempicsum.model.LoremPicsumPhoto
import com.d121211050.lorempicsum.network.LoremPicsumApiService

/**
 * Repository that fetch LoremPicsum photos list from loremPicsumApi.
 */
interface LoremPicsumRepository {
    /** Fetches list of LoremPicsumPhoto from loremPicsumApi */
    suspend fun getLoremPicsum(): List<LoremPicsumPhoto>
}

/**
 * Network Implementation of Repository that fetch Lorem Picsum photos list from marsApi.
 */
class NetworkLoremPicsumRepository(
    private val loremPicsumApiService: LoremPicsumApiService
) : LoremPicsumRepository {
    /** Fetches list of LoremPicsumPhoto from loremPicsumApi*/
    override suspend fun getLoremPicsum(): List<LoremPicsumPhoto> = loremPicsumApiService.getPhotos()
}
