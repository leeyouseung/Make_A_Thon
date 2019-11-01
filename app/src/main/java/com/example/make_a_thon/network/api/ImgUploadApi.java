package com.example.make_a_thon.network.api;

import com.example.make_a_thon.model.report.Image;
import com.example.make_a_thon.network.response.Response;

import io.reactivex.Single;

import okhttp3.MultipartBody;

import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ImgUploadApi {

    @Multipart
    @POST("/api/report")
    Single<retrofit2.Response<Response<Image>>> reportImgUpload(@Part MultipartBody.Part file);
}
