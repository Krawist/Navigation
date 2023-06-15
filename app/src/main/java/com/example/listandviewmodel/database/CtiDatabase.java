package com.example.listandviewmodel.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.listandviewmodel.database.dao.StudentDao;
import com.example.listandviewmodel.database.models.StudentCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {StudentCache.class}, version = 1)
public abstract class CtiDatabase extends RoomDatabase {
    public abstract StudentDao getStudentDao();

    private static volatile CtiDatabase database;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    public static CtiDatabase getInstance(Context context){
        if(database == null){
            database = Room.databaseBuilder(context,
                    CtiDatabase.class, "cti-database").build();
        }

        return database;
    }
}
