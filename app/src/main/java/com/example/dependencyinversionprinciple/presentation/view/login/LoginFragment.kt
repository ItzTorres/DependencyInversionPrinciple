package com.example.dependencyinversionprinciple.presentation.view.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.dependencyinversionprinciple.R
import com.example.dependencyinversionprinciple.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var bindingNavigation: FragmentLoginBinding
    private val loginBinder
        get() = bindingNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingNavigation = FragmentLoginBinding.inflate(inflater, container, false)
        return bindingNavigation.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinder.btnLoginStarSesion.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginToHome()
            findNavController().navigate(action)
        }
        loginBinder.tvSignUp.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginToSignUp()
            findNavController().navigate(action)
        }
    }

}