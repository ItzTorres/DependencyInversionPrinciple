package com.example.dependencyinversionprinciple.data.datasource.home

import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity

interface HomeDebitLocalSource {
     fun getDebitAccountsInformation(): List<AccountEntity>
}