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

    val reportEvent = SingleLiveEvent<Unit>()
    val goToAlbum = SingleLiveEvent<Unit>()
    val goToCrop = SingleLiveEvent<Unit>()
    val backMessageToast = SingleLiveEvent<Unit>()
    val nullPointImageEvent = SingleLiveEvent<String>()
    val onSuccessEvent = SingleLiveEvent<String>()

    val tempPictureUri = MutableLiveData<Uri>()
    val pictureUri = MutableLiveData<Uri>()
    private val imageFile = MutableLiveData<File>()
    private val image = MutableLiveData<MultipartBody.Part>()
    private val content = MutableLiveData<RequestBody>()

    fun addReport() {
        when {
            !setRequest() -> return
            else -> {
                addDisposable(reportClient.addReport(token, content.value!!, image.value!!), baseObserver)
            }
        }
    }

    fun savePickData(data: Intent) {
        tempPictureUri.value = data.data
    }

    fun cropImage() {
        createFile()
        goToCrop.call()
    }

    private fun createFile() {
        val file = File(Environment.getExternalStorageDirectory().toString() + "/MakeAThon")
        if (!file.exists()) file.mkdirs()
        imageFile.value = File(
            Environment.getExternalStorageDirectory().toString() + "/MakeAThon/"
                    + Random().nextInt(999999999).toString() + ".jpg")
        try {
            imageFile.value!!.createNewFile()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        pictureUri.value = Uri.fromFile(imageFile.value)
    }

    private fun setRequest(): Boolean {
        try {
            val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), imageFile.value!!)
            image.value = MultipartBody.Part.createFormData("image", imageFile.value!!.name, requestFile)
            content.value = RequestBody.create("image/*".toMediaTypeOrNull(), request.content!!.toString())
        }
        catch (e: NullPointerException) {
            nullPointImageEvent.value = "사진을 설정해주세요"
            return false
        }
        return true
    }

    fun deleteFile() {
        tempPictureUri.value = null
        imageFile.value = null
        pictureUri.value = null
        backMessageToast.call()
    }

    fun onClickInputImageBtn() {
        goToAlbum.call()
    }

    fun onClickAddReportBtn() {
        reportEvent.call()
    }

    override fun onRetrieveBaseSuccess(message: String) {
        onSuccessEvent.value = message
    }
}