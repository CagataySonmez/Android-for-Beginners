package com.arcelik.androidwebapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    private  WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webView);

        /* General Webview settings */
        myWebView.setInitialScale(150);
        myWebView.getSettings().setMediaPlaybackRequiresUserGesture(false); //allow video autoplay
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setBackgroundColor(255);
        myWebView.getSettings().setAllowContentAccess(true);
        myWebView.getSettings().setDomStorageEnabled(true); //enable localstorage
        /* General Webview settings */

        //enable/disable remote inspection (disable for release app)
        WebView.setWebContentsDebuggingEnabled(true);

        //Access remote resources from local files
        myWebView.getSettings().setAllowUniversalAccessFromFileURLs(true);

        //define a custom user agent
        myWebView.getSettings().setUserAgentString("Custom User Agent");

        //allow http resources over https connection
        myWebView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        //Enable WebViewClient
        myWebView.setWebViewClient(new webViewHandler(this));

        //Enable WebViewClient
        myWebView.setWebChromeClient(new webChromeHandler(this));

        //Binding JavaScript Code to Java Code
        myWebView.addJavascriptInterface(new jsInterface(this), "arSmartTV");

        myWebView.loadUrl("https://html5test.com/");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()){
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                myWebView.evaluateJavascript("Console.log('PlayPause key pressed...')",
                    new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                            // Prints the string 'null' NOT Java null
                            Log.d(TAG, "Javascript execution result : " + s);
                        }
                    }
            );
                break;
            default:
                return super.dispatchKeyEvent(event);
        }

        return true;
    }
}
