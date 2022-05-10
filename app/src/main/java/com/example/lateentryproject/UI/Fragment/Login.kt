package com.example.lateentryproject.UI.Fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.LoginBinding

class Login: Fragment(R.layout.login) {
	private lateinit var binding: LoginBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = LoginBinding.bind(view)
	}
}