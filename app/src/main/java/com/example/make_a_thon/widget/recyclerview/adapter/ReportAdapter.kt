package com.example.make_a_thon.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView.Adapter

import com.example.make_a_thon.R
import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.widget.recyclerview.holder.ReportViewHolder
import com.example.make_a_thon.widget.recyclerview.navigator.ReportAdapterNavigator

class ReportAdapter : Adapter<ReportViewHolder>(), ReportAdapterNavigator {
//
//    val intentItem = SingleLiveEvent<Unit>()

    private lateinit var reports: List<Report>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        return ReportViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_report_list, parent, false))
    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        holder.setNavigator(this)
        holder.bind(reports[position])
    }

//    override fun intentItem() {
//        intentItem.call()
//    }

    fun updateList(reports: List<Report>?) {
        this.reports = reports!!
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if(::reports.isInitialized) reports.size else 0
    }
}