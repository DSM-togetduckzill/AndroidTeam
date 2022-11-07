package com.example.domain.usecase

import com.example.domain.param.FriendListParam
import com.example.domain.repository.FriendListRepository
import javax.inject.Inject

class FriendListUseCase @Inject constructor(
    private val friendListRepository: FriendListRepository
): UseCase<Unit, FriendListParam>(){
    override suspend fun execute(data: Unit): FriendListParam = friendListRepository.getFriendList()
}