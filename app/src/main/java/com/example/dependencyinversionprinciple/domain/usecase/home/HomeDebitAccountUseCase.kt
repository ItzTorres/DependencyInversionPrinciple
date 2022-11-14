package com.example.dependencyinversionprinciple.domain.usecase.home

import com.example.dependencyinversionprinciple.data.repository.home.HomeDebitAccountRepository
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

class HomeDebitAccountUseCase(
    private val repository: HomeDebitAccountRepository
) {
    operator fun invoke(): List<AccountDto> {
        return repository.getAllDebitAccountsInformation()
    }
}