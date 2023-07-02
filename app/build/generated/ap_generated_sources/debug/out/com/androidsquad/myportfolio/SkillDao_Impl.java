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
public final class SkillDao_Impl implements SkillDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Skill> __insertionAdapterOfSkill;

  public SkillDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSkill = new EntityInsertionAdapter<Skill>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Skill` (`skillName`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Skill value) {
        if (value.getSkillName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSkillName());
        }
      }
    };
  }

  @Override
  public void insertSkill(final Skill skill) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfSkill.insert(skill);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Skill> getSkills() {
    final String _sql = "SELECT * FROM Skill";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSkillName = CursorUtil.getColumnIndexOrThrow(_cursor, "skillName");
      final List<Skill> _result = new ArrayList<Skill>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Skill _item;
        final String _tmpSkillName;
        if (_cursor.isNull(_cursorIndexOfSkillName)) {
          _tmpSkillName = null;
        } else {
          _tmpSkillName = _cursor.getString(_cursorIndexOfSkillName);
        }
        _item = new Skill(_tmpSkillName);
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
