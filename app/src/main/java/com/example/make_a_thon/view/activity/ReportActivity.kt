package com.example.make_a_thon.view.activity

import android.content.Intent
import android.os.Bundle

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BasePictureActivity
import com.example.make_a_thon.databinding.ActivityReportBinding
import com.example.make_a_thon.viewmodel.ReportViewModel

class ReportActivity : BasePictureActivity<ActivityReportBinding, ReportViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_report
    }

    override fun getViewModel(): Class<ReportViewModel> {
        return ReportViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

            goToCrop.observe(this@ReportActivity, Observer {
                goToCropPage(viewModel.tempPictureUri.value, viewModel.pictureUri.value)
            })

            goToAlbumEvent.observe(this@ReportActivity, Observer {
                goToAlbum()
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUp()
    }

    private fun setUp() {
        tedPermission()
    }

    override fun pickNextEvent(data: Intent) {
        viewModel.savePickData(data)
        viewModel.cropImage()
    }

    override fun cropNextEvent() {
        super.cropNextEvent()
        Glide.with(this).load(viewModel.pictureUri.value).into(binding.inputImg)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivityWithFinish(MainActivity::class.java)
    }
}