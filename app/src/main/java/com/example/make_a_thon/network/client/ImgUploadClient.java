package com.example.make_a_thon.network.client;

import com.example.make_a_thon.base_java.BaseClientJava;
import com.example.make_a_thon.model.report.Image;
import com.example.make_a_thon.network.api.ImgUploadApi;
import com.example.make_a_thon.network.request.ImgUploadRequest;

import io.reactivex.Single;

public class ImgUploadClient extends BaseClientJava<ImgUploadApi> {

    @Override
    protected Class api() {

        return ImgUploadApi.class;
    }

    public Single<Image> reportImgUpload(ImgUploadRequest imgUploadRequest) {

        return api.reportImgUpload(imgUploadRequest.getFile()).map(getResponseObjectsFunction());
    }
}
