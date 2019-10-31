package com.example.make_a_thon.view.activity

import android.os.Bundle

import android.view.MenuItem

import android.widget.Toast

import androidx.core.view.GravityCompat

import androidx.lifecycle.Observer

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityProFileBinding
import com.example.make_a_thon.viewmodel.ProFileViewModel
import com.google.android.material.navigation.NavigationView

class ProFileActivity : BaseActivity<ActivityProFileBinding, ProFileViewModel>()
    , SwipeRefreshLayout.OnRefreshListener, NavigationView.OnNavigationItemSelectedListener {

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
                startActivity(ReportListActivity::class.java)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUp()

        binding.navView.setNavigationItemSelectedListener(this::onNavigationItemSelected)

        menuSetting()

        clickEvent()
    }

    override fun onRefresh() {

    }

    private fun setUp() {
        viewModel.id.value = intent.getStringExtra("id")
        viewModel.setUp()

        binding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent)
        binding.swipeRefreshLayout.setOnRefreshListener(this)
    }

    private fun menuSetting() {

    }

    override fun onBackPressed() {
        if (binding.profile.isDrawerOpen(GravityCompat.START)) {
            binding.profile.closeDrawers()
        }
        else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when(id) {
            R.id.menu_my_profile -> {
                startActivity(ProFileActivity::class.java)
            }
            R.id.menu_my_place -> {
                startActivity(MyPlaceActivity::class.java)
            }
            R.id.menu_report -> {
                startActivity(ReportActivity::class.java)
            }
            R.id.menu_report_list -> {
                startActivity(ReportListActivity::class.java)
            }
            R.id.menu_cctv -> {
                startActivity(CCTVActivity::class.java)
            }
            R.id.menu_check_rescue -> {
                startActivity(RescueCheckActivity::class.java)
            }
            else -> {
                Toast.makeText(this, "문제가 발생하였습니다", Toast.LENGTH_SHORT).show()
            }
        }

        overridePendingTransition(0, 0)
        binding.profile.closeDrawers()

        return false
    }

    private fun clickEvent() {
        onClickMenuBtn()
    }

    private fun onClickMenuBtn() {
        binding.profileMenuBtn.setOnClickListener {
            binding.profile.openDrawer(GravityCompat.START)
        }
    }
}
