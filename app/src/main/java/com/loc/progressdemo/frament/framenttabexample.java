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
