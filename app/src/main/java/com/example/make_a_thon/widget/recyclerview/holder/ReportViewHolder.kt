package com.example.make_a_thon.widget.recyclerview.holder

import com.example.make_a_thon.base.BaseViewHolder
import com.example.make_a_thon.databinding.ItemReportListBinding
import com.example.make_a_thon.model.report.ReportList
import com.example.make_a_thon.widget.recyclerview.navigator.ReportAdapterNavigator
import com.example.make_a_thon.widget.recyclerview.navigator.ReportItemNavigator
import com.example.make_a_thon.widget.recyclerview.viewmodel.ReportItemViewModel

class ReportViewHolder(val binding: ItemReportListBinding) : BaseViewHolder<ReportAdapterNavigator>(binding.root), ReportItemNavigator {

    private val viewModel = ReportItemViewModel()
    private lateinit var reportList: ReportList

    fun bind(data: ReportList) {
        viewModel.bind(data)
        reportList = data
        viewModel.setNavigator(this)
        binding.viewmodel = viewModel
    }
}