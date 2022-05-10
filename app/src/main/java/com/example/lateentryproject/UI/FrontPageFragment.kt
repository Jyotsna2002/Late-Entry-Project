package com.example.lateentryproject.UI

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FrontPageFragmentBinding


class FrontPageFragment : Fragment() {
    lateinit var binding: FrontPageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.front_page_fragment, container, false)

        binding.button.setOnClickListener {
            requestPermission.launch(
                Manifest.permission.CAMERA
            )
        }


        return binding.root
    }


    private fun gotToMainActivity() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.container, QRcodeSanner())
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