package app.pomis.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by romanismagilov on 20.10.15.
 */
public class CatAdapter extends ArrayAdapter {
    ArrayList<Cat> cats;
    Activity activity;
    int mResource;
    public CatAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        cats = (ArrayList)objects;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(mResource, null);
        ((TextView)view.findViewById(R.id.my_title))
                .setText(cats.get(position).getName());
        ((TextView)view.findViewById(R.id.my_text))
                .setText(cats.get(position).getDescription());

        return view;
    }
}
