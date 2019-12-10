package com.example.make_a_thon.view.activity

import android.os.Bundle

import android.view.MenuItem

import android.widget.Toast

import androidx.core.view.GravityCompat

import androidx.lifecycle.Observer

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityMainBinding
import com.example.make_a_thon.viewmodel.MainViewModel

import com.google.android.material.navigation.NavigationView

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), NavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun initObserver() {
        with(viewModel) {

            sosEvent.observe(this@MainActivity, Observer {
                startActivity(RescueCheckActivity::class.java)
            })

            myPlaceSetEvent.observe(this@MainActivity, Observer {
                startActivity(MyPlaceActivity::class.java)
            })

            cctvCheckEvent.observe(this@MainActivity, Observer {
                startActivity(CCTVActivity::class.java)
            })

            callEvent.observe(this@MainActivity, Observer {
                startActivity(ReportActivity::class.java)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.navView.setNavigationItemSelectedListener(this::onNavigationItemSelected)

        clickEvent()
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

    private fun clickEvent() {
        onClickMenuBtn()
    }

    private fun onClickMenuBtn() {
        binding.menuMainBtn.setOnClickListener {
            binding.main.openDrawer(GravityCompat.START)
        }
    }
}
