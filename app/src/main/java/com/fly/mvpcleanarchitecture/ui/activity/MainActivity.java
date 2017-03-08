package com.fly.mvpcleanarchitecture.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.fly.mvpcleanarchitecture.R;
import com.fly.mvpcleanarchitecture.app.MvpCleanApplication;
import com.fly.mvpcleanarchitecture.app.models.ApiService;
import com.fly.mvpcleanarchitecture.ui.BaseActivity;
import com.fly.mvpcleanarchitecture.ui.presenter.TestPresenter;
import com.fly.mvpcleanarchitecture.ui.view.View;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements View.TestView {

    @Inject
    ApiService apiService;
    @Inject
    TestPresenter testPresenter;
    @Inject
    TestPresenter testPresenter2;
    @Bind(R.id.test_btn)
    Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        testPresenter.setView(this);
    }

    @Override
    public void injectDependencies() {
        MvpCleanApplication.getApplicationComponent().inject(this);
    }

    @OnClick(R.id.test_btn)
    public void onClick() {
        testPresenter.sayHello();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void sayHello() {

        Toast.makeText(this, "啦啦啦啦", Toast.LENGTH_LONG).show();
    }
}
