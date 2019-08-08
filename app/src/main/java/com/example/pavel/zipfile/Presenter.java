package com.example.pavel.zipfile;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.pavel.zipfile.Adapter.CustomAdapter;
import com.example.pavel.zipfile.Database.MyDataBase;
import com.example.pavel.zipfile.Model.JobWithData;
import com.example.pavel.zipfile.Model.Model;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class Presenter implements InterfaceMvp.Presenter {

    private InterfaceMvp.View view;
    private final String TAG = "myLog";
    private MyDataBase dataBase;


    /*MyDataBase getDataBase(){
        dataBase = view.getDb();
        return dataBase;
    }*/

    @Override
    public void attachView(InterfaceMvp.View view) {
        this.view = view;
        Log.i(TAG,"Enter attachview");
        loadInfo();
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void loadInfo() {
        JobWithData job = new JobWithData(Presenter.this);
        job.getAll();
    }

    @Override
    public AssetManager getPath() {
        return view.getPath();
    }

    @Override
    public MyDataBase getDb() {
        return view.getDb();
    }

    @Override
    public RecyclerView getRv() {
        return view.getRv();
    }

    @Override
    public CustomAdapter getCustAdapt() {
        return view.getCustAdapt();
    }

    @Override
    public Context getContext() {
        return view.getContext();
    }


    /*private void loadInfoToDb(List<Model> models) {
       new AsyncDb(getDataBase(),models,view.getCustAdapt(),view.getRv(),view.getContext()).execute();
    }


    private void getAll(){
        try {
            loadInfoToDb(getInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Model> getInfo() throws IOException {
        Log.i(TAG,"Enter to getinfoooooooooooooo");
        List<Model> list = new ArrayList<>();;
        AssetManager am = view.getPath();
        InputStream a;
        a = am.open("KLIENTS_M.zip");
        try (ZipInputStream zin = new ZipInputStream(a)) {
            Log.i(TAG, "Enter to getinfo");
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                Log.i(TAG, "File name: " + name);
                Scanner in = new Scanner(zin, "Windows-1251");
                String line;
                Model model = new Model();
                List<String> lines = new ArrayList<>();
                while (in.hasNext()) {
                    line = in.nextLine();
                    StringBuffer text = new StringBuffer(line);
                    text.replace(0, 7, "");
                    lines.add(text.toString());
                }
                int ink = 0;
                List<String> list1 = new ArrayList<>();
                for (String str : lines) {
                    int count = 0;

                    for (String retval : str.split(";")) {
                        count++;
                        switch (count) {
                            case 1:
                                model.setCode(retval);
                                break;
                            case 2:
                                model.setLabel(retval);
                                break;
                            case 3:
                                model.setInn(retval);
                                break;
                            case 4:
                                model.setAdress(retval);
                                break;
                            case 5:
                                model.setPhone(retval);
                                break;
                            case 6:
                                model.setFio(retval);
                                break;
                        }
                        //System.out.println(retval);
                        //System.out.println(count);
                    }

                    Log.i(TAG, ink+model.toString());
                    list1.add(model.toString());
                    Model newModel = new Model(model.getCode(),model.getLabel(),model.getInn(),model.getAdress(),
                            model.getPhone(),model.getFio());
                    list.add(newModel);
                    model.clearModel();
                    ink++;
                }
                int i = 0;
                for (String model2: list1){
                    Log.i(TAG,"i   "+i+model2);
                    i++;
                }
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            Log.i(TAG, ex.getMessage() + "lallala");
        }
        a.close();
        int i = 0;
        for (Model modeling: list){
            Log.i(TAG,"hai   "+i+modeling);
            i++;
        }
        return list;
    }*/

}
