package com.eastine.tutu;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.eastine.tutu.customview.R;


public class MainActivity extends Activity {

    private TextView restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
