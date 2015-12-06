package com.loc.progressdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.loc.progressdemo.Object.User;
import com.loc.progressdemo.R;
import com.loc.progressdemo.Until.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by loc on 24/11/2015.
 */
public class AdapterUser extends BaseAdapter {
    ArrayList<String> list;

    public AdapterUser() {
        list = new ArrayList<>();
        String title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);
        title = "Pizza";
        list.add(title);


    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View v;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        ViewHole h = new ViewHole();
        h.txtTitle = (TextView) v.findViewById(R.id.txtTitle);
        h.img = (ImageView) v.findViewById(R.id.imageView);
//        h.img.setImageBitmap().
        h.txtTitle.setText(list.get(position));
        Picasso.with(parent.getContext()).load(R.drawable.img).placeholder(parent.getContext().getResources().getDrawable(R.drawable.img)).transform(new CircleTransform()).into(h.img);
        return v;
    }

    class ViewHole {
        TextView txtTitle;
        ImageView img;


    }
}
