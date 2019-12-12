package com.arcelik.androidwebapp;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class webChromeHandler extends WebChromeClient {
    private String TAG = "WebViewClient";
    private Activity context;

    public webChromeHandler(Activity ct){
        this.context =  ct;
    }

    @Override
    public void onProgressChanged(WebView view, int progress)
    {
        // Return the app name after finish loading
        if(progress == 100)
            Log.d(TAG,"Load finished!");
        else
            Log.d(TAG,"progress: " + progress + "%");
    }

    @Override
    public void onCloseWindow (WebView window){
        super.onCloseWindow(window);
        context.finish();
    }
}
