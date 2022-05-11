package com.example.lateentryproject.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.ReportBinding

class Report : Fragment(R.layout.report) {
	private lateinit var binding: ReportBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = ReportBinding.bind(view)
		binding.apply {

		}
	}
}