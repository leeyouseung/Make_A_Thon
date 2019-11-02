package com.example.make_a_thon.view.activity

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat

import com.example.make_a_thon.BR
import com.example.make_a_thon.R
import com.example.make_a_thon.base.activity.BaseActivity
import com.example.make_a_thon.databinding.ActivityMyPlaceBinding
import com.example.make_a_thon.viewmodel.MyPlaceViewModel

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView

class MyPlaceActivity : BaseActivity<ActivityMyPlaceBinding, MyPlaceViewModel>(), OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

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

        val fragmentManager = fragmentManager
        val mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)

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

    override fun onMapReady(map: GoogleMap?) {
        val SEOUL = LatLng(35.907235, 128.613107)

        val markerOptions = MarkerOptions()

        markerOptions.position(SEOUL)
        markerOptions.title("엑스코")
        markerOptions.snippet("우리집 CCTV")

        map!!.addMarker(markerOptions)
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL))
        map.animateCamera(CameraUpdateFactory.zoomTo(10f))
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
