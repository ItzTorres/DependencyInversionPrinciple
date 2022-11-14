package com.example.dependencyinversionprinciple.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinversionprinciple.R
import com.example.dependencyinversionprinciple.databinding.FragmentHomeBinding
import com.example.dependencyinversionprinciple.presentation.adapter.home.HomeAccountInformationAdapter
import com.example.dependencyinversionprinciple.presentation.model.home.AccountModel
import com.example.dependencyinversionprinciple.presentation.presenter.home.HomeAccountContract
import com.example.dependencyinversionprinciple.presentation.registry.home.HomeAccountRegistry

class HomeFragment : Fragment(), HomeAccountContract.View {

    private lateinit var bindingNavigation: FragmentHomeBinding
    private val homeBinder
        get() = bindingNavigation

    private val presenter by lazy {
        HomeAccountRegistry().provide(this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingNavigation = FragmentHomeBinding.inflate(inflater, container, false)
        return bindingNavigation.root
    }

    override fun loadDebitAccounts(list: List<AccountModel>) {
        with(homeBinder) {
            rvDebitAccountRecyclerView.setHasFixedSize(true)
            rvDebitAccountRecyclerView.adapter =
                HomeAccountInformationAdapter(list) {
                }
        }
    }

    override fun loadCreditAccounts(list: List<AccountModel>) {
        with(homeBinder) {
            rvCreditAccountRecyclerView.setHasFixedSize(true)
            rvCreditAccountRecyclerView.adapter =
                HomeAccountInformationAdapter(list) {
                }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadDebitAccounts()
        presenter.loadCreditAccounts()
    }

}