package com.androidsquad.myportfolio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Project")
public class Project {
    @ColumnInfo
    @PrimaryKey @NotNull
    String ProjectTitle;
    @ColumnInfo
    String ProjectDescription;
    @ColumnInfo
    String DemoLink;
    public Project()
    {

    }
    public Project( String projectTitle, String projectDescription, String demoLink) {
        this.ProjectTitle = projectTitle;
        this.ProjectDescription = projectDescription;
        this.DemoLink = demoLink;
    }

    public String getProjectTitle() {
        return ProjectTitle;
    }

    public void setProjectTitle( String projectTitle) {
        ProjectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return ProjectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        ProjectDescription = projectDescription;
    }

    public String getDemoLink() {
        return DemoLink;
    }

    public void setDemoLink(String demoLink) {
        DemoLink = demoLink;
    }
}
