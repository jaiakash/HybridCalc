package com.amostrone.akash.hybridcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyInterface {

    public static float a_val=0,b_val=0,ans=0;
    boolean operation_pressed=false;
    public static int op=0;
    String operation="None";

    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_container_input, new inputFragment());
            ft.replace(R.id.fragment_container_output, new ouputFragment());
            ft.addToBackStack(null);
            ft.commit();

        }
    }

    float getnum(View view,float a){
        switch (view.getId()) {
            case R.id.one:
                a=a*10+1;
                break;
            case R.id.two:
                a=a*10+2;
                break;
            case R.id.three:
                a=a*10+3;
                break;
            case R.id.four:
                a=a*10+4;
                break;
            case R.id.five:
                a=a*10+5;
                break;
            case R.id.six:
                a=a*10+6;
                break;
            case R.id.seven:
                a=a*10+7;
                break;
            case R.id.eight:
                a=a*10+8;
                break;
            case R.id.nine:
                a=a*10+9;
                break;
            case R.id.zero:
                a=a*10+0;
                break;
        }
        return a;
    }

    public void calc_clicked(View view) {

        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Vibrate for 400 milliseconds
        v.vibrate(300);

        switch (view.getId()) {
            case R.id.add:
                operation_pressed=true;
                operation="Addition";
                op=1;
                break;
            case R.id.sub:
                operation_pressed=true;
                operation="Subtraction";
                op=2;
                break;
            case R.id.mul:
                operation_pressed=true;
                operation="Multiplication";
                op=3;
                break;
            case R.id.div:
                operation_pressed=true;
                operation="Division";
                op=4;
                break;
            case R.id.pow:
                operation_pressed=true;
                operation="Exponent";
                op=5;
                break;
            case R.id.clear_all:
                operation_pressed=false;
                operation="None";
                op=0;
                a_val=0;
                b_val=0;
                break;
            case R.id.clear:
                b_val=0;
                break;
            case R.id.ans:
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
                break;
            case R.id.decimal:
                if(a_val==0 || !operation_pressed) a_val = getnum(view,a_val)/10;
                else if(b_val==0 || operation_pressed) b_val = getnum(view,b_val)/10;
                break;
            default:
                if(view.getId() == R.id.sign) {
                    if(!operation_pressed)a_val*=-1;
                    else b_val*=-1;
                }
                if(a_val==0 || !operation_pressed) a_val = getnum(view,a_val);
                else if(b_val==0 || operation_pressed) b_val = getnum(view,b_val);
        }
        TextView opTV = findViewById(R.id.opTextView);
        TextView TVa = findViewById(R.id.aTextView);
        TextView TVb = findViewById(R.id.bTextView);
        opTV.setText("Operation = "+operation);
        TVa.setText("A = "+a_val);
        TVb.setText("B = "+b_val);

        ((MyInterface)this).setResult("Your ans = "+ans);
    }

    @Override
    public void setResult(String s) {
        ouputFragment outputF = (ouputFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_output);
        outputF.setResult(s);
    }
}