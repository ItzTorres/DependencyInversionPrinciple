package com.example.dependencyinversionprinciple.data.repository.home

import com.example.dependencyinversionprinciple.data.datasource.home.HomeCreditLocalSource
import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto
import com.example.dependencyinversionprinciple.domain.mapper.common.Transform

class HomeCreditAccountDataRepository(
    private val dataSource: HomeCreditLocalSource,
    private val mapper: Transform<AccountEntity, AccountDto>,
    ) : HomeCreditAccountRepository {
    override fun getAllCreditAccountsInformation(): List<AccountDto> {
        return dataSource
            .getCreditAccountsInformation()
            .map {
                mapper.transform(it)
            }
    }
}