package com.baim.baimproject.lisviu;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.baim.baimproject.CobaLagi;
import com.baim.baimproject.MainActivity;
import com.baim.baimproject.ProfileFragment;
import com.baim.baimproject.R;
import com.baim.baimproject.lihatdatamakanan.Main2Activity;
import com.baim.baimproject.lihatdatamakanan.datamakanan.TabFragment;


public class NaviBaru extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = NaviBaru.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_navi_baru);


        mToolbar = (Toolbar) findViewById(R.id.toolbar2);

        setSupportActionBar(mToolbar);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.title_home);
                break;
            case 1:
              fragment = new TabFragment();
                title = getString(R.string.title_friends);
                break;
            case 2:
               Intent i = new Intent(NaviBaru.this, MainActivity.class);
                startActivity(i);
                finish();
                title = getString(R.string.title_notifications);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }
}