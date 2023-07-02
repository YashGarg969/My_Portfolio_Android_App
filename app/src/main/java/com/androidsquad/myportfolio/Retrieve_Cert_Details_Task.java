package com.androidsquad.myportfolio;

import android.os.AsyncTask;

import androidx.recyclerview.widget.RecyclerView;

import com.androidsquad.myportfolio.Project;
import com.androidsquad.myportfolio.ProjectAdapter;
import com.androidsquad.myportfolio.ProjectDAO;

import java.util.List;

public class Retrieve_Cert_Details_Task extends AsyncTask<Void, Void, List<Certificate>> {

    private CertificateDAO certificateDAO;
    private RecyclerView recyclerView;
    private CertificateAdapter certificateAdapter;

    public Retrieve_Cert_Details_Task(CertificateDAO certificateDAO, RecyclerView recyclerView) {
        this.certificateDAO = certificateDAO;
        this.recyclerView = recyclerView;
        this.certificateAdapter = new CertificateAdapter(recyclerView.getContext());
    }
    protected List<Certificate> doInBackground(Void... voids) {
        return certificateDAO.getCertificateDetails();
    }
    protected void onPostExecute(List<Certificate> certificates) {
        certificateAdapter.setData(certificates);
        recyclerView.setAdapter(certificateAdapter);
    }
}
