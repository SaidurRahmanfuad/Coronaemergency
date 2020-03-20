package com.saidur.corona.tips;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.saidur.corona.R;

public class LiveUpdateActivity extends AppCompatActivity {
    private WebView webview;
    private ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_update);
        webview=findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://www.worldometers.info/coronavirus/#countries");
        // Line of Code for opening links in app
        webview.setWebViewClient(new WebViewClient());
        //clickkick();
    }
    @Override
    public void onBackPressed() {
        if(webview.canGoBack())
        {
            webview.goBack();
        }

        else
        {
            super.onBackPressed();
        }
    }

   /* private void clickkick(){



     *//*   share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);

                i.setType("text/plain");

                i.putExtra(android.content.Intent.EXTRA_TEXT, "My new app https://play.google.com/store/search?q="+ getPackageName());
                startActivity(Intent.createChooser(i, "Share Via"));


                *//**//*Intent shareIn = new Intent(Intent.ACTION_SEND);
                startActivity(Intent.createChooser(shareIn,"Share Using"));*//**//*
            }
        });*//*

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Uri uris = Uri.parse("market://details?id=" + getPackageName());
                    Intent gotomarket = new Intent(Intent.ACTION_VIEW, uris);
                    startActivity(gotomarket);
                }catch (ActivityNotFoundException e){
                    Uri uris = Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName());
                    Intent gotomarket = new Intent(Intent.ACTION_VIEW, uris);
                    startActivity(gotomarket);


                }
            }
        });
    }*/
}
