package com.androidsquad.myportfolio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;

public class CertificationDetails extends MainActivity {
    RecyclerView recyclerView;
    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allocateActivityTitle("Certifications");
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout replace= findViewById(R.id.frame);
        View contentView = inflater.inflate(R.layout.activity_certification_details, null, false);
        replace.addView(contentView, 0);
         msg= findViewById(R.id.msg);
        recyclerView=findViewById(R.id.certificateRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDetails();
    }
    protected void getDetails()
    {
        certificateDAO = AppDatabase.getInstance(this).certificateDAO();
        new Retrieve_Cert_Details_Task(certificateDAO,recyclerView).execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
        overridePendingTransition(150,150);
        finish();
    }
}