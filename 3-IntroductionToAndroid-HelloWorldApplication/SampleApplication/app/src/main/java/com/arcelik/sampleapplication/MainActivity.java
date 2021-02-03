package com.arcelik.sampleapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG_ACTIVITY = "SAMPLE_APP_ACTIVITY";

    //Use broadcast receiver to get broadcast messages
    final IntentFilter myFilter = new IntentFilter(MyService.BROADCAST_INTENT);
    private MyBroadcastReceiver mReceiver = new MyBroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg = (String) intent.getCharSequenceExtra("msg");
            Log.d(TAG_ACTIVITY, "Broadcast msg received: " + msg);
            final TextView msgArea = (TextView)findViewById(R.id.msgArea);
            msgArea.setText(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG_ACTIVITY, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart() {
        Log.d(TAG_ACTIVITY, "onStart");
        super.onStart();

        if(isMyServiceRunning(MyService.class))
            ((Button)findViewById(R.id.start_service)).setText(R.string.stop_service_button);

        // Handle onClickListener of start service button.
        Button startService = (Button)findViewById(R.id.start_service);
        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.msgArea)).setText("");

                Intent intent = new Intent(MainActivity.this, MyService.class);
                if(isMyServiceRunning(MyService.class)){
                    stopService(intent);
                    ((Button)findViewById(R.id.start_service)).setText(R.string.start_service_button);
                }
                else {
                    startService(intent);
                    ((Button)findViewById(R.id.start_service)).setText(R.string.stop_service_button);
                }
            }
        });

        // Handle onClickListener of start intent service button.
        Button startIntentService = (Button)findViewById(R.id.start_intent_service);
        startIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.setAction(MyIntentService.ACTION_SEND_NOTIFICATION);
                intent.putExtra(MyIntentService.NOTIFICATION_METHOD, "TOAST");
                startService(intent);
            }
        });

        // Handle onClickListener of settings button.
        Button settings = (Button)findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        registerReceiver(mReceiver, myFilter);
    }

    @Override
    public void onResume() {
        Log.d(TAG_ACTIVITY, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG_ACTIVITY, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG_ACTIVITY, "onStop");
        unregisterReceiver(mReceiver);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG_ACTIVITY, "onDestroy");
        super.onDestroy();
    }

    //helper function to check if background service (MyService) is running
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}
