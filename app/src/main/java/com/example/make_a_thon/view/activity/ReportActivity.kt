package com.example.make_a_thon.view.activity

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
        return BR.viewModel
    }

    override fun initObserver() {
        with(viewModel) {

            reportEvent.observe(this@ReportActivity, Observer {
                simpleToast("신고되었습니다")
            })
        }
    }
}