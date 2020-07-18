package com.studios.prana.ui.Remedies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RemediesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private MutableLiveData<String[]> mTitles;

    private final String[] titles = {"Skin", "Cardiovascular","Mind","Digestive","Eye","Dental","Nose","Blood","Hair","Uterus","Feet","Sleep","Obesity","Ear","Speech"};

    public RemediesViewModel() {
        mTitles = new MutableLiveData<>();
        mTitles.setValue(titles);
    }

    public LiveData<String[]> getTitle() {
        return mTitles;
    }
}