package com.example.tku.accountingsd;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tku.accountingsd.ui.statistics.PieChartFragment;
import com.example.tku.accountingsd.ui.categories.CategoryFragment;
import com.example.tku.accountingsd.ui.homeScreen.homeScreenFragment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Retention(RetentionPolicy.SOURCE)
    public @interface NavigationMode {}

    public static final int NAVIGATION_MODE_STANDARD = 0;
    public static final String NAVIGATION_POSITION = "navigation_position";

    private int mCurrentMode = NAVIGATION_MODE_STANDARD;

    private NavigationView navigationView;

    private SparseArray<String> mCategoryIdToName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setUpDrawer();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if ( savedInstanceState != null) {
            int menuItemId = savedInstanceState.getInt(NAVIGATION_POSITION);
            navigationView.setCheckedItem(menuItemId);
            navigationView.getMenu().performIdentifierAction(menuItemId, 0);
        } else {
            navigationView.getMenu().performIdentifierAction(R.id.nav_home_screen, 0);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    private void initUI() {
        navigationView = (NavigationView)findViewById(R.id.nav_view);
    }

    private void setUpDrawer() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        tellFragments();
        //super.onBackPressed();
    }

    private void tellFragments(){
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        for(Fragment f : fragments){
            if(f != null && f instanceof BaseFragment)
                ((BaseFragment)f).onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*
        if (id == R.id.nav_home_screen) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new homeScreenFragment()).commit();
        } else if (id == R.id.nav_reminder) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new reminderFragment()).commit();
        } else if (id == R.id.nav_depositTarget) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new depositTargetFragment()).commit();
        } else if (id == R.id.nav_cateEdit) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new CategoryFragment()).commit();
        } else if (id == R.id.nav_account) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new settingFragment()).commit();
        } else if (id == R.id.nav_statistics){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new PieChartFragment()).commit();
            //getSupportFragmentManager().beginTransaction().replace(R.id.content_main,new StatisticsFragment()).commit();
        }
        */

        if (id == R.id.nav_home_screen) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new homeScreenFragment()).commit();
        } else if (id == R.id.nav_cateEdit) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new CategoryFragment()).commit();
        } else if (id == R.id.nav_statistics) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, new PieChartFragment()).commit();
        }
            //
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
