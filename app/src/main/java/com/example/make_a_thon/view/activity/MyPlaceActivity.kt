package com.example.make_a_thon.view.activity

import android.os.Bundle

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityMyPlaceBinding
import com.example.make_a_thon.viewmodel.MyPlaceViewModel

class MyPlaceActivity : BaseActivity<ActivityMyPlaceBinding, MyPlaceViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_my_place
    }

    override fun getViewModel(): Class<MyPlaceViewModel> {
        return MyPlaceViewModel::class.java
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
