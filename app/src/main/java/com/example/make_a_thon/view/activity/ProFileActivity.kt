package com.example.make_a_thon.view.activity

import android.os.Bundle

import androidx.lifecycle.Observer

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityProFileBinding
import com.example.make_a_thon.viewmodel.ProFileViewModel

class ProFileActivity : BaseActivity<ActivityProFileBinding, ProFileViewModel>(), SwipeRefreshLayout.OnRefreshListener {

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

            myPlaceSetEvent.observe(this@ProFileActivity, Observer {
                startActivity(MyPlaceActivity::class.java)
            })

            reportListEvent.observe(this@ProFileActivity, Observer {

            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUp()
    }

    override fun onRefresh() {

    }

    private fun setUp() {
        viewModel.id.value = intent.getStringExtra("id")
        viewModel.setUp()

        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent)
        binding.swipeRefreshLayout.setOnRefreshListener(this)
    }
}
