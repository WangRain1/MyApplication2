package com.example.wwx504383.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    IMyAidlInterface iMyAidlInterface;

    ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connection = new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

                    iMyAidlInterface=IMyAidlInterface.Stub.asInterface(iBinder);

                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    iMyAidlInterface =null;
                }
        };

        Intent intent = new Intent(this,MyService.class);

        bindService(intent,connection,BIND_AUTO_CREATE);
    }


    public void start(View view ){

        int q = new MyService().w;

        Log.e("========","========="+q);

    }

    public void get(View view ) throws RemoteException {

        Log.e("=",">>>>返回的w=="+iMyAidlInterface.testMed());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
