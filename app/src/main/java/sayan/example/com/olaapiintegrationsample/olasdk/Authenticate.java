package sayan.example.com.olaapiintegrationsample.olasdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import sayan.example.com.olaapiintegrationsample.R;

/**
 * Created by Admin on 20-10-2017.
 */

public class Authenticate {

    public static void authenticateUser(final Activity context, final SessionConfig config, final AccessTokenManager accessTokenManager, final
    AuthenticateCallback
            callback){
        final WebView webView = context.findViewById(R.id.webView);
        webView.setVisibility(View.INVISIBLE);
        webView.loadUrl(config.getoAuthUrl());
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains("#")) {
                    webView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (url.contains("permission")) {
                    webView.setVisibility(View.VISIBLE);
                }else if (url.contains("#")) {
                    String redirectedUrlFragment = url.substring(url.indexOf("=",url.indexOf("#"))+1, url.indexOf("&", url.indexOf("#")));
                    accessTokenManager.setAccessToken(redirectedUrlFragment);
                    callback.onAccessTokenSaved(redirectedUrlFragment);
                }else if (url.contains("login")) {
                    if (config.hasUserCredential()) {
                        final String jsUrl = "javascript: {" +
                                "document.getElementById('username').value = '" + config.getUserName() + "';" +
                                "document.getElementById('password').value = '" + config.getPassword() + "';" +
                                "document.forms[0].submit(); };";
        //                            "var elements = document.getElementsByClassName(\"btn btn-primary btn-block\");" +
        //                            "setTimeout(function(){ elements[0].click(); }, 3000); };";
                        if (Build.VERSION.SDK_INT >= 19) {
                            view.evaluateJavascript(jsUrl, new ValueCallback<String>() {
                                @Override
                                public void onReceiveValue(String s) {
                                    Toast.makeText(context, "value: " + s, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            view.loadUrl(jsUrl);
                        }
                    }else {
                        webView.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }
}
