package com.ivianuu.commons.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ivianuu.commons.AccessUtil;
import com.ivianuu.commons.Commons;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Commons.init(getApplicationContext());
    }
}
