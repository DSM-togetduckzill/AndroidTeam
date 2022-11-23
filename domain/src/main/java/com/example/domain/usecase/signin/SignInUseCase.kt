package com.example.domain.usecase.signin

import com.example.domain.entity.SignInEntity
import com.example.domain.entity.TokenEntity
import com.example.domain.repository.SignInRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
): UseCase<SignInEntity, Unit>() {
    override suspend fun execute(data: SignInEntity) =
        signInRepository.signIn(data)
}