package com.boomzoned.android_code_samples.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.boomzoned.android_code_samples.MainActivity;
import com.boomzoned.android_code_samples.R;
import com.boomzoned.android_code_samples.databinding.FragmentFirstBinding;
import com.boomzoned.android_code_samples.viewmodels.MainActivityViewModel;

public class FirstFragment extends Fragment {

    public MainActivityViewModel mainActivityViewModel;

    public  final static String TAG = FirstFragment.class.getCanonicalName();

    private Context mContext;

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
        mContext = getContext();
//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "Button Click Handled in View");
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
//            }
//        });
        Activity mCurrentActivity = getActivity();
        if(mCurrentActivity != null){
            mainActivityViewModel.buttonClicked.observe(getActivity(),(unused)->{
                Toast.makeText(mContext,"Button Clicked",Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            });
        }
    }
}
