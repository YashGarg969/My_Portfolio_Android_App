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
public final class DAO_Impl implements DAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Education> __insertionAdapterOfEducation;

  public DAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEducation = new EntityInsertionAdapter<Education>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Education` (`course`,`duration`,`collegeName`,`instituteLocation`,`cgpa`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Education value) {
        if (value.course == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.course);
        }
        if (value.getDuration() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDuration());
        }
        if (value.getCollegeName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCollegeName());
        }
        if (value.getInstituteLocation() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getInstituteLocation());
        }
        if (value.getCgpa() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCgpa());
        }
      }
    };
  }

  @Override
  public void insertRecord(final Education education) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEducation.insert(education);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Education> getdetails() {
    final String _sql = "Select * from Education";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCourse = CursorUtil.getColumnIndexOrThrow(_cursor, "course");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfCollegeName = CursorUtil.getColumnIndexOrThrow(_cursor, "collegeName");
      final int _cursorIndexOfInstituteLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "instituteLocation");
      final int _cursorIndexOfCgpa = CursorUtil.getColumnIndexOrThrow(_cursor, "cgpa");
      final List<Education> _result = new ArrayList<Education>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Education _item;
        final String _tmpCourse;
        if (_cursor.isNull(_cursorIndexOfCourse)) {
          _tmpCourse = null;
        } else {
          _tmpCourse = _cursor.getString(_cursorIndexOfCourse);
        }
        final String _tmpDuration;
        if (_cursor.isNull(_cursorIndexOfDuration)) {
          _tmpDuration = null;
        } else {
          _tmpDuration = _cursor.getString(_cursorIndexOfDuration);
        }
        final String _tmpCollegeName;
        if (_cursor.isNull(_cursorIndexOfCollegeName)) {
          _tmpCollegeName = null;
        } else {
          _tmpCollegeName = _cursor.getString(_cursorIndexOfCollegeName);
        }
        final String _tmpInstituteLocation;
        if (_cursor.isNull(_cursorIndexOfInstituteLocation)) {
          _tmpInstituteLocation = null;
        } else {
          _tmpInstituteLocation = _cursor.getString(_cursorIndexOfInstituteLocation);
        }
        final String _tmpCgpa;
        if (_cursor.isNull(_cursorIndexOfCgpa)) {
          _tmpCgpa = null;
        } else {
          _tmpCgpa = _cursor.getString(_cursorIndexOfCgpa);
        }
        _item = new Education(_tmpCourse,_tmpDuration,_tmpCollegeName,_tmpInstituteLocation,_tmpCgpa);
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
