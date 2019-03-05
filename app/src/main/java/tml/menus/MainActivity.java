package tml.menus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import tml.hawktalk.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        InitializeUI();
        displayView(R.id.nav_friends);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        if (getSupportActionBar().getTitle() != "Friends") { //if the current view is not the News fragment
            displayView(R.id.nav_friends); //display the News fragment
        } else {
            moveTaskToBack(true);  //If view is in News fragment, exit application
        }
    }

    @Override
    protected void onResume()
    {
        UpdateUI();
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int viewId = item.getItemId();
        if (viewId == R.id.nav_settings) {
            Intent settingIntent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(settingIntent);
        } else{
            displayView(viewId);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void displayView(int viewId) {
        Fragment fragment = null;
        String title = getSupportActionBar().getTitle().toString();

        switch (viewId) {
            case R.id.nav_groups:
                fragment = new GroupsFragment();
                title  = "Groups";
                break;
            case R.id.nav_friends:
                fragment = new FriendsFragment();
                title  = "Friends";
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void InitializeUI() {
        //set friends button as default on load
    ((NavigationView)findViewById(R.id.nav_view)).getMenu().getItem(0).setChecked(true);

    // full name on nav header
        TextView navFullname = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0).findViewById(R.id.nav_subtitle);
        String FullName = getString(R.string.usr_first_name) + " " + getString(R.string.usr_last_name);
        navFullname.setText(FullName);
        UpdateUI();
    }
    public void UpdateUI() {
        // if display name is empty, change to full name
//        Log.d("sett", "UpdateUI: " + PreferenceManager.getDefaultSharedPreferences(this)
//                .getString("key_display_name", "").equals(""));
//        if(PreferenceManager.getDefaultSharedPreferences(this)
//                .getString("key_display_name", "")
//                .equals("")) {
//            SavePreferences("key_display_name",
//                    "fwefwwef");
//        }
//        Log.d("sett", "UpdateUI2: " + PreferenceManager.getDefaultSharedPreferences(this)
//                .getString("key_display_name", ""));
        //display name
        TextView navUsername = ((NavigationView)findViewById(R.id.nav_view)).getHeaderView(0).findViewById(R.id.nav_name);
        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preference.getString("key_display_name", "");
        navUsername.setText(name);

    }
    // save preferences in the app
    private void SavePreferences(String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(key ,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
