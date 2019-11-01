package com.example.make_a_thon.view.activity

import android.os.Bundle

import android.webkit.WebView
import android.webkit.WebViewClient

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityCctvBinding
import com.example.make_a_thon.viewmodel.CCTVViewModel

class CCTVActivity : BaseActivity<ActivityCctvBinding, CCTVViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_cctv
    }

    override fun getViewModel(): Class<CCTVViewModel> {
        return CCTVViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

        }
    }

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://www.google.co.in/")
    }
}
