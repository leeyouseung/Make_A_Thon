package com.example.make_a_thon.view.activity;

import android.Manifest;

import android.content.Intent;

import android.database.Cursor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.net.Uri;

import android.os.Bundle;

import android.provider.MediaStore;

import android.util.Log;

import android.widget.Toast;

import com.example.make_a_thon.R;
import com.example.make_a_thon.base_java.BaseActivityJava;
import com.example.make_a_thon.database.sharedpreference.Token;
import com.example.make_a_thon.databinding.ActivityReportBinding;
import com.example.make_a_thon.network.api.ReportApiJava;
import com.example.make_a_thon.network.request.ReportRequest;
import com.example.make_a_thon.util.UtilsJava;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;

import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends BaseActivityJava<ActivityReportBinding> {

    File tempFile;
    File file;
    Bitmap[] imageList = new Bitmap[1];

    private final int PICK_FROM_ALBUM = 1;

    private Uri photoURI;

    ReportApiJava reportApiJava = UtilsJava.RETROFIT.create(ReportApiJava.class);

    @Override
    protected int layoutId() {

        return R.layout.activity_report;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViewModel();
        initImg();

        binding.reportBtn.setOnClickListener(v -> {

            RequestBody reqImage = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), reqImage);

            RequestBody content = RequestBody.create(MediaType.parse("text/plain"), binding.contentText.getText().toString());

            Token token = new Token(this);

            Call<ReportRequest> reportRequestCall = reportApiJava.report(token.getToken(), content, part);

            reportRequestCall.enqueue(new Callback<ReportRequest>() {
                @Override
                public void onResponse(Call<ReportRequest> call, Response<ReportRequest> response) {
                    Toast.makeText(getApplicationContext(), "신고가 접수 되었습니다", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }

                @Override
                public void onFailure(Call<ReportRequest> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "신고 오류", Toast.LENGTH_SHORT).show();
                }
            });
        });

        clickEvent();
    }

    private void initViewModel() {

//        reportViewModel = ViewModelProviders.of(this, new ViewModelFactory(this)).get(ReportViewModel.class);
//        imgUploadViewModel = ViewModelProviders.of(this, new ViewModelFactory(this)).get(ImgUploadViewModel.class);
    }

    private void initImg() {
//        Glide.with(this).load(imgUploadViewModel.uri.getValue()).into(binding.inputImg);
    }

    private void clickEvent() {

        binding.inputImg.setOnClickListener(v -> goToAlbum());
    }

    private void goToAlbum() {

        tedPermission();

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
        startActivityForResult(intent, PICK_FROM_ALBUM);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_ALBUM) {
            Uri photoUri = data.getData();

            Cursor cursor = null;
            try {
                String [] proj = { MediaStore.Images.Media.DATA};
                assert photoUri != null;
                cursor = getContentResolver().query(photoUri, proj, null, null, null);

                assert cursor != null;
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();

                tempFile = new File(cursor.getString(column_index));

            } catch (Exception e) {
                Log.d("TAG", e.getMessage() + "");
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }

            setImage();
        }
    }

    private void tedPermission() {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() { }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(getApplicationContext(), "접근을 허용해야 사진을 등록할 수 있습니다", Toast.LENGTH_LONG).show();
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }

    private void setImage() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(tempFile.getAbsolutePath(), options);
        Log.d("LOG", tempFile.getAbsolutePath()); // -> 파일 경로

        imageList[0] = bitmap;

        file = new File(tempFile.getAbsolutePath());

        binding.inputImg.setImageBitmap(imageList[0]);
        if (imageList[0].toString() != null) {
            Log.d("IMAGE", imageList[0].toString());
        } else {
            Log.d("IMAGE", "null임");
        }
    }
}
