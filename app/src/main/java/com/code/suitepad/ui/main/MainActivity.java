package com.code.suitepad.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.code.suitepad.R;
import com.code.suitepad.data.DataManager;
import com.code.suitepad.data.Model.Pkg;
import com.code.suitepad.data.source.PackageRepository;
import com.code.suitepad.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    PackageAdapter packageAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        packageAdapter = new PackageAdapter(this);
        recyclerView.setAdapter(packageAdapter);
        presenter.getAllPackages();


    }

    @NonNull
    @Override
    protected MainPresenter createPresenter() {
        PackageRepository packageRepository = DataManager.getInstance().getPackageRepository();
        return new MainPresenter(this, packageRepository);
    }

    @Override
    public void showPackages(List<Pkg> packages) {
        packageAdapter.setItems(packages);

    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Cannot get Packages, an error occured", Toast.LENGTH_SHORT).show();
    }


}
