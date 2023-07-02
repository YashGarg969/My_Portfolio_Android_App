package com.androidsquad.myportfolio;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CertificateDAO{
        @Insert
        void insertCertificateRecord(Certificate certificate);
        @Query("SELECT * FROM Certificate")
        List<Certificate> getCertificateDetails();
    }
