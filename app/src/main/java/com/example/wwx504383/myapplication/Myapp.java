package com.example.wwx504383.myapplication;

import android.app.Application;
import android.util.Log;

/**
 * Created by wWX504383 on 2017/9/6.
 */

public class Myapp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();


        Log.e(">>>>>>>>","<<<<<<<<<Application");
    }
}
