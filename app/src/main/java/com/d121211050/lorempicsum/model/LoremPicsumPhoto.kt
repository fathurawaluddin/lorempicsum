package com.d121211050.lorempicsum.model;

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class defines a Mars photo which includes an ID, and the image URL.
 */
@Serializable
data class LoremPicsumPhoto(
    val id: String,
    val author: String,
    val width: String,
    val height: String,
    val url: String,
    @SerialName(value = "download_url")
    val image: String
) {
    // Calculate the new width and height by dividing the original values by 10
    val newWidth: String = (width.toInt() / 10).toString()
    val newHeight: String = (height.toInt() / 10).toString()

    // Create a new URL with the new width and height
    val newUrl: String
        get() = "https://picsum.photos/id/$id/$newWidth/$newHeight"
}
