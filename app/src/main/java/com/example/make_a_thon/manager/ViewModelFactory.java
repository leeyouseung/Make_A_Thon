package com.example.make_a_thon.manager;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.make_a_thon.viewmodel.ImgUploadViewModel;
import com.example.make_a_thon.viewmodel.ReportViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private Context context;

    public ViewModelFactory(Context context) {
        this.context = context;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass == ReportViewModel.class) {
            return (T) new ReportViewModel(context);
        } else if (modelClass == ImgUploadViewModel.class) {
            return (T) new ImgUploadViewModel(context);
        } else {
            return super.create(modelClass);
        }
    }

}
