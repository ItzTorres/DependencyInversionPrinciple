package com.example.dependencyinversionprinciple.data.repository.home

import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

interface HomeDebitAccountRepository {
    fun getAllDebitAccountsInformation(): List<AccountDto>
}