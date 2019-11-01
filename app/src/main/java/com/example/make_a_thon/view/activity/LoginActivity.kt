package com.example.make_a_thon.view.activity

import androidx.lifecycle.Observer

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityLoginBinding
import com.example.make_a_thon.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

            onSuccessEvent.observe(this@LoginActivity, Observer {
                startActivityWithFinish(MainActivity::class.java)
            })

            signUpEvent.observe(this@LoginActivity, Observer {
                startActivity(SignUpActivity::class.java)
            })

            loginEvent.observe(this@LoginActivity, Observer {
                if(isEmpty()) {
                    simpleToast("빈칸 없이 입력해주세요")
                    return@Observer
                }
                login()
            })
        }
    }

    private fun isEmpty(): Boolean {
        return viewModel.request.id == null || viewModel.request.password == null
    }
}