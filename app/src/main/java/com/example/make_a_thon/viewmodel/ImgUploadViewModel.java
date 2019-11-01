//package com.example.make_a_thon.viewmodel;
//
//import android.content.Context;
//import android.net.Uri;
//
//import androidx.lifecycle.MutableLiveData;
//
//import com.example.make_a_thon.base_java.BaseViewModelJava;
//import com.example.make_a_thon.network.client.ImgUploadClient;
//import com.example.make_a_thon.network.request.ImgUploadRequest;
//
//import java.io.File;
//
//public class ImgUploadViewModel extends BaseViewModelJava<String> {
//
//    public MutableLiveData<Uri> uri = new MutableLiveData<>();
//    public MutableLiveData<File> file = new MutableLiveData<>();
//
//    public MutableLiveData<String> image = new MutableLiveData<>();
//
//    private ImgUploadClient imgUploadClient;
//
//    public ImgUploadViewModel(Context context) {
//        super(context);
//
//        imgUploadClient = new ImgUploadClient();
//    }
//
//    public void reportImgUpload(ImgUploadRequest imgUploadRequest) {
//        addDisposable(imgUploadClient.reportImgUpload(imgUploadRequest), getDataObserver());
//    }
//}
