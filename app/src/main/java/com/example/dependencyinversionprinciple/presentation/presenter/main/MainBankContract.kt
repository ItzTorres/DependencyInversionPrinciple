package com.example.dependencyinversionprinciple.presentation.presenter.main

interface MainBankContract {
    interface Presenter {}

    interface View {
        fun hideBottomNavigation()
        fun showBottomNavigation()
    }
}