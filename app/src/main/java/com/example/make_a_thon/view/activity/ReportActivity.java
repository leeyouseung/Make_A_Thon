//package com.example.make_a_thon.view.activity;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.os.Environment;
//import android.provider.MediaStore;
//import android.widget.Toast;
//
//import androidx.lifecycle.ViewModelProviders;
//
//import com.bumptech.glide.Glide;
//import com.example.make_a_thon.R;
//import com.example.make_a_thon.base_java.BaseActivityJava;
//import com.example.make_a_thon.databinding.ActivityReportBinding;
//import com.example.make_a_thon.manager.ViewModelFactory;
//import com.example.make_a_thon.network.request.ImgUploadRequest;
//import com.example.make_a_thon.network.request.ReportRequest;
//import com.example.make_a_thon.viewmodel.ImgUploadViewModel;
//import com.example.make_a_thon.viewmodel.ReportViewModel;
//import com.gun0912.tedpermission.PermissionListener;
//import com.gun0912.tedpermission.TedPermission;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Random;
//
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//
//public class ReportActivity extends BaseActivityJava<ActivityReportBinding> {
//
//    private ReportViewModel reportViewModel;
//    private ImgUploadViewModel imgUploadViewModel;
//
//    private final int PICK_FROM_ALBUM = 1;
//    private final int REQUEST_IMAGE_CROP = 2;
//
//    private Uri photoURI;
//
//    @Override
//    protected int layoutId() {
//        return R.layout.activity_report;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        imgUploadViewModel.getData().observe(this, images -> imgUploadViewModel.image.setValue(images));
//
//        reportViewModel.getSuccessMessage().observe(this, message -> {
//            Toast.makeText(this, "신고를 성공했습니다", Toast.LENGTH_LONG).show();
//            startActivity(new Intent(this, MainActivity.class));
//        });
//
//        clickEvent();
//    }
//
//    private void clickEvent() {
//
//        binding.inputImg.setOnClickListener(v -> goToAlbum());
//
//        binding.reportBtn.setOnClickListener(v -> {
//
//            reportViewModel.report(new ReportRequest(
//                    binding.contentText.getText().toString(),
//                    imgUploadViewModel.image.getValue()
//            ));
//        });
//    }
//
//    private void goToAlbum() {
//
//        tedPermission();
//
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
//        startActivityForResult(intent, PICK_FROM_ALBUM);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        switch (requestCode) {
//            case PICK_FROM_ALBUM:
//                if (data == null) {
//                    return;
//                }
//
//                photoURI = data.getData();
//
//                cropImage();
//
//                break;
//
//
//            case REQUEST_IMAGE_CROP:
//
//                if (resultCode == Activity.RESULT_OK) {
//
//                    RequestBody mFile = RequestBody.create(MediaType.parse("image/*"), imgUploadViewModel.file.getValue());
//                    MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("img", imgUploadViewModel.file.getValue().getName(), mFile);
//
//                    ImgUploadRequest imgUploadRequest = new ImgUploadRequest(fileToUpload);
//
//                    imgUploadViewModel.reportImgUpload(imgUploadRequest);
//
//                    Glide.with(this).load(imgUploadViewModel.uri.getValue()).into(binding.inputImg);
//                }
//
//                break;
//        }
//    }
//
//    private void cropImage() {
//
//        File file = new File(Environment.getExternalStorageDirectory().toString() + "/BetweenUs");
//
//        if (!file.exists())
//
//            file.mkdirs();
//
//        imgUploadViewModel.file.setValue(new File(Environment.getExternalStorageDirectory().toString() + "/BetweenUs/temp" + new Random().nextInt(100000000) + ".jpg"));
//
//        try {
//            imgUploadViewModel.file.getValue().createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        imgUploadViewModel.uri.setValue(Uri.fromFile(imgUploadViewModel.file.getValue()));
//
//        Intent cropIntent = new Intent("com.android.camera.action.CROP");
//
//        cropIntent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//        cropIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        cropIntent.setDataAndType(photoURI, "image/*");
//        cropIntent.putExtra("aspectX",1);
//        cropIntent.putExtra("aspectY",1);
//        cropIntent.putExtra("scale",true);
//        cropIntent.putExtra("output",imgUploadViewModel.uri.getValue());
//
//        startActivityForResult(cropIntent,REQUEST_IMAGE_CROP);
//
//    }
//    private void tedPermission() {
//
//        PermissionListener permissionListener = new PermissionListener() {
//            @Override
//            public void onPermissionGranted() { }
//
//            @Override
//            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
//                Toast.makeText(getApplicationContext(), "접근을 허용해야 사진을 등록할 수 있습니다", Toast.LENGTH_LONG).show();
//            }
//        };
//
//        TedPermission.with(this)
//                .setPermissionListener(permissionListener)
//                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
//                .check();
//
//    }
//}
