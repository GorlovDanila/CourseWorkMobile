package com.example.coursework.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coursework.domain.usecase.GetColorRecommendationsUseCase
import com.example.coursework.presentation.entity.ListItem
import com.example.coursework.presentation.mapper.toColorPres
import com.example.coursework.presentation.state.ColorScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class ColorViewModel(
    private val getColorRecommendationsUseCase: GetColorRecommendationsUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<ColorScreenState> = MutableStateFlow(ColorScreenState.Empty)
    val state: StateFlow<ColorScreenState> = _state.asStateFlow()

    fun getRecommendations() {
        viewModelScope.launch {
            _state.emit(ColorScreenState.Loading)
            val result = getColorRecommendationsUseCase.invoke().toColorPres() + ListItem.AdsItem("ADS")
            _state.emit(ColorScreenState.Content(result))
        }
    }
}