package com.example.make_a_thon.view.activity

import android.content.Intent

import android.os.Bundle

import android.util.Log

import android.view.MenuItem

import android.widget.ImageView
import android.widget.TextView
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
        return BR.viewmodel
    }

    override fun initObserver() {
        with(viewModel) {

            myPlaceSetEvent.observe(this@MainActivity, Observer {
                startActivity(MyPlaceActivity::class.java)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuSetting()

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
        val intent: Intent

        when (id) {
            R.id.menu_my_profile -> {
                simpleToast("menuMyProfile")
            }
            R.id.menu_my_place -> {
                simpleToast("menuMyPlace")
            }
            R.id.menu_report -> {
                simpleToast("menuReport")
            }
            R.id.menu_report_list -> {
                simpleToast("menuReportList")
            }
            R.id.menu_camera -> {
                simpleToast("menuCamera")
            }
            R.id.menu_check_rescue -> {
                simpleToast("menuCheckRescue")
            }
            else -> Toast.makeText(this, "문제가 발생하였습니다", Toast.LENGTH_SHORT).show()
        }

        overridePendingTransition(0, 0)
        binding.main.closeDrawers()

        return false
    }

    private fun menuSetting() {
//        val currentUser = CurrentUser(this, "betweenUs.db", null, 1)
//        val myInfo = currentUser.getResult()
//
//        val profileImage = binding.navView.getHeaderView(0).findViewById(R.id.profile) as ImageView
//        val nameText = binding.navView.getHeaderView(0).findViewById(R.id.name) as TextView
//        val schoolText = binding.navView.getHeaderView(0).findViewById(R.id.school) as TextView
//
//        Log.d("imgTag", myInfo.getprofileImg())
//        if (!myInfo.getprofileImg().isEmpty()) {
//            Log.d("imgTag", "Pass")
//            Glide.with(this).load(myInfo.getprofileImg()).into(profileImage)
//        }
//
//        nameText.setText(myInfo.getName())
//        schoolText.setText(myInfo.getSchool())
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
