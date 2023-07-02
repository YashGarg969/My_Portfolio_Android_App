package com.androidsquad.myportfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Dao;

import java.util.ArrayList;
import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.myViewHolder> {

    List<Education> details= new ArrayList<>();

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.education_detail_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.course.setText(details.get(position).getCourse().toString());
        holder.duration.setText(details.get(position).getDuration().toString());
        holder.cgpa.setText(details.get(position).getCgpa().toString());
        holder.college.setText(details.get(position).getCollegeName().toString());
        holder.location.setText(details.get(position).getInstituteLocation().toString());
    }

    @Override
    public int getItemCount() {
        return details.size();
    }
    public void setData(List<Education> newEducation)
    {
        details.clear();
        details.addAll(newEducation);
        notifyDataSetChanged();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        private TextView location;
        private TextView cgpa;
        private TextView college;
        private TextView course;
        private TextView duration;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            this.course= (TextView) itemView.findViewById(R.id.course);
            this.duration= (TextView) itemView.findViewById(R.id.duration);
            this.college= (TextView) itemView.findViewById(R.id.college_name);
            this.location= (TextView) itemView.findViewById(R.id.institute_location);
            this.cgpa= (TextView) itemView.findViewById(R.id.Cgpa);

        }
    }
}
