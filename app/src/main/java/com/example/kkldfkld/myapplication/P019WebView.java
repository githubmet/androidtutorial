package com.example.kkldfkld.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import android.webkit.WebView;
import android.widget.EditText;

public class P019WebView extends Activity implements View.OnClickListener {

    WebView webViewBrowser;
    EditText editTextBrowse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p019webview);

        Button buttonBrowse= (Button)findViewById(R.id.buttonBrowse);
        Button buttonGoBack= (Button)findViewById(R.id.buttonGoBack);
        Button buttonGoForward= (Button)findViewById(R.id.buttonGoForward);
        Button buttonRefresh= (Button)findViewById(R.id.buttonRefresh);
        Button buttonCleanHistory= (Button)findViewById(R.id.buttonCleanHistory);

        buttonBrowse.setOnClickListener(this);
        buttonGoBack.setOnClickListener(this);
        buttonGoForward.setOnClickListener(this);
        buttonRefresh.setOnClickListener(this);
        buttonCleanHistory.setOnClickListener(this);

        webViewBrowser.getSettings().setJavaScriptEnabled(true);
        webViewBrowser.getSettings().setLoadWithOverviewMode(true);
        webViewBrowser.getSettings().setUseWideViewPort(true);
        try {
            webViewBrowser.loadUrl("http://www.google.com");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        editTextBrowse=(EditText)findViewById(R.id.editTextBrowse);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonBrowse:
                String theUrl="http://"+editTextBrowse.getText().toString();
                webViewBrowser.loadUrl(theUrl);

                //this two line of code is abouth to delete virtual keyword!
                InputMethodManager inputMethodManager= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(editTextBrowse.getWindowToken(), 0);

                break;
            case R.id.buttonGoBack:
                if(webViewBrowser.canGoBack()){
                    webViewBrowser.goBack();
                }
                break;
            case R.id.buttonGoForward:
                if(webViewBrowser.canGoForward()){
                    webViewBrowser.goForward();
                }
                break;
            case R.id.buttonRefresh:
                webViewBrowser.reload();
                break;
            case R.id.buttonCleanHistory:
                webViewBrowser.clearHistory();
                break;
        }
    }
}
