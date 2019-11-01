package com.example.make_a_thon.view.activity

import android.content.Intent

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

            onSuccessEvent.observe(this@ReportActivity, Observer {
                simpleToast(it)
            })

            nullPointEvent.observe(this@ReportActivity, Observer {
                simpleToast("신고 사진을 등록해주세요")
            })

            goToAlbumEvent.observe(this@ReportActivity, Observer {
                tedPermission()
                goToAlbum()
            })

            goToCropEvent.observe(this@ReportActivity, Observer {
                goToCropPage(viewModel.tempPictureUri.value, viewModel.pictureUri.value)
            })

            openMain.observe(this@ReportActivity, Observer {
                startActivityWithFinish(MainActivity::class.java)
            })
        }
    }

    override fun pickNextEvent(data: Intent) {
        super.pickNextEvent(data)

        viewModel.savePickData(data)
        viewModel.cropImage()
    }

    override fun cropNextEvent() {
        Glide.with(this).load(viewModel.pictureUri.value).into(binding.inputImg)
    }
}
