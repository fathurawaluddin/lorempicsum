package com.d121211050.lorempicsum.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211050.lorempicsum.LoremPicsumApplication
import com.d121211050.lorempicsum.data.LoremPicsumRepository
import com.d121211050.lorempicsum.model.LoremPicsumPhoto
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * UI state for the Home screen
 */
sealed interface LoremPicsumUiState {
    data class Success(val photos: List<LoremPicsumPhoto>) : LoremPicsumUiState
    object Error : LoremPicsumUiState
    object Loading : LoremPicsumUiState
}

class LoremPicsumViewModel(private val loremPicsumRepository: LoremPicsumRepository) : ViewModel() {
    /** The mutable State that stores the status of the most recent request */
    var loremPicsumUiState: LoremPicsumUiState by mutableStateOf(LoremPicsumUiState.Loading)
        private set

    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getLoremPicsum()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getLoremPicsum() {
        viewModelScope.launch {
            loremPicsumUiState = LoremPicsumUiState.Loading
            loremPicsumUiState = try {
                LoremPicsumUiState.Success(loremPicsumRepository.getLoremPicsum())
            } catch (e: IOException) {
                LoremPicsumUiState.Error
            } catch (e: HttpException) {
                LoremPicsumUiState.Error
            }
        }
    }

    /**
     * Factory for [MarsViewModel] that takes [MarsPhotosRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as LoremPicsumApplication)
                val loremPicsumRepository = application.container.loremPicsumRepository
                LoremPicsumViewModel(loremPicsumRepository = loremPicsumRepository)
            }
        }
    }
}
