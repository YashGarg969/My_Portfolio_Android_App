package com.androidsquad.myportfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class skillsAdapter extends RecyclerView.Adapter<skillsAdapter.myViewHolder> {
    List<Skill> myskills= new ArrayList<>();

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.skill.setText(myskills.get(position).getSkillName().toString());
    }

    @Override
    public int getItemCount() {
        return myskills.size();
    }
    public void setData(List<Skill> newSkills)
    {
        myskills.clear();
        myskills.addAll(newSkills);
        notifyDataSetChanged();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView skill;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            skill= itemView.findViewById(R.id.skill);
        }
    }
}

