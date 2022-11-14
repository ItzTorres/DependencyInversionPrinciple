package com.example.dependencyinversionprinciple.presentation.presenter.home

import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel

interface HomeAccountContract {
    interface View{
        fun loadDebitAccounts(list: List<AccountModel>)
        fun loadCreditAccounts(list: List<AccountModel>)
    }
    interface Presenter {
        fun loadDebitAccounts()
        fun loadCreditAccounts()
        fun onAccountSelected(accountSelected: AccountModel)
    }
}