package com.androidsquad.myportfolio;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Skill.class, Certificate.class,Education.class,Project.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SkillDao skillDao();
    public abstract CertificateDAO certificateDAO();
    public abstract ProjectDAO projectDAO();
    public abstract DAO educationDao();
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "my_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
