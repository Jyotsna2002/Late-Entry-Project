package com.example.lateentryproject.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lateentryproject.R
import com.example.lateentryproject.databinding.FragmentQRcodeSannerBinding
import me.dm7.barcodescanner.zbar.Result
import me.dm7.barcodescanner.zbar.ZBarScannerView


class QRcodeSanner : Fragment(), ZBarScannerView.ResultHandler {
    lateinit var binding: FragmentQRcodeSannerBinding

    companion object {

        fun newInstance(): QRcodeSanner {
            return QRcodeSanner()
        }
    }

    private lateinit var mView: View

    lateinit var scannerView: ZBarScannerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_q_rcode_sanner,
            container,
            false
        )
        val view = binding.root
        val button = binding.button
        onClicks()
        initializeQRCamera()
        button.setOnClickListener {
            scannerView.resumeCameraPreview(this)
        }
        return view
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