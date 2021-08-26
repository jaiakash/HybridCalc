package com.amostrone.akash.hybridcalc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import android.widget.TextView;

public class ouputFragment extends Fragment implements MyInterface {

    TextView ansTV;

    public ouputFragment() {
        // Required empty public constructor
        super(R.layout.fragment_ouput);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setResult(String result) {
        ansTV = getView().findViewById(R.id.ansTextView);
        ansTV.setText(result);
    }
}