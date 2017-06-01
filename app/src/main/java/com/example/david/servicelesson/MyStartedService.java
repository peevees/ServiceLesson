package com.example.david.servicelesson;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by David on 2017-03-28.
 */

public class MyStartedService extends Service {

    private static final String TAG = MyStartedService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: " + Thread.currentThread().getName());

    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: " + Thread.currentThread().getName());

        new MyAsyncTask().execute();

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + Thread.currentThread().getName());

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: " + Thread.currentThread().getName());
    }

    class MyAsyncTask extends AsyncTask<Integer, String, Void> {

        private final String TAG = MyAsyncTask.class.getSimpleName();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d(TAG, "onPre: " + Thread.currentThread().getName());
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBAck: " + Thread.currentThread().getName());

            int i = 1;

            while(i <= 10) {
                publishProgress("Counter is now " + String.valueOf(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            Log.d(TAG, "onProgressUpdate: " + values[0]+ " " + Thread.currentThread().getName());
        }

        @Override
        protected  void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPost: " + Thread.currentThread().getName());

        }

    }



}
