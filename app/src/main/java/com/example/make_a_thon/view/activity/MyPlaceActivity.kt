package com.example.make_a_thon.view.activity

import android.os.Bundle

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

class MyPlaceActivity : BaseActivity<ActivityMyPlaceBinding, MyPlaceViewModel>(), OnMapReadyCallback {

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

        val mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        val SEOUL = LatLng(37.56, 126.97)

        val markerOptions = MarkerOptions()

        markerOptions.position(SEOUL)
        markerOptions.title("서울")

        map!!.addMarker(markerOptions)
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL))
        map.animateCamera(CameraUpdateFactory.zoomTo(10f))
    }
}
