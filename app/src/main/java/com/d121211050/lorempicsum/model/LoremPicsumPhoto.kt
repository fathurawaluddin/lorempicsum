package com.d121211050.lorempicsum.model;

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class defines a Lorem Picsum photo which includes an ID, and the image URL.
 */
@Serializable
data class LoremPicsumPhoto(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "author")
    val author: String,
    @SerialName(value = "width")
    val width: Int,
    @SerialName(value = "height")
    val height: Int,
    @SerialName(value = "url")
    val url: String,
    @SerialName(value = "download_url")
    val image: String
) {
    // Calculate the new width and height by dividing the original values by 10
    val newWidth: Int = width / 10
    val newHeight: Int = height / 10

    // Create a new URL with the new width and height
    val newUrl: String
        get() = "https://picsum.photos/id/$id/$newWidth/$newHeight"
}
