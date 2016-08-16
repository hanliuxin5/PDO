package com.pdc.lychee.planetdefenseoffice.z_test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.pdc.lychee.planetdefenseoffice.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        toolbarLayout.setTitle("title");
        toolbarLayout.setExpandedTitleColor(Color.parseColor("purple"));
        toolbarLayout.setCollapsedTitleTextColor(Color.parseColor("green"));
        toolbarLayout.setContentScrimColor(Color.parseColor("yellow"));

//        toolbar.setTitle("toolbar title");
//        toolbar.setSubtitle("toolbar subtitle");
//        toolbar.setTitleTextColor(Color.parseColor("navy"));
//        toolbar.setSubtitleTextColor(Color.parseColor("blue"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dp_fragment_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
