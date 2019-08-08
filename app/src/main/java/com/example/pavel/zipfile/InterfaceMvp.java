package com.example.pavel.zipfile;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;

import com.example.pavel.zipfile.Adapter.CustomAdapter;
import com.example.pavel.zipfile.Database.MyDataBase;


public interface InterfaceMvp {
    interface View {
        AssetManager getPath();
        MyDataBase getDb();
        RecyclerView getRv();
        CustomAdapter getCustAdapt();
        Context getContext();
    }

    interface Presenter {

        void attachView(View view);

        void detachView();

        void loadInfo();

        AssetManager getPath();
        MyDataBase getDb();
        RecyclerView getRv();
        CustomAdapter getCustAdapt();
        Context getContext();

    }
}
