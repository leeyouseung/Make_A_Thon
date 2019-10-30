package com.example.make_a_thon.view.activity

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityRescueCheckBinding
import com.example.make_a_thon.viewmodel.RescueCheckViewModel

class RescueCheckActivity : BaseActivity<ActivityRescueCheckBinding, RescueCheckViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_rescue_check
    }

    override fun getViewModel(): Class<RescueCheckViewModel> {
        return RescueCheckViewModel::class.java
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
