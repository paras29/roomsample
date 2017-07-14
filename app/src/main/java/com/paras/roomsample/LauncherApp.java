package com.paras.roomsample;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.paras.roomsample.model.database.AppDatabase;

/**
 * Created by Paras on 7/14/2017.
 */

public class LauncherApp extends Application {
    public static LauncherApp mInstance;
    private static AppDatabase dbInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        dbInstance = Room.databaseBuilder(LauncherApp.mInstance.getApplicationContext(),
                AppDatabase.class, "room_test.db")
                .allowMainThreadQueries()
                .build();
    }

    public static AppDatabase getDbInstanc() {
        return dbInstance;
    }
}
