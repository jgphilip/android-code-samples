package com.boomzoned.android_code_samples.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.boomzoned.android_code_samples.R;
import com.boomzoned.android_code_samples.databinding.FragmentFirstBinding;
import com.boomzoned.android_code_samples.viewmodels.MainActivityViewModel;

public class FirstFragment extends Fragment {

    public MainActivityViewModel mainActivityViewModel;

    public  final static String TAG = FirstFragment.class.getCanonicalName();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mainActivityViewModel = new MainActivityViewModel();
        View viewRoot = inflater.inflate(R.layout.fragment_first, container, false);
        FragmentFirstBinding fragmentBinding = DataBindingUtil.bind(viewRoot);
        fragmentBinding.setViewmodel(mainActivityViewModel);
        return fragmentBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Activity mCurrentActivity = getActivity();
        if(mCurrentActivity != null){
            mainActivityViewModel.buttonClicked.observe(getActivity(),(unused)->{
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            });
        }
    }
}
