package com.example.tugedeongjilproject.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugedeongjilproject.util.loginErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor (
): ViewModel(){

    private val _mypageInSuccess : MutableLiveData<Boolean> = MutableLiveData()
    val mypageInSuccess: LiveData<Boolean> = _mypageInSuccess
    private val _fail: MutableLiveData<String> = MutableLiveData()
    val fail: LiveData<String> = _fail

    fun lodeMyPage() {
        viewModelScope.launch {
            kotlin.runCatching {
            }.onSuccess {
            }.onFailure {
                _fail.value = loginErrorHandler(it.message.toString())
            }
        }
    }
}