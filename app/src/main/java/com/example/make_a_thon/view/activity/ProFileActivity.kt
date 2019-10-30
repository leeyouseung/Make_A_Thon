package com.example.make_a_thon.view.activity

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityProFileBinding
import com.example.make_a_thon.viewmodel.ProFileViewModel

class ProFileActivity : BaseActivity<ActivityProFileBinding, ProFileViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_pro_file
    }

    override fun getViewModel(): Class<ProFileViewModel> {
        return ProFileViewModel::class.java
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
