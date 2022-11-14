package com.example.dependencyinversionprinciple.data.mapper

import com.example.dependencyinversionprinciple.domain.mapper.common.Transform
import com.example.dependencyinversionprinciple.data.entity.home.AccountEntity
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto

class AccountEntityToDtoMapper: Transform<AccountEntity, AccountDto>() {
    override fun transform(value: AccountEntity): AccountDto {
        return with(value) {
            AccountDto(
                productName,
                lastDigits,
            )
        }
    }
}