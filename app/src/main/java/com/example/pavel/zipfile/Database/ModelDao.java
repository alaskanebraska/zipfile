package com.example.pavel.zipfile.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.pavel.zipfile.Model.Model;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface ModelDao {

    @Query("SELECT * FROM Model")
    List<Model> getAll();

    @Insert
    void insert(List<Model> models);

}
