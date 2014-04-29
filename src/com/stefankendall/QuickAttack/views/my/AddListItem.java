package com.stefankendall.QuickAttack.views.my;

import android.view.LayoutInflater;
import android.view.View;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

public class AddListItem implements CustomListItem {
    @Override
    public View fillView(View view, LayoutInflater inflater) {
        view = inflater.inflate(R.layout.add_list_item, null);
        return view;
    }
}
