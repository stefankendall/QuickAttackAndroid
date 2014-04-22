package com.stefankendall.QuickAttack.views.nav;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

public class NavListItem implements CustomListItem {
    private final String text;
    private int drawable;

    public NavListItem(String text, int drawable) {
        this.text = text;
        this.drawable = drawable;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.nav_menu_list_item, null);
        }

        TextView textView = (TextView) view.findViewById(R.id.menu_item_text);

        if (textView != null) {
            textView.setText(this.text);
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
        }

        return view;
    }
}
