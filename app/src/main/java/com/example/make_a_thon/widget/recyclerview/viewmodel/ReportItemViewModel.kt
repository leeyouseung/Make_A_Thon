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

        @SuppressLint("SimpleDateFormat") val myFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        val myDate = myFormat.parse(data.createdAt)

        var reportCheckDate = myFormat.format(myDate).split("T")[0].substring(1, 9)
        var reportCheckTime = myFormat.format(myDate).split("T")[1].substring(0, 4)

        time.value = reportCheckDate + " " + reportCheckTime + " 완료"
        content.value = data.content
    }

    fun onClickItem() {
        getNavigator().clickItemEvent()
    }
}