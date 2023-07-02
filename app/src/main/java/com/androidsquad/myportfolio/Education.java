package com.androidsquad.myportfolio;

import android.text.Editable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Education")
public class Education {
    @ColumnInfo
    @PrimaryKey @NotNull
    public String course;
    @ColumnInfo
    String duration;
    @ColumnInfo
    String collegeName;
    @ColumnInfo
    String instituteLocation;
    @ColumnInfo
    String cgpa;

    public Education(String course, String duration, String collegeName, String instituteLocation, String cgpa) {
        this.course = course;
        this.duration = duration;
        this.collegeName = collegeName;
        this.instituteLocation = instituteLocation;
        this.cgpa = cgpa;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getInstituteLocation() {
        return instituteLocation;
    }

    public void setInstituteLocation(String instituteLocation) {
        this.instituteLocation = instituteLocation;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
}
