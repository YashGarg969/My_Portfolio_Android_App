package com.androidsquad.myportfolio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Certificate")
public class Certificate {
    @ColumnInfo
    @PrimaryKey @NotNull
    String certTitle;
    @ColumnInfo
    String issuingComapny;
    @ColumnInfo
    String Link;
    public Certificate()
    {

    }
    public Certificate( String certTitle, String issuingComapny, String Link) {
        this.certTitle = certTitle;
        this.issuingComapny = issuingComapny;
        this.Link = Link;
    }

    @NotNull
    public String getCertTitle() {
        return certTitle;
    }

    public void setCertTitle(@NotNull String certTitle) {
        this.certTitle = certTitle;
    }

    public String getIssuingComapny() {
        return issuingComapny;
    }

    public void setIssuingComapny(String issuingComapny) {
        this.issuingComapny = issuingComapny;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
