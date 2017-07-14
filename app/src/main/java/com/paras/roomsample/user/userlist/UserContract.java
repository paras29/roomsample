package com.paras.roomsample.user.userlist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.paras.roomsample.model.datamodel.User;

import java.util.List;

/**
 * Created by Paras on 7/14/2017.
 */

public interface UserContract {
    @Dao
    public interface UserDao {
        @Query("SELECT * FROM user")
        List<User> getAll();

        @Query("SELECT * FROM user WHERE uid IN (:userIds)")
        List<User> loadAllByIds(int[] userIds);

        @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
                + "last_name LIKE :last LIMIT 1")
        User findByName(String first, String last);

        @Insert
        void insertAll(User... users);

        @Delete
        void delete(User user);
    }
}
