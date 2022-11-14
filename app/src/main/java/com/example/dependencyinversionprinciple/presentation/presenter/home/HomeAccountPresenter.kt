package com.example.dependencyinversionprinciple.presentation.presenter.home

import com.example.dependencyinversionprinciple.domain.provider.HomeAccountsUseCaseProvider
import com.example.dependencyinversionprinciple.presentation.mapper.AccountDtoToModelMapper
import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel

class HomeAccountPresenter(
    private val view: HomeAccountContract.View,
    private val homeUseCaseProvider: HomeAccountsUseCaseProvider,
    private val accountDtoToModelMapper: AccountDtoToModelMapper,
) : HomeAccountContract.Presenter {
    override fun loadDebitAccounts() {
        val accountsList = homeUseCaseProvider
            .getAllDebitAccountsInformationUseCase()
            .map {
                accountDtoToModelMapper.transform(it)
            }
        view.loadDebitAccounts(accountsList)
    }

    override fun loadCreditAccounts() {
        val creditAccounts = homeUseCaseProvider
            .getAllCreditAccountsInformationUseCase()
            .map {
                accountDtoToModelMapper.transform(it)
            }
        view.loadCreditAccounts(creditAccounts)
    }

    override fun onAccountSelected(accountSelected: AccountModel) {
        TODO("Not yet implemented")
    }
}