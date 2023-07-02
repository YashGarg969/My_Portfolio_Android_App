package com.androidsquad.myportfolio;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Retrieve_Skills_Task extends AsyncTask<Void, Void, List<Skill>> {

    private SkillDao skillDao;
    private RecyclerView recyclerView;
    private skillsAdapter skillsAdapter;

    public Retrieve_Skills_Task(SkillDao skillDao, RecyclerView recyclerView) {
        this.skillDao = skillDao;
        this.recyclerView = recyclerView;
        this.skillsAdapter = new skillsAdapter();
    }
    protected List<Skill> doInBackground(Void... voids) {
        return skillDao.getSkills();
    }
    protected void onPostExecute(List<Skill> newSkill) {
        skillsAdapter.setData(newSkill);
        recyclerView.setAdapter(skillsAdapter);
    }
}