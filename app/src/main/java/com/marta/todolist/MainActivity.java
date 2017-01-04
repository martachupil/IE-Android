package com.marta.todolist;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private WebView internetExplorer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internetExplorer = (WebView) findViewById(R.id.internetExplorer);
        internetExplorer.getSettings().setJavaScriptEnabled(true);

        // Prevent WebView open link in Chrome
        internetExplorer.setWebViewClient(new WebViewClient());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header_menu, menu);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {
                // your text view here
                // textView.setText(newText);
                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                internetExplorer.setVisibility(View.VISIBLE);
                ((ImageView) findViewById(R.id.osel)).setVisibility(View.GONE);
                goToUrl(query);
                return false;
            }
        });

        return true;
    }

    public void goToUrl(String url) {
        internetExplorer.loadUrl(url);
    }
}
