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
public final class ProjectDAO_Impl implements ProjectDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Project> __insertionAdapterOfProject;

  public ProjectDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProject = new EntityInsertionAdapter<Project>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Project` (`ProjectTitle`,`ProjectDescription`,`DemoLink`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Project value) {
        if (value.getProjectTitle() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProjectTitle());
        }
        if (value.getProjectDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProjectDescription());
        }
        if (value.getDemoLink() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDemoLink());
        }
      }
    };
  }

  @Override
  public void insertProjectRecord(final Project project) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProject.insert(project);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Project> getProjectDetails() {
    final String _sql = "Select * from Project";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProjectTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "ProjectTitle");
      final int _cursorIndexOfProjectDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "ProjectDescription");
      final int _cursorIndexOfDemoLink = CursorUtil.getColumnIndexOrThrow(_cursor, "DemoLink");
      final List<Project> _result = new ArrayList<Project>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Project _item;
        _item = new Project();
        final String _tmpProjectTitle;
        if (_cursor.isNull(_cursorIndexOfProjectTitle)) {
          _tmpProjectTitle = null;
        } else {
          _tmpProjectTitle = _cursor.getString(_cursorIndexOfProjectTitle);
        }
        _item.setProjectTitle(_tmpProjectTitle);
        final String _tmpProjectDescription;
        if (_cursor.isNull(_cursorIndexOfProjectDescription)) {
          _tmpProjectDescription = null;
        } else {
          _tmpProjectDescription = _cursor.getString(_cursorIndexOfProjectDescription);
        }
        _item.setProjectDescription(_tmpProjectDescription);
        final String _tmpDemoLink;
        if (_cursor.isNull(_cursorIndexOfDemoLink)) {
          _tmpDemoLink = null;
        } else {
          _tmpDemoLink = _cursor.getString(_cursorIndexOfDemoLink);
        }
        _item.setDemoLink(_tmpDemoLink);
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
