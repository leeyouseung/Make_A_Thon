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
        return BR.viewModel
    }

    override fun initObserver() {
        with(viewModel) {

            backMessageToast.observe(this@ReportActivity, Observer {
                simpleToast("취소 되었습니다")
            })

            nullPointImageEvent.observe(this@ReportActivity, Observer {
                simpleToast(it!!)
            })

            goToAlbum.observe(this@ReportActivity, Observer {
                tedPermission()
                goToAlbum()
            })

            goToCrop.observe(this@ReportActivity, Observer {
                goToCropPage(viewModel.tempPictureUri.value!!, viewModel.pictureUri.value!!)
            })

            reportEvent.observe(this@ReportActivity, Observer {
                request.content = binding.contentText.text.toString()
                addReport()
            })

            onSuccessEvent.observe(this@ReportActivity, Observer {
                simpleToast(it!!)
                startActivity(Intent(this@ReportActivity, MainActivity::class.java))
                finish()
            })
        }
    }

    override fun requestNotOkEvent() {
        viewModel.deleteFile()
    }

    override fun pickNextEvent(data: Intent) {
        viewModel.savePickData(data)
        viewModel.cropImage()
    }

    override fun cropNextEvent() {
        Glide.with(this).load(viewModel.pictureUri.value).into(binding.inputImg)
    }
}