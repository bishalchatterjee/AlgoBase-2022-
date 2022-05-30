package com.bishal.algobase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

public class SolutionFragment extends Fragment {

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_solution, container, false);
        String value = getArguments().getString("YourKey"); //getting value(problem url) from ProblemsFragment


               //defining webview
                webView=view.findViewById(R.id.webView);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setBuiltInZoomControls(true);
                webView.getSettings().setDisplayZoomControls(false);

                webView.getSettings().setPluginState(WebSettings.PluginState.ON);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
                webView.getSettings().setUseWideViewPort(true);
                webView.requestFocus(View.FOCUS_DOWN);
                webView.getSettings().setSupportMultipleWindows(false);

                webView.setVerticalScrollBarEnabled(false);
                webView.setHorizontalScrollBarEnabled(false);

                webView.getSettings().setLoadWithOverviewMode(true);
//                webView.getSettings().setUserAgentString("AlgoBase");



                webView.loadUrl(value);





        return view;
    }

}