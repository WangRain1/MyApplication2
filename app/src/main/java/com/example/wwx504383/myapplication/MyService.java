package com.example.wwx504383.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by wWX504383 on 2017/9/6.
 */

public class MyService extends Service  {


    int w= 100;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        w= 200;

    }

    public class MyBinder extends IMyAidlInterface.Stub {


        @Override
        public int testMed() throws RemoteException {

            return w;
        }
    }

}
