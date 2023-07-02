package com.androidsquad.myportfolio;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CertificateAdapter extends RecyclerView.Adapter<CertificateAdapter.myViewHolder> {
    List<Certificate> certificates=new ArrayList<>();
    Context context;
    public CertificateAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.certificate_item,parent,false);
       return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.cTitle.setText(certificates.get(position).getCertTitle().toString());
        holder.issueCompany.setText(certificates.get(position).getIssuingComapny().toString());
        holder.link.setText(certificates.get(position).getLink().toString());
        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  url= holder.link.getText().toString();
                if(url.trim().length()!=0)
                {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.launchUrl(context, Uri.parse(url));
                }
                else
                    Toast.makeText(context,"Not Provided Any Link",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return certificates.size();
    }
    public void setData(List<Certificate> newCertificate)
    {
        certificates.clear();
        certificates.addAll(newCertificate);
        notifyDataSetChanged();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView cTitle,issueCompany,link,msg;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            cTitle= itemView.findViewById(R.id.cTitle);
            issueCompany= itemView.findViewById(R.id.company);
            link= itemView.findViewById(R.id.link);
            msg=itemView.findViewById(R.id.msg);
            
        }
    }
}
