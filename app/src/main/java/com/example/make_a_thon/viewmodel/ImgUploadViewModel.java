package org.techtown.betweenus_android.viewmodel;

import android.content.Context;
import android.net.Uri;

import androidx.lifecycle.MutableLiveData;

import org.techtown.betweenus_android.base.BaseViewModel;
import org.techtown.betweenus_android.manager.Token;
import org.techtown.betweenus_android.model.Image;
import org.techtown.betweenus_android.network.client.ImgUploadClient;
import org.techtown.betweenus_android.network.request.ImgUploadRequest;

import java.io.File;
import java.util.List;

public class ImgUploadViewModel extends BaseViewModel<List<String>> {

    public MutableLiveData<Uri> uri = new MutableLiveData<>();
    public MutableLiveData<File> file = new MutableLiveData<>();

    public MutableLiveData<List<String>> images = new MutableLiveData<>();

    private ImgUploadClient imgUploadClient;

    public ImgUploadViewModel(Context context) {
        super(context);

        imgUploadClient = new ImgUploadClient();
    }

    public void profileImgUpload(ImgUploadRequest imgUploadRequest) {
        addDisposable(imgUploadClient.profileImgUpload(imgUploadRequest), getDataObserver());
    }

    public void studyImgUpload(ImgUploadRequest imgUploadRequest) {
        addDisposable(imgUploadClient.studyImgUpload(imgUploadRequest), getDataObserver());
    }
}
