package com.example.mengjiu.ui.myorder;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyorderViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MyorderViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home frfgfdgbfgbt");
    }

    public LiveData<String> getText() {
        return mText;
    }
}