package momunity.com.platoun.activities;


import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import momunity.com.platoun.R;
import momunity.com.platoun.fragments.FilterMarketplaceFragment;
import momunity.com.platoun.fragments.HomeFragment;
import momunity.com.platoun.fragments.MarketplaceFragment;
import momunity.com.platoun.fragments.NotificationFragment;
import momunity.com.platoun.fragments.ProfileFragment;
import momunity.com.platoun.fragments.TchatFragment;
import momunity.com.platoun.utils.Utils;

public class MainActivity extends AppCompatActivity  {

    Utils utils = new Utils();
    BottomNavigationView navigation;


    Toolbar toolbar;
    DrawerLayout drawerLayout;

    String TAG = "MainActivity";
//    //1 - FOR DESIGN
//    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.action_home:
//                    utils.showFragment(new HomeFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//                    return true;
//                case R.id.action_marketplace:
//                    utils.showFragment(new MarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//                    return true;
//                case R.id.action_profile:
//                    utils.showFragment(new ProfileFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//                    return true;
//                case R.id.action_tchat:
//                    utils.showFragment(new TchatFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//                    return true;
//                case R.id.action_notification:
//                    utils.showFragment(new NotificationFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//                    return true;
//            }
//            return false;
//        }
//
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.activity_main_bottom_navigation);
        navigation.setSelectedItemId(R.id.action_marketplace);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        utils.showFragment(new HomeFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        return true;
                    case R.id.action_marketplace:
                        utils.showFragment(new MarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        return true;
                    case R.id.action_profile:
                        utils.showFragment(new ProfileFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        return true;
                    case R.id.action_tchat:
                        utils.showFragment(new TchatFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        return true;
                    case R.id.action_notification:
                        utils.showFragment(new NotificationFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        return true;
                }
                return false;
            }
        });

        utils.showFragment(new MarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//-----------------
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // 4 - Handle Navigation Item Click
                int id = menuItem.getItemId();

                switch (id){
                    case R.id.menu_friends :
                        break;
                    case R.id.menu_group:
                        break;
                    case R.id.menu_profil:
                        break;
                    case R.id.menu_favorite:
                        break;
                    default:
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        // 5 - Handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    public void hideNavigationBar() {
        navigation.setVisibility(View.GONE);
    }

    public void showNavigationBar() {
        navigation.setVisibility(View.VISIBLE);
    }

    public void initToolBar(String title, int drawableLogo, int drawableIcon,boolean isBackButton) {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView ivLogo = findViewById(R.id.ivLogo);
        ImageButton ivIcon = findViewById(R.id.ivIcon);
        ImageButton ivIconLeft = findViewById(R.id.ivIconLeft);
        ImageButton ivIconRight = findViewById(R.id.ivIconRight);
        TextView tvToolbar = findViewById(R.id.tvToolbar);



        //With title
        if (drawableIcon == 0 && drawableLogo == 0 && isBackButton) {
            Log.d(TAG, "initToolBar: title");
            tvToolbar.setText(title);

            ivLogo.setVisibility(View.GONE);
            ivIcon.setVisibility(View.GONE);
            ivIconLeft.setVisibility(View.GONE);
            ivIconRight.setVisibility(View.GONE);
            tvToolbar.setVisibility(View.VISIBLE);
            if(isBackButton){
                toolbar.setNavigationIcon(R.drawable.icon_left_arrow);

                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        utils.showFragment(new MarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                        MarketplaceFragment.isFiltred = false;

                        showNavigationBar();

                    }
                });
            }


        }
        //with logo
        else if (title == null && drawableIcon == 0) {

            Log.d(TAG, "initToolBar: logooo");
            ivLogo.setImageResource(drawableLogo);
            ivIconRight.setImageResource(R.drawable.icon_filter);
            ivIconLeft.setImageResource(R.drawable.icon_drawer);

            ivLogo.setVisibility(View.VISIBLE);
            ivIconRight.setVisibility(View.VISIBLE);
            ivIconLeft.setVisibility(View.VISIBLE);

            tvToolbar.setVisibility(View.GONE);
            ivIcon.setVisibility(View.GONE);
            toolbar.setNavigationIcon(null);

            ivIconLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(MainActivity.this, "clicking the drawer!", Toast.LENGTH_SHORT).show();
//                    drawerLayout.openDrawer(drawerLayout);

                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

            ivIconRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MarketplaceFragment.isFiltred = true;
                    FilterMarketplaceFragment.categoriesChecked.clear();
                    hideNavigationBar();

                    utils.showFragment(new FilterMarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
                }
            });


        }
        //with title & icon
        else {
            Log.d(TAG, "initToolBar: title & icon");
            tvToolbar.setText(title);
            ivIcon.setImageResource(drawableIcon);

            ivLogo.setVisibility(View.GONE);
            ivIconRight.setVisibility(View.GONE);
            ivIcon.setVisibility(View.VISIBLE);
            tvToolbar.setVisibility(View.VISIBLE);
        }

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.filter, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_filter) {
//            MarketplaceFragment.isFiltred = true;
//            FilterMarketplaceFragment.categoriesChecked.clear();
//
//            hideNavigationBar();
//
//            utils.showFragment(new FilterMarketplaceFragment(), R.id.activity_main_frame_layout, getSupportFragmentManager());
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }






}
