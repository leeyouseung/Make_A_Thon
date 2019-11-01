package com.example.make_a_thon.view.activity

import android.os.Bundle

import android.view.MenuItem

import android.widget.Toast

import androidx.core.view.GravityCompat

import androidx.lifecycle.Observer

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityReportListBinding
import com.example.make_a_thon.viewmodel.ReportListViewModel
import com.google.android.material.navigation.NavigationView

class ReportListActivity : BaseActivity<ActivityReportListBinding, ReportListViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_report_list
    }

    override fun getViewModel(): Class<ReportListViewModel> {
        return ReportListViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {
            
            with(reportAdapter) {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.navView.setNavigationItemSelectedListener(this::onNavigationItemSelected)

        binding.reportListRecyclerview.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        viewModel.getReportList()

        clickEvent()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
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
        binding.main.closeDrawers()

        return false
    }

    private fun clickEvent() {
        onClickMenuBtn()
    }

    private fun onClickMenuBtn() {
        binding.menuMainBtn.setOnClickListener {
            binding.main.openDrawer(GravityCompat.START)
        }
    }
}
