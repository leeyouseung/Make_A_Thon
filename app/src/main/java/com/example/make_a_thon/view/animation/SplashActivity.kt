package com.example.make_a_thon.view.animation

import android.os.Bundle

import android.view.animation.Animation
import android.view.animation.AnimationUtils

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivitySplashBinding
import com.example.make_a_thon.view.activity.LoginActivity
import com.example.make_a_thon.viewmodel.SplashViewModel

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun getViewModel(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun initObserver() {
        with(viewModel) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hold = AnimationUtils.loadAnimation(this, R.anim.splash_hold)
        val scale = AnimationUtils.loadAnimation(this, R.anim.splash_scale)

        hold.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                binding.animationLogoImg.clearAnimation()
                binding.animationLogoImg.startAnimation(scale)
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

        scale.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {

            }

            override fun onAnimationEnd(animation: Animation) {
                binding.animationLogoImg.clearAnimation()
                startActivityWithFinish(LoginActivity::class.java)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation) {

            }
        })

        binding.animationLogoImg.startAnimation(hold)
    }
}
