package com.example.lateentryproject.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FragmentQRcodeSannerBinding
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView

class QRcodeScanner : Fragment(R.layout.fragment_q_rcode_sanner), ZBarScannerView.ResultHandler {
	private lateinit var binding: FragmentQRcodeSannerBinding

	companion object {
		fun newInstance(): QRcodeScanner {
			return QRcodeScanner()
		}
	}

	private lateinit var mView: View

	lateinit var scannerView: ZBarScannerView


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentQRcodeSannerBinding.bind(view)
		val button = binding.button
		onClicks()
		initializeQRCamera()
		button.setOnClickListener {
			scannerView.resumeCameraPreview(this)
		}
	}

	private fun initializeQRCamera() {
		scannerView = ZBarScannerView(context)
		scannerView.setResultHandler(this)
		scannerView.setBackgroundColor(
			ContextCompat.getColor(
				requireContext(),
				R.color.colorTranslucent
			)
		)
		scannerView.setBorderColor(
			ContextCompat.getColor(
				requireContext(),
				R.color.colorTranslucent
			)
		)
		scannerView.setLaserColor(
			ContextCompat.getColor(
				requireContext(),
				R.color.colorTranslucent
			)
		)
		scannerView.setBorderStrokeWidth(10)
		scannerView.setSquareViewFinder(true)
		scannerView.setupScanner()
		scannerView.setAutoFocus(true)
		startQRCamera()
		binding.containerScanner.addView(scannerView)
	}


	private fun startQRCamera() {
		scannerView.startCamera()
	}

	private fun onClicks() {
		binding.flashToggle.setOnClickListener {
			if (binding.flashToggle.isSelected) {
				offFlashLight()
			} else {
				onFlashLight()
			}
		}
	}

	private fun onFlashLight() {
		binding.flashToggle.isSelected = true
		scannerView.flash = true
	}

	private fun offFlashLight() {
		binding.flashToggle.isSelected = false
		scannerView.flash = false
	}

	override fun onResume() {
		super.onResume()
		scannerView.setResultHandler(this)
		scannerView.startCamera()
	}

	override fun onPause() {
		super.onPause()
		scannerView.stopCamera()
	}

	override fun onDestroy() {
		super.onDestroy()
		scannerView.stopCamera()
	}

	override fun handleResult(rawResult: Result?) {
		Toast.makeText(requireContext(), rawResult?.contents, Toast.LENGTH_SHORT).show()
	}

}