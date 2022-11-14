package com.example.dependencyinversionprinciple.domain.provider

import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

interface HomeAccountsUseCaseProvider {
    fun getAllDebitAccountsInformationUseCase(): List<AccountDto>
    fun getAllCreditAccountsInformationUseCase(): List<AccountDto>
}