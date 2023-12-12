package com.d121211050.lorempicsum.data

import com.d121211050.lorempicsum.model.LoremPicsumPhoto
import com.d121211050.lorempicsum.network.LoremPicsumApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface LoremPicsumRepository {
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getLoremPicsum(): List<LoremPicsumPhoto>
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkLoremPicsumRepository(
    private val loremPicsumApiService: LoremPicsumApiService
) : LoremPicsumRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getLoremPicsum(): List<LoremPicsumPhoto> = loremPicsumApiService.getPhotos()
}
