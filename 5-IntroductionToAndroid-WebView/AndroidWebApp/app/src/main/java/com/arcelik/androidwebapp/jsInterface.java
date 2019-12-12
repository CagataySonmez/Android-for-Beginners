package com.arcelik.androidwebapp;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.Locale;

/**
 * Binds js functions to Java functions
 */
public class jsInterface {
    private String TAG = "jsInterface";
    private Activity context;
    public jsInterface(Activity context){
        this.context = context;
    }

    @JavascriptInterface
    public String getLanguage(){
        return Locale.getDefault().getLanguage();
    }

    @JavascriptInterface
    public String getCountry(){
        return Locale.getDefault().getCountry();
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();
    }
}
