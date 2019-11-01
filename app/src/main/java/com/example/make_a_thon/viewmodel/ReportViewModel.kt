package com.example.make_a_thon.viewmodel

import android.app.Application

import android.content.Intent

import android.net.Uri

import android.os.Environment

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.network.client.ReportClient
import com.example.make_a_thon.network.request.ReportRequest
import com.example.make_a_thon.widget.SingleLiveEvent

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody

import java.io.File
import java.io.IOException

import java.lang.NullPointerException

import java.util.*

class ReportViewModel(application: Application) : BaseViewModel<Any>(application) {

    private val reportClient = ReportClient()

    val request = ReportRequest()

    val onSuccessEvent = SingleLiveEvent<String>()
    val nullPointEvent = SingleLiveEvent<Unit>()
    val goToAlbumEvent = SingleLiveEvent<Unit>()
    val goToCropEvent = SingleLiveEvent<Unit>()

    val tempPictureUri = MutableLiveData<Uri>()
    val pictureUri = MutableLiveData<Uri>()
    private val pictureFile = MutableLiveData<File>()
    private val image = MutableLiveData<MultipartBody.Part>()
    private val id = MutableLiveData<RequestBody>()
    private val content = MutableLiveData<RequestBody>()

    val openMain = SingleLiveEvent<String>()

    fun signUp() {
        if(!setRequest()) {
            return
        }
        else {
            addDisposable(reportClient.report(token, image.value!!, content.value!!), baseObserver)
        }
    }

    fun onClickInputImgBtn() {
        goToAlbumEvent.call()
    }

    fun savePickData(data: Intent) {
        tempPictureUri.value = data.data
    }

    fun cropImage() {
        createFile()
        goToCropEvent.call()
    }

    private fun createFile() {
        val file = File(Environment.getExternalStorageDirectory().toString() + "/MakeAThon/Profile")
        if (!file.exists()) file.mkdirs()
        pictureFile.value = File(Environment.getExternalStorageDirectory().toString() + "/MakeAThon/Profile"
                + Random().nextInt(999999999).toString() + ".jpg")
        try {
            pictureFile.value!!.createNewFile()
        }
        catch (e: IOException) {
            e.printStackTrace()
        }
        pictureUri.value = Uri.fromFile(pictureFile.value)
    }

    private fun setRequest(): Boolean {
        try {
            val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), pictureFile.value!!)
            image.value = MultipartBody.Part.createFormData("image", pictureFile.value!!.name, requestFile)
            id.value = RequestBody.create("text/plain".toMediaTypeOrNull(), request.id)
            content.value = RequestBody.create("text/plain".toMediaTypeOrNull(), request.content)
        }
        catch (e: NullPointerException) {
            nullPointEvent.call()
            return false
        }
        return true
    }

    override fun onRetrieveDataSuccess(data: Any) {}

    override fun onRetrieveBaseSuccess(message: String) {
        openMain.value = message
    }
}