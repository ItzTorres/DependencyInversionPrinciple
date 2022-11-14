package com.example.dependencyinversionprinciple.presentation.registry.home

import com.example.dependencyinversionprinciple.domain.provider.HomeAccountsDataProvider
import com.example.dependencyinversionprinciple.presentation.mapper.AccountDtoToModelMapper
import com.example.dependencyinversionprinciple.presentation.presenter.home.HomeAccountContract
import com.example.dependencyinversionprinciple.presentation.presenter.home.HomeAccountPresenter

class HomeAccountRegistry : HomeRegistry<HomeAccountContract.View, HomeAccountContract.Presenter>{

    private val homeUseCaseProvider by lazy {
        HomeAccountsDataProvider()
    }

    private val accountDtoToModelMapper by lazy {
        AccountDtoToModelMapper()
    }

    override fun provide(view: HomeAccountContract.View): HomeAccountContract.Presenter {
        return HomeAccountPresenter(
            view,
            homeUseCaseProvider,
            accountDtoToModelMapper,
        )
    }
}