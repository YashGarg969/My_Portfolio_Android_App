package com.androidsquad.myportfolio;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.List;

public class project_details extends MainActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allocateActivityTitle("My Projects");
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout replace= findViewById(R.id.frame);
        View contentView = inflater.inflate(R.layout.activity_project_details, null, false);
        replace.addView(contentView, 0);
        recyclerView=findViewById(R.id.projectRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDetails();
    }
    public void getDetails()
    {
        projectDAO = AppDatabase.getInstance(this).projectDAO();
        new RetrieveDetailsTask(projectDAO,recyclerView).execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
        overridePendingTransition(150,150);
        finish();
    }
}