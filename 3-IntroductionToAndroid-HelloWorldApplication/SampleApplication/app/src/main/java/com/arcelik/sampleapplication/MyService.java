package com.arcelik.sampleapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyService extends Service {
    public static final String BROADCAST_INTENT = "com.arcelik.sampleapplication.NOTIFICATION";
    public static final String BROADCAST_PERMISSION = "com.arcelik.sampleapplication.permission.NOTIFICATION";

    private static final String TAG_SERVICE = "SAMPLE_APP_SERVICE";

    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;
    private HandlerThread mThread;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }
        @Override
        public void handleMessage(Message msg) {

            Log.d(TAG_SERVICE, "handleMessage: " + msg);

            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                while(true) {
                    Thread.sleep(5000);

                    //generate message
                    Date date = Calendar.getInstance().getTime();
                    String dateAsStr = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(date);
                    String notification = dateAsStr + ": dummy message from MyService!";

                    //Send broadcast
                    broadcastNotification(notification);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.d(TAG_SERVICE, "Exception occurred in MyService: " + e.toString());

                //Send broadcast
                broadcastNotification("Thread is interrupted!");
            }
        }
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        mThread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        mThread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = mThread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "MyService onStartCommand() method is invoked.", Toast.LENGTH_SHORT).show();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        // If we get killed, after returning from here, restart
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // We don't provide binding, so return null
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "MyService onDestroy() method is invoked.", Toast.LENGTH_SHORT).show();
        mThread.interrupt();
        mThread.quit();
    }

    //Helper message to send broadcast
    public void broadcastNotification(String notification){
        //Send broadcast
        final Intent intent = new Intent(BROADCAST_INTENT);
        intent.putExtra("msg", notification);
        sendBroadcast(intent, BROADCAST_PERMISSION);
    }
}
