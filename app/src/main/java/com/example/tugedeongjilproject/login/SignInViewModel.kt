package com.example.tugedeongjilproject.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.SignInEntity
import com.example.domain.usecase.signin.DeleteAutoSignInUseCase
import com.example.domain.usecase.signin.FetchAutoSignInUseCase
import com.example.domain.usecase.signin.SaveAutoSignInUseCase
import com.example.domain.usecase.signin.SignInUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase,
    private val saveAutoSignInUseCase: SaveAutoSignInUseCase,
    private val fetchAutoSignInUseCase: FetchAutoSignInUseCase,
    private val deleteAutoSignInUseCase: DeleteAutoSignInUseCase
): ViewModel(){

    fun signIn(signInEntity: SignInEntity){
        viewModelScope.launch {
            kotlin.runCatching {
                signInUseCase.execute(signInEntity)
            }.onSuccess {

            }.onFailure {

            }
        }
    }

    fun saveAutoSignIn(signInEntity: SignInEntity){

    }

    fun fetchAutoSignIn(){

    }

    fun deleteAutoSignIn() {

    }
}