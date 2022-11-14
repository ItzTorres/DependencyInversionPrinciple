package com.example.dependencyinversionprinciple.data.datasource.home

import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity

class HomeDebitLocalDataSource() : HomeDebitLocalSource {
    override fun getDebitAccountsInformation(): List<AccountEntity> {
        return listOf(
            AccountEntity(
                productName = "Cuenta Perfiles",
                lastDigits = "**080"
            ),
            AccountEntity(
                productName = "Perfil Ejecutivo",
                lastDigits = "**093"
            ),
            AccountEntity(
                productName = "CuentaPriority",
                lastDigits = "** 965"
            ),
        )
    }
}