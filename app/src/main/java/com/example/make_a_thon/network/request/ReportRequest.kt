package com.example.make_a_thon.network.request

class ReportRequest(var id: String,
                    var category: String,
                    var content: String)
{
    constructor() : this("", "", "")
}