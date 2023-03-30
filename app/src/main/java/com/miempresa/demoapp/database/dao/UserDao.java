package com.miempresa.demoapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.miempresa.demoapp.database.entity.User;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertUser(User user);

    @Query("SELECT * FROM user WHERE userEmail=:userEmail")
    User getUserByEmail(String userEmail);

    @Query("SELECT * FROM user WHERE userEmail=:userEmail AND userPassword=:userPassword")
    User verifyUserLogin(String userEmail, String userPassword);

    @Query("SELECT * FROM user WHERE sesion=1")
    User verifySesion();

    @Query("UPDATE user SET userPassword=:userPassword WHERE userEmail=:userEmail")
    void updatePassByUserEmail(String userEmail, String userPassword);

    @Query("UPDATE user SET sesion=:sesion WHERE userEmail=:userEmail")
    void updateSesion(String userEmail, boolean sesion);

    @Query("UPDATE user SET sesion=0")
    void closeAllSesion();
}
