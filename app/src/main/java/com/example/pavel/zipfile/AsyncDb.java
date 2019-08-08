package com.example.pavel.zipfile;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pavel.zipfile.Adapter.CustomAdapter;
import com.example.pavel.zipfile.Database.MyDataBase;
import com.example.pavel.zipfile.Model.Model;

import java.util.ArrayList;
import java.util.List;

 public class AsyncDb extends AsyncTask <Void,Void,List<Model>> {
    private MyDataBase dataBase;
    private List<Model> models;
    private final String TAG = "myLog";
    private List<Model> modeling = new ArrayList<>();
    private CustomAdapter customAdapter;
    private RecyclerView recyclerView;
    private Context context;


    public AsyncDb(MyDataBase dataBase, List<Model> models, CustomAdapter customAdapter, RecyclerView recyclerView, Context context) {
        this.dataBase = dataBase;
        this.models = models;
        this.customAdapter = customAdapter;
        this.recyclerView = recyclerView;
        this.context = context;
    }

    @Override
    protected List<Model> doInBackground(Void... voids) {
        if (dataBase.modelDao().getAll().isEmpty()) {
            dataBase.modelDao().insert(models);
            Log.i(TAG, "TRUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            modeling = dataBase.modelDao().getAll();
            for (Model m : modeling) {
                Log.i(TAG, "Yeah" + m.toString());
            }
            Log.i(TAG, "Yeahhhhhhhhhhhhhhhhhhhh");
        }
        else
            modeling = dataBase.modelDao().getAll();
        return modeling;
    }


    @Override
    protected void onPostExecute(List<Model> models) {
        super.onPostExecute(models);
        customAdapter = new CustomAdapter(models,context);
        recyclerView.setAdapter(customAdapter);
    }
}
