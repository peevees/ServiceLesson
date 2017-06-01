package com.example.david.servicelesson;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by David on 2017-03-28.
 */

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandle: " + Thread.currentThread().getName());

        int i = 1;

        while(i <= 10) {
            Log.d(TAG, "counter is now " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + Thread.currentThread().getName());

    }
}
