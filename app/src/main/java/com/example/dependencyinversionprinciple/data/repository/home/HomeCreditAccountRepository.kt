package com.example.dependencyinversionprinciple.data.repository.home

import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

interface HomeCreditAccountRepository {
    fun getAllCreditAccountsInformation(): List<AccountDto>
}