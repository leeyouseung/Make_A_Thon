package com.example.make_a_thon.network.api;

import com.example.make_a_thon.model.report.Image;
import com.example.make_a_thon.network.request.ReportRequest;
import com.example.make_a_thon.network.response.Response;

import io.reactivex.Single;

import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ReportApiJava {

    @POST("/api/report")
    Single<retrofit2.Response<Response<Image>>> report(@Header("token") String token, @Body ReportRequest reportRequest);
}
