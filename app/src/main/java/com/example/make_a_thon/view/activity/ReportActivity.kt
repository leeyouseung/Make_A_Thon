package com.example.make_a_thon.view.activity

import android.os.Bundle

import androidx.lifecycle.Observer

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

            goToAlbumEvent.observe(this@ReportActivity, Observer {
                tedPermission()
                goToAlbum()
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
