package com.arcelik.sampleapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //get last saved value from preferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        String lastSavedDate = sharedPref.getString("last_saved_date", "unsaved!");

        TextView responseFromService = (TextView)findViewById(R.id.save_msg);
        responseFromService.setText("Last Saved Date: " + lastSavedDate);

        // Handle onClickListener of save button.
        Button save = (Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lastSavedDate = getShortDate();
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("last_saved_date", lastSavedDate);
                editor.commit();

                TextView responseFromService = (TextView)findViewById(R.id.save_msg);
                responseFromService.setText("Last Saved Date: " + lastSavedDate);
            }
        });
    }

    private String getShortDate(){
        Date date = Calendar.getInstance().getTime();
        return DateFormat.getTimeInstance(DateFormat.MEDIUM).format(date);
    }
}
