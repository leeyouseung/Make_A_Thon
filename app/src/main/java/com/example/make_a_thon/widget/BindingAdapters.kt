package com.example.make_a_thon.widget

import android.annotation.SuppressLint

import android.net.Uri

import android.view.View

import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.BindingAdapter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

import com.example.make_a_thon.R

import net.gahfy.mvvmposts.utils.extension.getParentActivity

import java.text.SimpleDateFormat

import java.util.*

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("checkBoxChecked")
fun setMutableChecked(view: CheckBox, check: MutableLiveData<Boolean>) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    check.observe(parentActivity, Observer { value -> view.isChecked = value?:false })
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    visibility?.observe(parentActivity, Observer { value -> view.visibility = value?: View.VISIBLE})
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    text?.observe(parentActivity, Observer { value -> view.text = value?:""})
}

@BindingAdapter("mutableDateText")
fun setMutableDateText(view: TextView, text: MutableLiveData<Date>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    @SuppressLint("SimpleDateFormat")
    val format = SimpleDateFormat("yyyy-MM-dd  E")

    text?.observe(parentActivity, Observer { value -> view.text = format.format(value)?:""})
}

@BindingAdapter("mutableImageDrawable")
fun setMutableImageDrawable(view: ImageView, resid: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    if(resid != null) {
        resid.observe(parentActivity, Observer { value -> view.setImageResource(value)})
    }
    else {
        Glide.with(view.context)
            .load(R.drawable.none_image)
            .into(view)
    }
}

@BindingAdapter("mutableImageUrl")
fun setMutableImageUrl(view: ImageView, url: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    val requestOptions: RequestOptions by lazy {
        RequestOptions()
            .error(R.drawable.none_image)
            .transforms(CenterCrop())
    }

    if(url != null) {
        url.observe(parentActivity, Observer { value -> Glide.with(view.context)
            .load(value)
            .apply(requestOptions)
            .into(view)})
    }
    else {
        Glide.with(view.context)
            .load(R.drawable.none_image)
            .into(view)
    }
}

@BindingAdapter("mutableImageUri")
fun setMutableImageUri(view: ImageView, uri: MutableLiveData<Uri>?) {
    val parentActivity: AppCompatActivity = view.getParentActivity() ?: return

    val requestOptions: RequestOptions by lazy {
        RequestOptions()
            .error(R.drawable.none_image)
            .transforms(CenterCrop())
    }

    if(uri != null) {
        uri.observe(parentActivity, Observer { value -> Glide.with(view.context)
            .load(value)
            .apply(requestOptions)
            .into(view)})
    }
    else {
        Glide.with(view.context)
            .load(R.drawable.none_image)
            .into(view)
    }
}