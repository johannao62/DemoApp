package com.miempresa.demoapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.miempresa.demoapp.database.dao.UserDao;
import com.miempresa.demoapp.database.entity.User;

@Database(entities = {User.class},version = 1)
public abstract class UDataBase extends RoomDatabase {
    public abstract UserDao getAllDao();

    private static UDataBase instance;

    public static UDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context,
                            UDataBase.class,"demoapp.db"
                    ).allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
