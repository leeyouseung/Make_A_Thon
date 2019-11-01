package com.example.make_a_thon.widget.recyclerview.viewmodel

import androidx.lifecycle.MutableLiveData

import com.example.make_a_thon.base.viewmodel.BaseItemViewModel
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.util.Constans
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator

class ReportItemViewModel : BaseItemViewModel<ReportList, ReportItemNavigator>() {

    val time = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    val place = MutableLiveData<String>()
    val picture = MutableLiveData<String>()

    override fun bind(data: ReportList) {
        time.value = data.time
        content.value = data.content
        place.value = data.place
        picture.value = Constans.MAIN_HOST + "/image/" +data.picture
    }
}