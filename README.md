# Material-Tabhost
# Hình Demo
![screenshot from 2015-12-06 13 47 19](https://cloud.githubusercontent.com/assets/10550810/11612145/d6b7cb20-9c20-11e5-993d-ce6f46a36630.png)
#Layout
``` 
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
