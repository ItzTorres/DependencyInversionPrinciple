package com.example.dependencyinversionprinciple.data.datasource.home

import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity

class HomeCreditLocalDataSource: HomeCreditLocalSource {
    override fun getCreditAccountsInformation(): List<AccountEntity> {
        return listOf(
            AccountEntity(
                productName = "Tarj Oro",
                lastDigits = "**081"
            ),
            AccountEntity(
                productName = "Tarj Clasica",
                lastDigits = "**090"
            ),
            AccountEntity(
                productName = "Tarj Cotsco",
                lastDigits = "**961"
            ),
        )
    }
}