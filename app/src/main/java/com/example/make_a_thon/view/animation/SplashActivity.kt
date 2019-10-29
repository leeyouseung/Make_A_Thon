package com.example.make_a_thon.view.animation

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivitySplashBinding
import com.example.make_a_thon.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
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
