package com.example.domain.usecase.mypage

import com.example.domain.entity.MyPageEntity
import com.example.domain.repository.MyPageRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class MyPageUseCase @Inject constructor(
    private val mypageRepository: MyPageRepository
): UseCase<Unit, MyPageEntity>(){
    override suspend fun execute(data: Unit) =mypageRepository.lodeMyPage()
}