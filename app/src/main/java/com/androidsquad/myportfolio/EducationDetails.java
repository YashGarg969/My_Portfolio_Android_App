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
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.androidsquad.myportfolio.databinding.ActivityEducationDetailsBinding;

import java.util.List;

public class EducationDetails extends MainActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allocateActivityTitle("Education Details");
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout replace= findViewById(R.id.frame);
        View contentView = inflater.inflate(R.layout.activity_education_details, null, false);
        replace.addView(contentView, 0);
        recyclerView= findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getRoomData();
    }
    public void getRoomData()
    {
        educationDao=AppDatabase.getInstance(this).educationDao();
        new Retrieve_Education_Task(educationDao,recyclerView).execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
        overridePendingTransition(150,150);
        finish();
    }
}