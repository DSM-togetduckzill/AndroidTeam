package com.example.domain.usecase.signin

import com.example.domain.repository.SignInRepository
import com.example.domain.usecase.UseCase
import javax.inject.Inject

class AutoSignInUseCase @Inject constructor(
    private val signInRepository: SignInRepository
): UseCase<Unit, Unit>(){
    override suspend fun execute(data: Unit) = signInRepository.autoSignIn()
}