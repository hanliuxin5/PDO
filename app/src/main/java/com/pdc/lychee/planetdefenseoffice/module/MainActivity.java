package com.pdc.lychee.planetdefenseoffice.module;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.base.activity.BaseActivity;

import butterknife.Bind;

/**
 * Created by lychee on 2016/6/15.
 */
public class MainActivity extends BaseActivity implements MainContract.View, NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.fl_container)
    FrameLayout flContainer;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private MainPrsenter mainPrsenter;

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        navView.setNavigationItemSelectedListener(this);
        navView.setCheckedItem(R.id.nav_pdo);

        LinearLayout llNavHeader = (LinearLayout) navView.getHeaderView(0);
        llNavHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void showOffice(int index) {

    }

    @Override
    public void showNetWorkingError() {

    }

    @Override
    public void showPopUpMenu() {

    }

    @Override
    public void openDrawer() {

    }

    @Override
    public void closeDrawer() {

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
