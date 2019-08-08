package com.example.pavel.zipfile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.pavel.zipfile.Model.Model;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {
    Intent intent;
    private Model model;
    @BindView(R.id.text_fio)
    TextView text_fio;
    @BindView(R.id.text_adress)
    TextView text_adress;
    @BindView(R.id.text_phone)
    TextView text_phone;
    @BindView(R.id.text_inn)
    TextView text_inn;
    @BindView(R.id.text_code)
    TextView text_code;
    @BindView(R.id.text_label)
    TextView text_label;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle("ZIP");
        intent = getIntent();
        model = (Model) intent.getSerializableExtra("value");
        text_adress.setText(model.getAdress());
        text_code.setText(model.getCode());
        text_fio.setText((!model.getFio().isEmpty()) ? model.getFio():"NoName");
        text_phone.setText((!model.getPhone().isEmpty()) ? model.getPhone():"NoPhone");
        text_inn.setText((!model.getInn().isEmpty()) ? model.getInn():"NoInn");
        text_label.setText(model.getLabel());
    }
}
