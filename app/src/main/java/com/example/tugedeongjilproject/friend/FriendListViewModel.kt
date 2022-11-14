package com.example.tugedeongjilproject.friend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.param.FriendListParam
import com.example.domain.usecase.friend.FriendListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FriendListViewModel @Inject constructor(
    private val friendListUseCase: FriendListUseCase
) : ViewModel() {

    private val _friendListSuccess: MutableLiveData<FriendListParam> = MutableLiveData()
    val friendListSuccess: LiveData<FriendListParam> = _friendListSuccess
    private val _friendListFail: MutableLiveData<String> = MutableLiveData()
    val friendListFail: LiveData<String> = _friendListFail

    fun getFriendList(){
        viewModelScope.launch {
            kotlin.runCatching {
                friendListUseCase.execute(Unit)
            }.onSuccess {
                _friendListSuccess.value = it
            }.onFailure {
                _friendListFail.value = it.message
            }
        }
    }
}