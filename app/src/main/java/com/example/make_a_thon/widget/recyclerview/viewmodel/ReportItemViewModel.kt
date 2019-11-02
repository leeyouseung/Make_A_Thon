package com.example.make_a_thon.widget.recyclerview.viewmodel

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.example.make_a_thon.R

import com.example.make_a_thon.base.viewmodel.BaseItemViewModel
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator

class ReportItemViewModel : BaseItemViewModel<ReportList, ReportItemNavigator>() {

    val time = MutableLiveData<String>()
    val content = MutableLiveData<String>()

//    val imageView: ImageView()
    var status : String = ""

    override fun bind(data: ReportList) {

        if(data.rescueState == 0) {

            status = "대기 중"
        }
        else if(data.rescueState == 1) {

            status = "완료"
        }

        time.value = data.createdAt + " " + status
        content.value = data.content
    }

//    fun onClickItem() {
//        getNavigator().clickItemEvent()
//    }
}