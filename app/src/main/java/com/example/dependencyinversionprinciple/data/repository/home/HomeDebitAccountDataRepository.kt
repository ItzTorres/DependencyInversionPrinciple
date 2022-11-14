package com.example.dependencyinversionprinciple.data.repository.home

import com.example.dependencyinversionprinciple.data.datasource.home.HomeDebitLocalSource
import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto
import com.example.dependencyinversionprinciple.domain.mapper.common.Transform

class HomeDebitAccountDataRepository(
    private val dataSource: HomeDebitLocalSource,
    private val mapper: Transform<AccountEntity, AccountDto>,
) : HomeDebitAccountRepository {
    override fun getAllDebitAccountsInformation() : List<AccountDto> {
        return dataSource
            .getDebitAccountsInformation()
            .map {
                mapper.transform(it)
            }
    }
}