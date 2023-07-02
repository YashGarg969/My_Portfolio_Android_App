package com.androidsquad.myportfolio;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SkillDao {
    @Insert
    void insertSkill(Skill skill);
    @Query("SELECT * FROM Skill")
    List<Skill> getSkills();
}
