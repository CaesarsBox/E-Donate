package com.example.edonator.ui.Donor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DonorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DonorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Find Blood Donor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}

