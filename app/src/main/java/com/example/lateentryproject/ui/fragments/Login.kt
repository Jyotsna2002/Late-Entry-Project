package com.example.lateentryproject.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FragmentLoginBinding

class Login : Fragment(R.layout.fragment_login) {
	private lateinit var binding: FragmentLoginBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentLoginBinding.bind(view)
	}
}