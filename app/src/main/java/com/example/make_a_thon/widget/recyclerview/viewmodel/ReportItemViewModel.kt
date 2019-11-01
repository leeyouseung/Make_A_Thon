package com.example.make_a_thon.widget.recyclerview.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseItemViewModel
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator
import java.text.SimpleDateFormat

class ReportItemViewModel : BaseItemViewModel<ReportList, ReportItemNavigator>() {

    val time = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    override fun bind(data: ReportList) {

//        @SuppressLint("SimpleDateFormat") val myFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
//
//        var rescueDate = myFormat.format(data.createdAt).split("T")[0]
//        var rescueTime = myFormat.format(data.createdAt).split("T")[1].split(".")[0]

        time.value = data.createdAt
        content.value = data.content
    }

//    fun onClickItem() {
//        getNavigator().clickItemEvent()
//    }
}