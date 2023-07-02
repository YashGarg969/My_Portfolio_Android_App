package com.androidsquad.myportfolio;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile SkillDao _skillDao;

  private volatile CertificateDAO _certificateDAO;

  private volatile ProjectDAO _projectDAO;

  private volatile DAO _dAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Skill` (`skillName` TEXT NOT NULL, PRIMARY KEY(`skillName`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Certificate` (`certTitle` TEXT NOT NULL, `issuingComapny` TEXT, `Link` TEXT, PRIMARY KEY(`certTitle`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Education` (`course` TEXT NOT NULL, `duration` TEXT, `collegeName` TEXT, `instituteLocation` TEXT, `cgpa` TEXT, PRIMARY KEY(`course`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Project` (`ProjectTitle` TEXT NOT NULL, `ProjectDescription` TEXT, `DemoLink` TEXT, PRIMARY KEY(`ProjectTitle`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '36f036a57821c43627baa77513a68e20')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Skill`");
        _db.execSQL("DROP TABLE IF EXISTS `Certificate`");
        _db.execSQL("DROP TABLE IF EXISTS `Education`");
        _db.execSQL("DROP TABLE IF EXISTS `Project`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSkill = new HashMap<String, TableInfo.Column>(1);
        _columnsSkill.put("skillName", new TableInfo.Column("skillName", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSkill = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSkill = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSkill = new TableInfo("Skill", _columnsSkill, _foreignKeysSkill, _indicesSkill);
        final TableInfo _existingSkill = TableInfo.read(_db, "Skill");
        if (! _infoSkill.equals(_existingSkill)) {
          return new RoomOpenHelper.ValidationResult(false, "Skill(com.androidsquad.myportfolio.Skill).\n"
                  + " Expected:\n" + _infoSkill + "\n"
                  + " Found:\n" + _existingSkill);
        }
        final HashMap<String, TableInfo.Column> _columnsCertificate = new HashMap<String, TableInfo.Column>(3);
        _columnsCertificate.put("certTitle", new TableInfo.Column("certTitle", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCertificate.put("issuingComapny", new TableInfo.Column("issuingComapny", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCertificate.put("Link", new TableInfo.Column("Link", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCertificate = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCertificate = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCertificate = new TableInfo("Certificate", _columnsCertificate, _foreignKeysCertificate, _indicesCertificate);
        final TableInfo _existingCertificate = TableInfo.read(_db, "Certificate");
        if (! _infoCertificate.equals(_existingCertificate)) {
          return new RoomOpenHelper.ValidationResult(false, "Certificate(com.androidsquad.myportfolio.Certificate).\n"
                  + " Expected:\n" + _infoCertificate + "\n"
                  + " Found:\n" + _existingCertificate);
        }
        final HashMap<String, TableInfo.Column> _columnsEducation = new HashMap<String, TableInfo.Column>(5);
        _columnsEducation.put("course", new TableInfo.Column("course", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducation.put("duration", new TableInfo.Column("duration", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducation.put("collegeName", new TableInfo.Column("collegeName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducation.put("instituteLocation", new TableInfo.Column("instituteLocation", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEducation.put("cgpa", new TableInfo.Column("cgpa", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEducation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEducation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEducation = new TableInfo("Education", _columnsEducation, _foreignKeysEducation, _indicesEducation);
        final TableInfo _existingEducation = TableInfo.read(_db, "Education");
        if (! _infoEducation.equals(_existingEducation)) {
          return new RoomOpenHelper.ValidationResult(false, "Education(com.androidsquad.myportfolio.Education).\n"
                  + " Expected:\n" + _infoEducation + "\n"
                  + " Found:\n" + _existingEducation);
        }
        final HashMap<String, TableInfo.Column> _columnsProject = new HashMap<String, TableInfo.Column>(3);
        _columnsProject.put("ProjectTitle", new TableInfo.Column("ProjectTitle", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProject.put("ProjectDescription", new TableInfo.Column("ProjectDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProject.put("DemoLink", new TableInfo.Column("DemoLink", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProject = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProject = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProject = new TableInfo("Project", _columnsProject, _foreignKeysProject, _indicesProject);
        final TableInfo _existingProject = TableInfo.read(_db, "Project");
        if (! _infoProject.equals(_existingProject)) {
          return new RoomOpenHelper.ValidationResult(false, "Project(com.androidsquad.myportfolio.Project).\n"
                  + " Expected:\n" + _infoProject + "\n"
                  + " Found:\n" + _existingProject);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "36f036a57821c43627baa77513a68e20", "98461110f645fa4c97c17b63c90641d4");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Skill","Certificate","Education","Project");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Skill`");
      _db.execSQL("DELETE FROM `Certificate`");
      _db.execSQL("DELETE FROM `Education`");
      _db.execSQL("DELETE FROM `Project`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(SkillDao.class, SkillDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CertificateDAO.class, CertificateDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(ProjectDAO.class, ProjectDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAO.class, DAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public SkillDao skillDao() {
    if (_skillDao != null) {
      return _skillDao;
    } else {
      synchronized(this) {
        if(_skillDao == null) {
          _skillDao = new SkillDao_Impl(this);
        }
        return _skillDao;
      }
    }
  }

  @Override
  public CertificateDAO certificateDAO() {
    if (_certificateDAO != null) {
      return _certificateDAO;
    } else {
      synchronized(this) {
        if(_certificateDAO == null) {
          _certificateDAO = new CertificateDAO_Impl(this);
        }
        return _certificateDAO;
      }
    }
  }

  @Override
  public ProjectDAO projectDAO() {
    if (_projectDAO != null) {
      return _projectDAO;
    } else {
      synchronized(this) {
        if(_projectDAO == null) {
          _projectDAO = new ProjectDAO_Impl(this);
        }
        return _projectDAO;
      }
    }
  }

  @Override
  public DAO educationDao() {
    if (_dAO != null) {
      return _dAO;
    } else {
      synchronized(this) {
        if(_dAO == null) {
          _dAO = new DAO_Impl(this);
        }
        return _dAO;
      }
    }
  }
}
