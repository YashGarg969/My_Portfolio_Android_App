package com.androidsquad.myportfolio;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RetrieveDetailsTask extends AsyncTask<Void, Void, List<Project>> {

    private ProjectDAO projectDAO;
    private RecyclerView recyclerView;
    private ProjectAdapter projectAdapter;

    public RetrieveDetailsTask(ProjectDAO projectDAO, RecyclerView recyclerView) {
        this.projectDAO = projectDAO;
        this.recyclerView = recyclerView;
        this.projectAdapter = new ProjectAdapter(recyclerView.getContext());
    }
    protected List<Project> doInBackground(Void... voids) {
        return projectDAO.getProjectDetails();
    }
    protected void onPostExecute(List<Project> projects) {
        projectAdapter.setData(projects);
        recyclerView.setAdapter(projectAdapter);
    }
}
