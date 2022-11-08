package com.example.domain.usecase.friend

import com.example.domain.param.FriendListParam
import com.example.domain.repository.FriendListRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class FriendListUseCase @Inject constructor(
    private val friendListRepository: FriendListRepository
): UseCase<Unit, FriendListParam>(){
    override suspend fun execute(data: Unit): FriendListParam = friendListRepository.getFriendList()
}