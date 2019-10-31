package com.example.make_a_thon.viewmodel

import android.app.Application

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.widget.SingleLiveEvent

class ReportViewModel(application: Application) : BaseViewModel<ReportViewModel>(application) {

    val goToAlbumEvent = SingleLiveEvent<Unit>()

    fun onClickInputImgBtn() {
        goToAlbumEvent.call()
    }

    override fun onRetrieveDataSuccess(data: ReportViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}