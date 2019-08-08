package com.example.pavel.zipfile.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Model implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String code;
    private String label;
    private String inn;
    private String adress;
    private String phone;
    private String fio;

    @Ignore
    public Model(String code, String label, String inn, String adress, String phone, String fio) {
        this.code = code;
        this.label = label;
        this.inn = inn;
        this.adress = adress;
        this.phone = phone;
        this.fio = fio;
    }

    public Model(Long id, String code, String label, String inn, String adress, String phone, String fio) {
        this.id = id;
        this.code = code;
        this.label = label;
        this.inn = inn;
        this.adress = adress;
        this.phone = phone;
        this.fio = fio;
    }
    @Ignore
    public Model() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getCode()+" "+getLabel()+" "+getInn()+" "+getAdress()+" "+getPhone()+" "+getFio();
    }

    public void clearModel(){
        setCode("");
        setLabel("");
        setInn("");
        setAdress("");
        setPhone("");
        setFio("");
    }
}

