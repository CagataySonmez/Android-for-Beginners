package com.arcelik.sampleapplication;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import static java.lang.Thread.*;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class MyIntentService extends IntentService {
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String ACTION_SEND_NOTIFICATION = "com.arcelik.sampleapplication.action.ACTION_SEND_NOTIFICATION";
    public static final String NOTIFICATION_METHOD = "com.arcelik.sampleapplication.extra.NOTIFICATION_METHOD";
    public static final String TAG_INTENT_SERVICE = "SAMPLE_APP_INTENT_SERV";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG_INTENT_SERVICE, "MyIntentService onCreate() method is invoked.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG_INTENT_SERVICE, "MyIntentService onDestroy() method is invoked.");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            final String method = intent.getStringExtra(NOTIFICATION_METHOD);

            //we have a sample business logic here:
            //show toast message if the action is ACTION_SEND_NOTIFICATION
            //and the method is TOAST
            if (ACTION_SEND_NOTIFICATION.equals(action) && method.equals("TOAST"))
                intentHandlerHelper();
            else
                Log.d(TAG_INTENT_SERVICE, "Intent received but action or method is not known!");
        }
    }

    /**
     * Do CPU intensive Tasks in onHandleIntent method.
     * Do not worry, this method does not run in UI thread
     */
    private void intentHandlerHelper() {
        try {
            Thread.sleep(5000);
            showToastMessage("This is my Toast message!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Toast message needs and application context to show message
     * Therefore we call Toast.makeText function in UI thread
     * Be careful, below code blocks UI thread, but we just use
     * it to show toast message. This part is not related to the
     * IntentService demo!
     */
    private void showToastMessage(final String msg){
        //create a handler to show Toast message
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
