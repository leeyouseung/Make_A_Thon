package com.example.make_a_thon.widget.recyclerview.holder

import com.example.make_a_thon.base.BaseViewHolder
import com.example.make_a_thon.databinding.ItemReportListBinding
import com.example.make_a_thon.model.report.Report
import com.example.make_a_thon.widget.recyclerview.navigator.ReportAdapterNavigator
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator
import com.example.make_a_thon.widget.recyclerview.viewmodel.ReportItemViewModel

class ReportViewHolder(val binding: ItemReportListBinding) : BaseViewHolder<ReportAdapterNavigator>(binding.root), ReportItemNavigator {

    private val viewModel = ReportItemViewModel()

    private lateinit var report: Report

//    override fun clickItemEvent() {
//        getNavigator().intentItem()
//    }

    fun bind(data: Report) {
        viewModel.bind(data)
        report = data
        viewModel.setNavigator(this)
        binding.viewModel = viewModel
    }
}