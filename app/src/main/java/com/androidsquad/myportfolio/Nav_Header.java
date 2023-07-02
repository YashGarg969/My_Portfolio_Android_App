package com.androidsquad.myportfolio;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class Nav_Header extends MainActivity {
    CircleImageView profile;
    SharedPreferences sp;
    TextView Name,Position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_header);
        profile=findViewById(R.id.profilePic);
        Name=findViewById(R.id.yash);
        Position=findViewById(R.id.myPosition);
        Name=findViewById(R.id.yash);
        sp=getSharedPreferences("my_preference",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String text=sp.getString("MyName","");
        Name.setText(text);
    }
}