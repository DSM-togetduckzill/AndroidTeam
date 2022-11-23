package com.example.domain.usecase.mypage

import com.example.domain.entity.MyPageEntity
import com.example.domain.repository.MyPageRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class MyPageLocalUseCase @Inject constructor(
    private val myPageRepository: MyPageRepository
): UseCase<Unit, MyPageEntity>() {
    override suspend fun execute(data: Unit): MyPageEntity = myPageRepository.loadMyPageLocal()
}