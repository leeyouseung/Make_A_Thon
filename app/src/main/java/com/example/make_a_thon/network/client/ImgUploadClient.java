package org.techtown.betweenus_android.network.client;

import android.net.Uri;

import org.techtown.betweenus_android.base.BaseClient;
import org.techtown.betweenus_android.manager.Token;
import org.techtown.betweenus_android.model.Image;
import org.techtown.betweenus_android.network.api.ImgUploadApi;
import org.techtown.betweenus_android.network.request.ImgUploadRequest;

import java.util.List;

import io.reactivex.Single;

public class ImgUploadClient extends BaseClient<ImgUploadApi> {

    @Override
    protected Class api() {
        return ImgUploadApi.class;
    }

    public Single<Image> profileImgUpload(ImgUploadRequest imgUploadRequest) {

        return api.profileImgUpload(imgUploadRequest.getFile()).map(getResponseObjectsFunction());
    }

    public Single<List<String>> studyImgUpload(ImgUploadRequest imgUploadRequest) {
        return api.studyImgUpload(imgUploadRequest.getFile()).map(getResponseObjectsFunction());
    }
}
