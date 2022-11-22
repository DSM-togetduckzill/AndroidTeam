package com.example.tugedeongjilproject.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.SignInEntity
import com.example.domain.usecase.signin.AutoSignInUseCase
import com.example.domain.usecase.signin.DeleteAutoSignInUseCase
import com.example.domain.usecase.signin.ChangeAutoSignInUseCase
import com.example.domain.usecase.signin.SaveAutoSignInUseCase
import com.example.domain.usecase.signin.SignInUseCase
import com.example.tugedeongjilproject.util.basicErrorHandler
import com.example.tugedeongjilproject.util.loginErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val autoSignInUseCase: AutoSignInUseCase ,
    private val saveAutoSignInUseCase: SaveAutoSignInUseCase,
    private val changeAutoSignInUseCase: ChangeAutoSignInUseCase,
    private val deleteAutoSignInUseCase: DeleteAutoSignInUseCase
): ViewModel(){

    private val _signInSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val signInSuccess: LiveData<Boolean> = _signInSuccess
    private val _fail: MutableLiveData<String> = MutableLiveData()
    val fail: LiveData<String> = _fail

    fun signIn(signInEntity: SignInEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                signInUseCase.execute(signInEntity)
            }.onSuccess {
                _signInSuccess.value = true
            }.onFailure {
                _fail.value = loginErrorHandler(it.message.toString())
            }
        }
    }

    fun autoSignIn() {
        viewModelScope.launch {
            kotlin.runCatching {
                autoSignInUseCase.execute(Unit)
            }.onSuccess {
                _signInSuccess.value = true
            }
        }
    }

    fun saveAutoSignIn(signInEntity: SignInEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                saveAutoSignInUseCase.execute(signInEntity)
            }
        }
    }

    fun fetchAutoSignIn(signInEntity: SignInEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                changeAutoSignInUseCase.execute(signInEntity)
            }
        }
    }

    fun deleteAutoSignIn() {
        viewModelScope.launch {
            kotlin.runCatching {
                deleteAutoSignInUseCase.execute(Unit)
            }
        }
    }
}