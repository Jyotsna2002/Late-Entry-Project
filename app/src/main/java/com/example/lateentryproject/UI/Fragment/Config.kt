package com.example.lateentryproject.UI.Fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.ConfigBinding

class Config : Fragment(R.layout.config) {
	private lateinit var binding: ConfigBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = ConfigBinding.bind(view)
	}
}