package com.androidsquad.myportfolio;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Retrieve_Education_Task extends AsyncTask<Void, Void, List<Education>> {

    private DAO educationDao;
    private RecyclerView recyclerView;
    private EducationAdapter educationAdapter;

    public Retrieve_Education_Task(DAO educationDao, RecyclerView recyclerView) {
        this.educationDao = educationDao;
        this.recyclerView = recyclerView;
        this.educationAdapter = new EducationAdapter();
    }
    protected List<Education> doInBackground(Void... voids) {
        return educationDao.getdetails();
    }
    protected void onPostExecute(List<Education> education) {
        educationAdapter.setData(education);
        recyclerView.setAdapter(educationAdapter);
    }
}
