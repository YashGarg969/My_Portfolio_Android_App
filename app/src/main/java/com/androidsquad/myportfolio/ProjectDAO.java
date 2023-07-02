package com.androidsquad.myportfolio;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ProjectDAO {

    @Insert
    void insertProjectRecord(Project project);
    @Query("Select * from Project")
    List<Project> getProjectDetails();
}
