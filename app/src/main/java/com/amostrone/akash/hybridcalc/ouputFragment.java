package com.amostrone.akash.hybridcalc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import android.widget.TextView;

public class ouputFragment extends Fragment {

    public ouputFragment() {
        // Required empty public constructor
        super(R.layout.fragment_ouput);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                String result = bundle.getString("bundleKey");
                // Do something with the result
                TextView ansTV = getView().findViewById(R.id.ansTextView);
                ansTV.setText(result);
            }
        });
    }
}