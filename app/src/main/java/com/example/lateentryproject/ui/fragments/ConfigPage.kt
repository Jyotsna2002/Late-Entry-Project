package com.example.lateentryproject.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FragmentConfigBinding

class ConfigPage: Fragment(R.layout.fragment_config) {
	private lateinit var binding: FragmentConfigBinding


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentConfigBinding.bind(view)
	}
}