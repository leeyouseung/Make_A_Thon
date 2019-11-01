package com.example.make_a_thon.network.api;

import com.example.make_a_thon.network.request.ReportRequest;
import com.example.make_a_thon.network.response.Response;

import io.reactivex.Single;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ReportApiJava {

    @Multipart
    @POST("/api/report")
    Call<ReportRequest> report(
            @Header("token") String token,
            @Part("content") RequestBody content,
            @Part MultipartBody.Part image
    );
}
