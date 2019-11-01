package com.example.make_a_thon.view.activity

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityShowReportContentBinding
import com.example.make_a_thon.viewmodel.ShowReportContentViewModel

class ShowReportContent : BaseActivity<ActivityShowReportContentBinding, ShowReportContentViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_show_report_content
    }

    override fun getViewModel(): Class<ShowReportContentViewModel> {
        return ShowReportContentViewModel::class.java
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
