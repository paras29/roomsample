package com.paras.roomsample.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.paras.roomsample.model.datamodel.User;
import com.paras.roomsample.user.userlist.UserContract;

/**
 * Created by Paras on 7/14/2017.
 */

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserContract.UserDao userDao();

}