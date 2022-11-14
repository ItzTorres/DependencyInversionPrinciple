package com.example.dependencyinversionprinciple.presentation.mapper

import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto
import com.example.dependencyinversionprinciple.domain.mapper.common.Transform
import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel

class AccountDtoToModelMapper : Transform<AccountDto, AccountModel>() {
    override fun transform(value: AccountDto): AccountModel {
        return with(value) {
            AccountModel(
                productName,
                lastDigits
            )
        }
    }
}