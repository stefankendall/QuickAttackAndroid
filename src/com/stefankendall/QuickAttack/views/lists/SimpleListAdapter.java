package com.stefankendall.QuickAttack.views.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.Lists;
import com.stefankendall.QuickAttack.App;

import java.util.List;

public class SimpleListAdapter extends BaseAdapter {
    protected List<CustomListItem> items;

    public SimpleListAdapter() {
        this.items = Lists.newArrayList();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        CustomListItem item = items.get(position);
        return item.fillView(convertView, LayoutInflater.from(App.getContext()));
    }
}
