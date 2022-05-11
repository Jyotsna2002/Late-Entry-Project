package com.example.lateentryproject.ui.fragments

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FragmentFrontPageBinding

class FrontPageFragment : Fragment(R.layout.fragment_front_page) {
	private lateinit var binding: FragmentFrontPageBinding

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentFrontPageBinding.bind(view)
		binding.button.setOnClickListener {
			requestPermission.launch(Manifest.permission.CAMERA)
		}
	}


	private fun gotToMainActivity() {
		val transaction = activity?.supportFragmentManager?.beginTransaction()
		transaction?.replace(R.id.container, QRcodeScanner())
		transaction?.commit()
	}

	private val requestPermission = registerForActivityResult(
		ActivityResultContracts
			.RequestPermission()
	) {
		when (it) {
			true -> {
				gotToMainActivity()
			}
			false -> {
				showGoToAppSettingsDialog()
			}
		}
	}

	private fun showGoToAppSettingsDialog() {
		AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog)
			.setTitle(getString(R.string.grant_permissions))
			.setMessage(getString(R.string.we_need_permission))
			.setPositiveButton(getString(R.string.grant)) { _, _ ->
				goToAppSettings()
			}
			.setNegativeButton(getString(R.string.cancel)) { _, _ ->
				run {
					activity?.finish()
				}
			}.show()
	}

	private fun goToAppSettings() {
		val intent = Intent(
			Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
			Uri.fromParts("package", requireContext().packageName, null)
		)
		intent.addCategory(Intent.CATEGORY_DEFAULT)
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
		startActivity(intent)
	}
}