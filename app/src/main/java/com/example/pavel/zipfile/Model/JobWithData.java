package com.example.pavel.zipfile.Model;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.pavel.zipfile.AsyncDb;
import com.example.pavel.zipfile.InterfaceMvp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class JobWithData {
    private InterfaceMvp.Presenter presenter;

    public JobWithData(InterfaceMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    public InterfaceMvp.Presenter getPresenter() {
        return presenter;
    }

    private List<Model> getInfo() throws IOException {
        List<Model> list = new ArrayList<>();
        AssetManager am = getPresenter().getPath();
        InputStream a;
        a = am.open("KLIENTS_M.zip");
        try (ZipInputStream zin = new ZipInputStream(a)) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
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
                    }

                    list1.add(model.toString());
                    Model newModel = new Model(model.getCode(),model.getLabel(),model.getInn(),model.getAdress(),
                            model.getPhone(),model.getFio());
                    list.add(newModel);
                    model.clearModel();
                    ink++;
                }
            }
        } catch (Exception ex) {

        }
        a.close();
        return list;
    }

    private void loadInfoToDb(List<Model> models) {
        new AsyncDb(getPresenter().getDb(),models,getPresenter().getCustAdapt(),getPresenter().getRv(),
                getPresenter().getContext()).execute();
    }

    public void getAll(){
        try {
            loadInfoToDb(getInfo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
