package com.androidsquad.myportfolio;

import android.content.Context;
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

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.myViewHolder> {
    List<Project> projects= new ArrayList<>();
    Context context;
    public ProjectAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.pTitle.setText(projects.get(position).getProjectTitle().toString());
        holder.pDescription.setText(projects.get(position).getProjectDescription().toString());
        holder.pDemoLink.setText(projects.get(position).getDemoLink().toString());
        holder.pDemoLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=holder.pDemoLink.getText().toString();
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
        return projects.size();
    }
    public void setData(List<Project> newProject) {
        projects.clear();
        projects.addAll(newProject);
        notifyDataSetChanged();
    }


    public class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView pTitle,pDescription,pDemoLink;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            pTitle=itemView.findViewById(R.id.pTitle);
            pDescription=itemView.findViewById(R.id.desc);
            pDemoLink=itemView.findViewById(R.id.demo);
        }
    }
}
