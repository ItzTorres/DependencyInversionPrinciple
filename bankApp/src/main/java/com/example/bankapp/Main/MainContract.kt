package com.example.bankapp.Main

import android.view.View

interface MainContract {
    interface Presenter {}
    interface View {
        fun hideBottomNavigation()
        fun showBottomNavigation()
    }
}