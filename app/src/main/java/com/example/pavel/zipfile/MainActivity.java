package com.example.pavel.zipfile;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import com.example.pavel.zipfile.Adapter.CustomAdapter;
import com.example.pavel.zipfile.Database.MyDataBase;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements InterfaceMvp.View {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private CustomAdapter customAdapter;
    private final String TAG = "myLog";
    private MyDataBase myDataBase;
    private Context context;


    private InterfaceMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bindViews();
        attachPresenter();
       // presenter.loadInfo();
    }

    private void attachPresenter() {
        presenter = (InterfaceMvp.Presenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new Presenter();
        }
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    private void bindViews() {
        ButterKnife.bind(this);
        context = this;
        setSupportActionBar(toolbar);
        toolbar.setTitle("ZIP");
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
    }

    @Override
    public AssetManager getPath() {
        AssetManager am = this.getAssets();
        return am;
    }

    @Override
    public MyDataBase getDb() {
        myDataBase = MyDataBase.getDatabase(this);
        return myDataBase;
    }

    @Override
    public RecyclerView getRv() {
        return rv;
    }

    @Override
    public CustomAdapter getCustAdapt() {
        return customAdapter;
    }

    @Override
    public Context getContext() {
        return context;
    }

}
