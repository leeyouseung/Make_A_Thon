package com.example.make_a_thon.viewmodel

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Environment
import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseViewModel
import com.example.make_a_thon.widget.SingleLiveEvent
import java.io.File
import java.io.IOException
import java.util.*

class ReportViewModel(application: Application) : BaseViewModel<ReportViewModel>(application) {

    val goToAlbumEvent = SingleLiveEvent<Unit>()
    val goToCropEvent = SingleLiveEvent<Unit>()

    val tempPictureUri = MutableLiveData<Uri>()
    val pictureUri = MutableLiveData<Uri>()
    private val pictureFile = MutableLiveData<File>()

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
        val file = File(Environment.getExternalStorageDirectory().toString() + "/Weknot/Profile")
        if (!file.exists()) file.mkdirs()
        pictureFile.value = File(Environment.getExternalStorageDirectory().toString() + "/Weknot/Profile" + Random().nextInt(999999999).toString() + ".jpg")
        try {
            pictureFile.value!!.createNewFile()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        pictureUri.value = Uri.fromFile(pictureFile.value)
    }

    override fun onRetrieveDataSuccess(data: ReportViewModel) {}

    override fun onRetrieveBaseSuccess(message: String) {}
}