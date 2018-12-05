package com.arcelik.sampleapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    //Use broadcast receiver to get broadcast messages
    final IntentFilter myFilter = new IntentFilter(MyService.BROADCAST_INTENT);
    private MyBroadcastReceiver mReceiver = new MyBroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final TextView responseFromService = (TextView)findViewById(R.id.msgArea);
            responseFromService.setText(intent.getCharSequenceExtra("msg"));
        }
    };

    @Override
    public void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isMyServiceRunning(MyService.class))
            ((Button)findViewById(R.id.start_service)).setText(R.string.stop_service_button);

        // Click this button to start service.
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

        // Click this button to start intent service.
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

        registerReceiver(mReceiver, myFilter);
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
