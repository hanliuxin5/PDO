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
import com.pdc.lychee.planetdefenseoffice.module.deepspace.DeepSpaceMainFragment;
import com.pdc.lychee.planetdefenseoffice.module.mars.MarsMainFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

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

    private MainContract.Presenter mainPresenter;

    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fl_container, DeepSpaceMainFragment.newInstance());
        }
        initView();
    }

    private void initView() {
        navView.setNavigationItemSelectedListener(this);
        navView.setCheckedItem(R.id.nav_deep);

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
        if (presenter != null)
            mainPresenter = presenter;
    }


    @Override
    public void openDrawer() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public void closeDrawer() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_deep:
                DeepSpaceMainFragment deepSpaceMainFragment = findFragment(DeepSpaceMainFragment.class);
                start(deepSpaceMainFragment, SupportFragment.SINGLETASK);
                break;
            case R.id.nav_mars:
                MarsMainFragment marsMainFragment = findFragment(MarsMainFragment.class);
                if (marsMainFragment == null) {
                    popTo(DeepSpaceMainFragment.class, false, new Runnable() {
                        @Override
                        public void run() {
                            start(MarsMainFragment.newInstance());
                        }
                    });
                } else {
                    // 如果已经在栈内,则以SingleTask模式start
                    start(marsMainFragment, SupportFragment.SINGLETASK);
                }
                break;
        }
        return true;
    }
}
