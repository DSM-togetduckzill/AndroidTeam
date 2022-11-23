package com.example.tugedeongjilproject.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.MyPageEntity
import com.example.domain.usecase.mypage.MyPageLocalUseCase
import com.example.domain.usecase.mypage.MyPageUseCase
import com.example.tugedeongjilproject.util.loginErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor (
    private val myPageUseCase: MyPageUseCase,
    private val myPageLocalUseCase: MyPageLocalUseCase
): ViewModel(){

    private val _mypageInSuccess : MutableLiveData<MyPageEntity> = MutableLiveData()
    val mypageInSuccess: LiveData<MyPageEntity> = _mypageInSuccess
    private val _fail: MutableLiveData<String> = MutableLiveData()
    val fail: LiveData<String> = _fail

    fun lodeMyPage() {
        viewModelScope.launch {
            kotlin.runCatching {
                myPageUseCase.execute(data = Unit)
            }.onSuccess {
                _mypageInSuccess.value = it
            }.onFailure {
                _fail.value = loginErrorHandler(it.message.toString())
                loadMyPageLocal()
            }
        }
    }

    fun loadMyPageLocal() {
        viewModelScope.launch {
            kotlin.runCatching {
                myPageLocalUseCase.execute(Unit)
            }.onSuccess {
                _mypageInSuccess.value = it
            }
        }
    }
}