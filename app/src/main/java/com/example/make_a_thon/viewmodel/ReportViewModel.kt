package com.example.make_a_thon.viewmodel

import android.app.Application

import android.net.Uri

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel

import okhttp3.MultipartBody

import java.io.File

class ReportViewModel(application: Application) : BaseViewModel<Any>(application) {

    val tempPictureUri = MutableLiveData<Uri>()
    val pictureUri = MutableLiveData<Uri>()
    private val imageFile = MutableLiveData<File>()
    private val image = MutableLiveData<MultipartBody.Part>()

    override fun onRetrieveBaseSuccess(message: String) {}
}