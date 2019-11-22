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

import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;

import com.example.make_a_thon.R;
import com.example.make_a_thon.base.viewmodel.BaseViewModel;
import com.example.make_a_thon.base_java.BaseActivityJava;
import com.example.make_a_thon.database.sharedpreference.Token;
import com.example.make_a_thon.databinding.ActivityReportBinding;
import com.example.make_a_thon.network.api.ReportApiJava;
import com.example.make_a_thon.network.request.ReportRequest;
import com.example.make_a_thon.util.UtilsJava;

import com.google.android.material.navigation.NavigationView;
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

public class ReportActivity extends BaseActivityJava<ActivityReportBinding> implements NavigationView.OnNavigationItemSelectedListener {

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

        binding.navView.setNavigationItemSelectedListener(item -> onNavigationItemSelected(item));

        binding.reportBtn.setOnClickListener(v -> {

            RequestBody reqImage = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part part = MultipartBody.Part.createFormData("image", file.getName(), reqImage);

            RequestBody content = RequestBody.create(MediaType.parse("text/plain"), binding.contentText.getText().toString());

            Token token = new Token(this);

            Call<ReportRequest> reportRequestCall = reportApiJava.report(token.getToken(), content, part);

            reportRequestCall.enqueue(new Callback<ReportRequest>() {
                @Override
                public void onResponse(Call<ReportRequest> call, Response<ReportRequest> response) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }

                @Override
                public void onFailure(Call<ReportRequest> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "신고 오류", Toast.LENGTH_SHORT).show();
                }
            });
        });

        clickEvent();
    }

    private void clickEvent() {

        binding.inputImg.setOnClickListener(v -> goToAlbum());

        onClickMenuBtn();
    }

    @Override
    public void onBackPressed() {
        if (binding.main.isDrawerOpen(GravityCompat.START)) {
            binding.main.closeDrawers();
        }
        else {
            super.onBackPressed();
        }
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id) {

            case R.id.menu_my_profile: startActivity(new Intent(getApplicationContext(), ProFileActivity.class));

            case R.id.menu_my_place: startActivity(new Intent(getApplicationContext(), MyPlaceActivity.class));

            case R.id.menu_report: startActivity(new Intent(getApplicationContext(), ReportActivity.class));

            case R.id.menu_report_list: startActivity(new Intent(getApplicationContext(), ReportListActivity.class));

            case R.id.menu_cctv: startActivity(new Intent(getApplicationContext(), CCTVActivity.class));

            case R.id.menu_check_rescue:startActivity(new Intent(getApplicationContext(), RescueCheckActivity.class));

            default: Toast.makeText(this, "문제가 발생하였습니다", Toast.LENGTH_SHORT).show();
        }

        overridePendingTransition(0, 0);
        binding.main.closeDrawers();

        return false;
    }

    private void onClickMenuBtn() {
        binding.menuMainBtn.setOnClickListener(v -> {

            binding.main.openDrawer(GravityCompat.START);
        });
    }
}
