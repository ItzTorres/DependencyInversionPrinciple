package com.example.dependencyinversionprinciple.presentation.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dependencyinversionprinciple.R
import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel
import com.example.dependencyinversionprinciple.presentation.presenter.main.MainBankContract
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), MainBankContract.View {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val navController: NavController by lazy {
        findNavController(R.id.NavHostFragment)
    }

    private lateinit var accountList: List<AccountModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpView()
        handlerNavigationOptionBottom()
    }

    private fun setUpView() {
        bottomNavigationView = findViewById(R.id.bottomMenu)
        if (navController.currentDestination?.id != R.id.loginFragment &&
            navController.currentDestination?.id != R.id.signUpFragment
        ) {
            showBottomNavigation()
        } else {
            hideBottomNavigation()
        }
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun handlerNavigationOptionBottom(){
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_bottom_help -> {
                    navController.navigate(
                        R.id.helpFragment, Bundle()
                    )
                }
                R.id.nav_bottom_investments -> {
                    navController.navigate(
                        R.id.investmentsFragment, Bundle()
                    )
                }
                R.id.nav_bottom_transactions -> {
                    navController.navigate(
                        R.id.transferFragment, Bundle()
                    )
                }
            }
            true
        }
    }

    override fun hideBottomNavigation() {
        bottomNavigationView.visibility = android.view.View.GONE
    }

    override fun showBottomNavigation() {
        bottomNavigationView.visibility = android.view.View.VISIBLE
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}