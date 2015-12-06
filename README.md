# Material-Tabhost
# Hình Demo
![screenshot from 2015-12-06 13 47 19](https://cloud.githubusercontent.com/assets/10550810/11612145/d6b7cb20-9c20-11e5-993d-ce6f46a36630.png)
#Layout
###main.xml
```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    tools:context="com.loc.progressdemo.Main2Activity">
    <include layout="@layout/app_bar"
        android:id="@+id/appbar" />

    <it.neokree.materialtabs.MaterialTabHost
        android:id="@+id/tabHost"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:layout_below="@+id/toolbar"
        app:accentColor="@color/accent"
        app:hasIcons="true"
        app:primaryColor="@color/primary" />

    <android.support.v4.view.ViewPager
        android:id="@+id/pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/tabHost" />

</LinearLayout>

```
#app_bar.xml
```XML 
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.Toolbar xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="@color/primary"
    app:popupTheme="@style/Theme.AppCompat.Light"
    app:theme="@style/Theme.AppCompat" />
```
###tablayout.xml
```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ListView
        android:id="@+id/listView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:clipToPadding="false"
        android:paddingBottom="10dp" />
</LinearLayout>

``` 
###Main.java
``` java 

package com.loc.progressdemo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.loc.progressdemo.frament.framenttabexample;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class Main2Activity extends AppCompatActivity implements MaterialTabListener {
    Toolbar appbar;
    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;
    private Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initActionbar();
        res = this.getResources();
        initTab();
    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }


    private void initActionbar() {
        appbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(appbar);
        setTitle("Demo by loc");
    }

    /*--*/
    private void initTab() {
        // insert all tabs from pagerAdapter data
        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(getIcon(i))
                            .setTabListener(this)
            );
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


    private class ViewPagerAdapter extends FragmentStatePagerAdapter {


        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new framenttabexample();
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "tab 1";
                case 1:
                    return "tab 2";
                case 2:
                    return "tab 3";
                case 4:
                    return "tab 4";
                default:
                    return null;
            }
        }
    }

    private Drawable getIcon(int position) {
        switch (position) {
            case 0:
                return res.getDrawable(R.drawable.ic_credit_card_white_36dp);
            case 1:
                return res.getDrawable(R.drawable.ic_credit_card_white_36dp);
            case 2:
                return res.getDrawable(R.drawable.ic_credit_card_white_36dp);
            case 3:
                return res.getDrawable(R.drawable.ic_credit_card_white_36dp);
        }
        return null;
    }
}


```
###frament.xml

```java
package com.loc.progressdemo.frament;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.loc.progressdemo.R;
import com.loc.progressdemo.adapter.AdapterUser;

import java.util.List;

/**
 * Created by loc on 24/11/2015.
 */
public class framenttabexample extends Fragment {
    View v;
    ListView lv;
    AdapterUser adapterUser;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.tab_layout1, container, false);
        lv = (ListView) v.findViewById(R.id.listView);
        adapterUser=new AdapterUser();
        lv.setAdapter(adapterUser);
        return v;
    }
}

```
