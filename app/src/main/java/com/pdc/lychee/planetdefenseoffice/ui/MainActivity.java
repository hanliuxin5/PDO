package com.pdc.lychee.planetdefenseoffice.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.widget.FrameLayout;

import com.pdc.lychee.planetdefenseoffice.R;
import com.pdc.lychee.planetdefenseoffice.base.activity.BaseActivity;

import butterknife.Bind;

/**
 * Created by lychee on 2016/6/15.
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.fl_container)
    FrameLayout flContainer;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
