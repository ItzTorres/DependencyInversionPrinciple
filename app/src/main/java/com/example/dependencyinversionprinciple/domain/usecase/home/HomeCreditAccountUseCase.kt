package com.example.dependencyinversionprinciple.domain.usecase.home

import com.example.dependencyinversionprinciple.data.repository.home.HomeCreditAccountRepository
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

class HomeCreditAccountUseCase(
    private val repository: HomeCreditAccountRepository
) {
    operator fun invoke(): List<AccountDto> {
        return repository.getAllCreditAccountsInformation()
    }
}