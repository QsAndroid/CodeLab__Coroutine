package com.example.codelab____coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel (

    private val repository : Unit

    ) : ViewModel() {

        companion object { }

    private var tapCount = 0

    private val _taps = MutableLiveData<String> ("$tapCount taps")
    val taps : LiveData<String> get() = _taps

    private fun updateTaps () {

        viewModelScope.launch {

            tapCount++

            delay(1_000)

            _taps.postValue( "$tapCount taps")
        }



    }

}