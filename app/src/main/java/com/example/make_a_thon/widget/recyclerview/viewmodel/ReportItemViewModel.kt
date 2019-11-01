package com.example.make_a_thon.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseItemViewModel
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator

class ReportItemViewModel : BaseItemViewModel<ReportList, ReportItemNavigator>() {

    val time = MutableLiveData<String>()
    val content = MutableLiveData<String>()

    override fun bind(data: ReportList) {
        time.value = data.createdAt + "  완료"
        content.value = data.content
    }

//    fun onClickItem() {
//        getNavigator().clickItemEvent()
//    }
}