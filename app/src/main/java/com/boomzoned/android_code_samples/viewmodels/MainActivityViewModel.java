package com.boomzoned.android_code_samples.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = MainActivityViewModel.class.getCanonicalName();
    public MutableLiveData<Void> buttonClicked;

    public MainActivityViewModel() {
        buttonClicked = new MutableLiveData<>();
    }

    public void onNextButtonClicked(){
        Log.d(TAG, "Button Click Handled in ViewModel");
        buttonClicked.setValue(null);
    }
}
