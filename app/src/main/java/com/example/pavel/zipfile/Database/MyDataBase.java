package com.example.pavel.zipfile.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.pavel.zipfile.Model.Model;

@Database(entities = {Model.class}, version = 1)
public abstract class MyDataBase extends RoomDatabase {

    private static MyDataBase instance;

    public static MyDataBase getDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, MyDataBase.class, "mydatabase").build();
        }
        return instance;
    }


    public abstract ModelDao modelDao();

}
