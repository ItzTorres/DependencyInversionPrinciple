package com.example.dependencyinversionprinciple.presentation.view.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.dependencyinversionprinciple.R
import com.example.dependencyinversionprinciple.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var bindingNavigation: FragmentSignUpBinding
    private val signUpBinder
        get() = bindingNavigation

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingNavigation = FragmentSignUpBinding.inflate(inflater, container, false)
        return bindingNavigation.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signUpBinder.btnContinueSignIn.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpToLogin()
            findNavController().navigate(action)
        }
        signUpBinder.tvStartSesionLink.setOnClickListener { view ->
            val action = SignUpFragmentDirections.actionSignUpToLogin()
            findNavController().navigate(action)
        }
    }

}