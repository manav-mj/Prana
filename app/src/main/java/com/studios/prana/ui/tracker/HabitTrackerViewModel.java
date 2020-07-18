package com.studios.prana.ui.tracker;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.studios.prana.models.TrackerData;
import com.studios.prana.utils.Utils;

public class HabitTrackerViewModel extends ViewModel {

    private MutableLiveData<TrackerData> mData;

    public HabitTrackerViewModel(Context context) {
        mData = new MutableLiveData<>();
        mData.setValue(Utils.getAlarmsData(context));
    }

    public LiveData<TrackerData> getText() {
        return mData;
    }
}