package com.example.make_a_thon.base_java;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import androidx.lifecycle.ViewModelProviders;

public abstract class BaseActivityJava<VB extends ViewDataBinding, VM extends BaseViewModelJava> extends AppCompatActivity {

    protected VB binding;
    protected VM viewModel;

    @LayoutRes
    protected abstract int getLayoutId();

    protected abstract Class<VM> getViewModel();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = ViewModelProviders.of(this).get(getViewModel());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binding = null;
    }

    @Override
    public void setRequestedOrientation(int requestedOrientation) {
        if (Build.VERSION.SDK_INT != Build.VERSION_CODES.O) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }

    protected void startActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }

    protected void startActivityWithFinish(Class activity) {
        startActivity(new Intent(this, activity));
        finish();
    }

    protected void simpleToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void simpleToast(int message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
