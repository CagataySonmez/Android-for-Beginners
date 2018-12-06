package com.arcelik.sampleapplication;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
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

            intentHandlerHelper(action, method);
        }
    }

    private void intentHandlerHelper(final String action, final String method) {
        //create a handler to show Toast message
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (ACTION_SEND_NOTIFICATION.equals(action)) {
                    try {
                        Thread.sleep(5000);

                        if (method.equals("TOAST"))
                            Toast.makeText(getApplicationContext(), "This is my Toast message!", Toast.LENGTH_SHORT).show();
                        else
                            Log.d(TAG_INTENT_SERVICE, "Unknown notification method.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
