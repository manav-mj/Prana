package com.studios.prana.ui.dashboard;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.studios.prana.models.LifestyleData;
import com.studios.prana.utils.Utils;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<LifestyleData> mData;

    public DashboardViewModel(Context context) {
        mData = new MutableLiveData<>();
        mData.setValue(Utils.getLifestyleContent(context));
    }

    public LiveData<LifestyleData> getData() {
        return mData;
    }
}