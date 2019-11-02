package com.example.make_a_thon.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView.Adapter

import com.example.make_a_thon.R
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.widget.recyclerview.holder.ReportViewHolder
import com.example.make_a_thon.widget.recyclerview.navigator.ReportAdapterNavigator

class ReportAdapter : Adapter<ReportViewHolder>(), ReportAdapterNavigator {
//
//    val intentItem = SingleLiveEvent<Unit>()

    private lateinit var reportLists: List<ReportList>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        return ReportViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_report_list, parent, false))
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.setNavigator(this)
        holder.bind(reportLists[position])
    }

//    override fun intentItem() {
//        intentItem.call()
//    }

    fun updateList(reportLists: List<ReportList>?) {
        this.reportLists = reportLists!!
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if(::reportLists.isInitialized) reportLists.size else 0
    }
}