package com.example.make_a_thon.view.activity

import androidx.lifecycle.Observer

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivitySignupBinding
import com.example.make_a_thon.viewmodel.SignUpViewModel

class SignUpActivity : BaseActivity<ActivitySignupBinding, SignUpViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_signup
    }

    override fun getViewModel(): Class<SignUpViewModel> {
        return SignUpViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

            onSuccessEvent.observe(this@SignUpActivity, Observer {
                if(it == "success") {
                    startActivityWithFinish(LoginActivity::class.java)
                }
                else {
                    simpleToast("로그인 실패")
                    return@Observer
                }
            })

            signUpEvent.observe(this@SignUpActivity, Observer {
                if(isEmpty()) {
                    simpleToast("빈칸 없이 입력해주세요")
                    return@Observer
                }
                signUp()
            })

            openLoginEvent.observe(this@SignUpActivity, Observer {
                startActivityWithFinish(LoginActivity::class.java)
            })
        }
    }

    private fun isEmpty(): Boolean {
        return viewModel.request.id == null || viewModel.request.password == null
                || viewModel.request.name == null || viewModel.request.phoneNumber == null
    }
}
