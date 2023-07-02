package com.androidsquad.myportfolio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Skill {
    public Skill(@NotNull String skillName) {
        this.skillName = skillName;
    }

    @ColumnInfo
    @NotNull@PrimaryKey
    String skillName;

    @NotNull
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(@NotNull String skillName) {
        this.skillName = skillName;
    }
}
