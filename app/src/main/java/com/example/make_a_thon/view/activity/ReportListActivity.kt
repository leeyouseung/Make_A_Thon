package com.example.make_a_thon.view.activity

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityReportListBinding
import com.example.make_a_thon.viewmodel.ReportListViewModel

class ReportListActivity : BaseActivity<ActivityReportListBinding, ReportListViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_report_list
    }

    override fun getViewModel(): Class<ReportListViewModel> {
        return ReportListViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
