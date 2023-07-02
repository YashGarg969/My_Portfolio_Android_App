package com.androidsquad.myportfolio;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CertificateDAO_Impl implements CertificateDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Certificate> __insertionAdapterOfCertificate;

  public CertificateDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCertificate = new EntityInsertionAdapter<Certificate>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Certificate` (`certTitle`,`issuingComapny`,`Link`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Certificate value) {
        if (value.getCertTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCertTitle());
        }
        if (value.getIssuingComapny() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIssuingComapny());
        }
        if (value.getLink() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLink());
        }
      }
    };
  }

  @Override
  public void insertCertificateRecord(final Certificate certificate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCertificate.insert(certificate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Certificate> getCertificateDetails() {
    final String _sql = "SELECT * FROM Certificate";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCertTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "certTitle");
      final int _cursorIndexOfIssuingComapny = CursorUtil.getColumnIndexOrThrow(_cursor, "issuingComapny");
      final int _cursorIndexOfLink = CursorUtil.getColumnIndexOrThrow(_cursor, "Link");
      final List<Certificate> _result = new ArrayList<Certificate>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Certificate _item;
        _item = new Certificate();
        final String _tmpCertTitle;
        if (_cursor.isNull(_cursorIndexOfCertTitle)) {
          _tmpCertTitle = null;
        } else {
          _tmpCertTitle = _cursor.getString(_cursorIndexOfCertTitle);
        }
        _item.setCertTitle(_tmpCertTitle);
        final String _tmpIssuingComapny;
        if (_cursor.isNull(_cursorIndexOfIssuingComapny)) {
          _tmpIssuingComapny = null;
        } else {
          _tmpIssuingComapny = _cursor.getString(_cursorIndexOfIssuingComapny);
        }
        _item.setIssuingComapny(_tmpIssuingComapny);
        final String _tmpLink;
        if (_cursor.isNull(_cursorIndexOfLink)) {
          _tmpLink = null;
        } else {
          _tmpLink = _cursor.getString(_cursorIndexOfLink);
        }
        _item.setLink(_tmpLink);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
