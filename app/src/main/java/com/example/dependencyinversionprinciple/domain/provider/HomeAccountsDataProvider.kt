package com.example.dependencyinversionprinciple.domain.provider

import com.example.dependencyinversionprinciple.data.datasource.home.HomeCreditLocalDataSource
import com.example.dependencyinversionprinciple.data.datasource.home.HomeCreditLocalSource
import com.example.dependencyinversionprinciple.data.datasource.home.HomeDebitLocalDataSource
import com.example.dependencyinversionprinciple.data.datasource.home.HomeDebitLocalSource
import com.example.dependencyinversionprinciple.data.mapper.AccountEntityToDtoMapper
import com.example.dependencyinversionprinciple.data.repository.home.HomeCreditAccountDataRepository
import com.example.dependencyinversionprinciple.data.repository.home.HomeCreditAccountRepository
import com.example.dependencyinversionprinciple.data.repository.home.HomeDebitAccountDataRepository
import com.example.dependencyinversionprinciple.data.repository.home.HomeDebitAccountRepository
import com.example.dependencyinversionprinciple.domain.dto.home.AccountDto
import com.example.dependencyinversionprinciple.domain.usecase.home.HomeCreditAccountUseCase
import com.example.dependencyinversionprinciple.domain.usecase.home.HomeDebitAccountUseCase

class HomeAccountsDataProvider: HomeAccountsUseCaseProvider {

    private val debitAccountsDataSource: HomeDebitLocalSource by lazy {
        HomeDebitLocalDataSource()
    }

    private val creditAccountsDataSource: HomeCreditLocalSource by lazy {
        HomeCreditLocalDataSource()
    }

    private val accountEntityToDtoMapper: AccountEntityToDtoMapper by lazy {
        AccountEntityToDtoMapper()
    }

    private val debitAccountsRepository: HomeDebitAccountRepository by lazy {
        HomeDebitAccountDataRepository(
            debitAccountsDataSource,
            accountEntityToDtoMapper
        )
    }

    private val creditAccountsRepository: HomeCreditAccountRepository by lazy {
        HomeCreditAccountDataRepository(
            creditAccountsDataSource,
            accountEntityToDtoMapper
        )
    }

    override fun getAllDebitAccountsInformationUseCase(): List<AccountDto> {
        return HomeDebitAccountUseCase(
            debitAccountsRepository
        ).invoke()
    }

    override fun getAllCreditAccountsInformationUseCase(): List<AccountDto> {
        return HomeCreditAccountUseCase(
            creditAccountsRepository
        ).invoke()
    }
}