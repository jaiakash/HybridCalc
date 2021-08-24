package com.amostrone.akash.hybridcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, inputFragment.class, null)
                    .commit();
        }
    }

    public void calc_clicked(View view) {
        EditText edtone = findViewById(R.id.editText1);
        EditText edttwo = findViewById(R.id.editText2);
        float a = Float.parseFloat(edtone.getText().toString());
        float b = Float.parseFloat(edttwo.getText().toString());
        float ans=0;
        switch (view.getId()) {
            case R.id.plus:
                ans=a+b;
                break;
            case R.id.minus:
                ans=a-b;
                break;
            case R.id.mul:
                ans=a*b;
                break;
            case R.id.div:
                if(b!=0) ans=a/b;
                else ans=-1;
                break;
        }
        Toast.makeText(this, ans+"", Toast.LENGTH_SHORT).show();
    }
}