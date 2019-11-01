package com.example.make_a_thon.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat

import androidx.lifecycle.Observer
import com.bumptech.glide.Glide

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BasePictureActivity
import com.example.make_a_thon.databinding.ActivityReportBinding
import com.example.make_a_thon.viewmodel.ReportViewModel
import com.google.android.material.navigation.NavigationView

class ReportActivity : BasePictureActivity<ActivityReportBinding, ReportViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_report
    }

    override fun getViewModel(): Class<ReportViewModel> {
        return ReportViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

            goToCrop.observe(this@ReportActivity, Observer {
                goToCropPage(viewModel.tempPictureUri.value, viewModel.pictureUri.value)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUp()

        binding.navView.setNavigationItemSelectedListener(this::onNavigationItemSelected)

        clickEvent()
    }

    private fun setUp() {
        tedPermission()
    }

    private fun clickEvent() {
        binding.inputImg.setOnClickListener {
            goToAlbum()
        }

        onClickMenuBtn()
    }

    override fun pickNextEvent(data: Intent) {
        viewModel.savePickData(data)
        viewModel.cropImage()
    }

    override fun cropNextEvent() {
        super.cropNextEvent()
        Glide.with(this).load(viewModel.pictureUri.value).into(binding.inputImg)
    }

    override fun onBackPressed() {
        if (binding.main.isDrawerOpen(GravityCompat.START)) {
            binding.main.closeDrawers()
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
        binding.main.closeDrawers()

        return false
    }

    private fun onClickMenuBtn() {
        binding.menuMainBtn.setOnClickListener {
            binding.main.openDrawer(GravityCompat.START)
        }
    }
}