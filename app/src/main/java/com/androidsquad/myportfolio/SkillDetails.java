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

import java.util.List;

public class SkillDetails extends MainActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout replace= findViewById(R.id.frame);
        View contentView = inflater.inflate(R.layout.activity_skill_details, null, false);
        replace.addView(contentView, 0);
        allocateActivityTitle("My Skills");
        recyclerView=findViewById(R.id.skillsRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getSkillDetails();
    }
    public void getSkillDetails()
    {
        skillDao = AppDatabase.getInstance(this).skillDao();
        new Retrieve_Skills_Task(skillDao,recyclerView).execute();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MyProfile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(150,0);
        finish();
    }
}