package com.enesk.store_app.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enesk.store_app.domain.use_cases.get_home_data.GetHomeDataUseCase
import com.enesk.store_app.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase : GetHomeDataUseCase
): ViewModel() {

    private val _homeState = mutableStateOf(HomeState())
    val homeState : State<HomeState> = _homeState

    init {
        getAllHomeData()
    }

    private fun getAllHomeData(){
        getHomeDataUseCase().onEach { result ->
            when(result){
                is Resource.Loading -> {
                    _homeState.value = HomeState(isLoading = true)
                }
                is Resource.Success -> {
                    _homeState.value = HomeState(homeData = result.data)
                }
                is Resource.Error -> {
                    _homeState.value = HomeState(error = result.error.errorDescription)
                }
            }
        }.launchIn(viewModelScope)
    }
}