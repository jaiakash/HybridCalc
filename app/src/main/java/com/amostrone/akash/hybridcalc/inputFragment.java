package com.amostrone.akash.hybridcalc;

import static com.amostrone.akash.hybridcalc.MainActivity.a_val;
import static com.amostrone.akash.hybridcalc.MainActivity.b_val;
import static com.amostrone.akash.hybridcalc.MainActivity.op;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.Button;

public class inputFragment extends Fragment {

    public inputFragment() {
        super(R.layout.fragment_input);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button ansbutton = getView().findViewById(R.id.ans);
        ansbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                float ans=0;
                switch(op){
                    case 1:
                        ans=a_val+b_val;
                        break;
                    case 2:
                        ans=a_val-b_val;
                        break;
                    case 3:
                        ans=a_val*b_val;
                        break;
                    case 4:
                        if(b_val!=0) ans=a_val/b_val;
                        else ans=-1;
                        break;
                    case 5:
                        ans=(float)Math.pow(a_val,b_val);
                        break;
                }
                result.putString("bundleABC", "Your ans = "+ans);
                getParentFragmentManager().setFragmentResult("requestXYZ", result);
            }
        });
    }
}