package com.example.make_a_thon.viewmodel

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.network.client.ReportClient
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

    val tempPictureUri: MutableLiveData<Uri> = MutableLiveData()
    val pictureUri: MutableLiveData<Uri> = MutableLiveData()
    private val pictureFile: MutableLiveData<File> = MutableLiveData()
    private val picture: MutableLiveData<MultipartBody.Part> = MutableLiveData()

    val contentText = MutableLiveData<String>()
    private val content = MutableLiveData<RequestBody>()

    val nullPointerException = SingleLiveEvent<Unit>()
    val goToCrop: SingleLiveEvent<Unit> = SingleLiveEvent()


    fun report() {
        if (!setRequest()) return
        addDisposable(reportClient.report(token, picture.value!!, content.value!!), baseObserver)
    }

    fun savePickData(data: Intent) {
        tempPictureUri.value = data.data
    }

    fun cropImage() {
        createFile()
        goToCrop.call()
    }

    private fun createFile() {
        val file = File(Environment.getExternalStorageDirectory().toString() + "/Make")
        if (!file.exists()) file.mkdirs()
        pictureFile.value = File(Environment.getExternalStorageDirectory().toString() + "/Make/" + Random().nextInt(999999999).toString() + ".jpg")
        try {
            pictureFile.value!!.createNewFile()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        pictureUri.value = Uri.fromFile(pictureFile.value)
    }

    private fun setRequest(): Boolean {
        try {
            val requestFile: RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(), pictureFile.value!!)
            picture.value = MultipartBody.Part.createFormData("image", pictureFile.value!!.name, requestFile)
            content.value = RequestBody.create("text/plain".toMediaTypeOrNull(), contentText.value!!)
            return true
        }
        catch (e: NullPointerException) {
            nullPointerException.call()
        }
        return false
    }

    override fun onRetrieveBaseSuccess(message: String) {}
}