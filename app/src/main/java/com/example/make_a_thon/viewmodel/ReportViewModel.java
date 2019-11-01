//package com.example.make_a_thon.viewmodel;
//
//import android.content.Context;
//
//import com.example.make_a_thon.base_java.BaseViewModelJava;
//import com.example.make_a_thon.network.client.ReportClientJava;
//import com.example.make_a_thon.network.request.ReportRequest;
//
//public class ReportViewModel extends BaseViewModelJava<ReportClientJava> {
//
//    private ReportClientJava reportClient;
//
//    public ReportViewModel(Context context) {
//        super(context);
//
//        reportClient = new ReportClientJava();
//    }
//
//    public void report(ReportRequest reportRequest) {
//
//        addDisposable(reportClient.report(getToken(), reportRequest), getBaseObserver());
//    }
//}
