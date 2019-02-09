package com.truemlgpro.getmonetized;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.*;
import android.view.*;
import android.support.v4.widget.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.view.*;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		setSupportActionBar(toolbar);
		final ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
		actionbar.setSubtitle(navigationView.getMenu().getItem(0).getTitle());
		actionbar.setElevation(20);
		
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
				}
			});
		
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		
		navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
			new NavigationView.OnNavigationItemSelectedListener() {
				
				@Override
				public boolean onNavigationItemSelected(MenuItem menuItem) {
					// set item as selected to persist highlight
					actionbar.setSubtitle(menuItem.getTitle());
					menuItem.setChecked(true);
					// close drawer when item is tapped
					mDrawerLayout.closeDrawers();
					// Add code here to update the UI based on the item selected
					// For example, swap UI fragments here
					return true;
				}
			});
    }
	
	
	public void showToast(View v) {
		Toast.makeText(this, "Android version: " + Build.VERSION.RELEASE, Toast.LENGTH_LONG).show(); 
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
	}
	
	
	//@Override 
	//public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.menu_toolbar, menu);
		//return true;
	//}
	
	@Override
	public void onBackPressed() {
		if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
			this.mDrawerLayout.closeDrawer(GravityCompat.START);
		} else {
			this.mDrawerLayout.openDrawer(GravityCompat.START);
			}
		}
}
