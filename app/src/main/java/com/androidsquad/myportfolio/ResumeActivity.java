package com.androidsquad.myportfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ResumeActivity extends MainActivity {
    SharedPreferences sharedPreferences;
    EditText editLink;
    ImageView confirm;
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allocateActivityTitle("My Resume");
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout replace= findViewById(R.id.frame);
        View contentView = inflater.inflate(R.layout.activity_resume, null, false);
        replace.addView(contentView, 0);
        sharedPreferences = getSharedPreferences("MyLinks",MODE_PRIVATE);
        editLink=findViewById(R.id.changeFields);
        confirm=findViewById(R.id.saveChanges);
        webView=findViewById(R.id.showResume);
        editLink.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                editLink.setVisibility(View.INVISIBLE);
                confirm.setVisibility(View.INVISIBLE);
                return true;
            }
        });
        String resumeUrl=sharedPreferences.getString("ResumeLink","");
        showResume(resumeUrl);
    }

    @Override

    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.addlink, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.resumeLink:
                editLink.setVisibility(View.VISIBLE);
                confirm.setVisibility(View.VISIBLE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                confirm.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                   editor.putString("ResumeLink", editLink.getText().toString()).apply();
                   confirm.setVisibility(View.INVISIBLE);
                   editLink.setVisibility(View.INVISIBLE);
                   }});
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
    private void showResume(String  url)
    {
        if(url.trim().length()!=0)
        {
            webView.loadUrl(url);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());
        }
        else
        {
            Toast.makeText(this, "Link is not available", Toast.LENGTH_SHORT).show();
        }
    }
    public void onBackPressed() {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
        overridePendingTransition(150,0);
        finish();
    }
}