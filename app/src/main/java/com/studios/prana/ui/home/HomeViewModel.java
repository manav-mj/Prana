package com.studios.prana.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Set;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    private MutableLiveData<String[]> mTitles;

    private final String[] titles = {"Mind", "Cardiovascular","Skin","Digestive","Eye","Dental","Nose","Blood","Hair","Uterus","Feet","Sleep","Obesity","Ear","Speech"};

    public HomeViewModel() {
        mTitles = new MutableLiveData<>();
        mTitles.setValue(titles);
    }

    public LiveData<String[]> getTitle() {
        return mTitles;
    }
}