package com.stefankendall.QuickAttack.views.nav;

import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

public class NavListAdapter extends SimpleListAdapter {
    public NavListAdapter() {
        super();

        this.items.add(new NavListItem("All Pokemon", android.R.drawable.ic_menu_search));
        this.items.add(new NavListItem("My Pokemon", R.drawable.ic_15_tags2x));
        this.items.add(new NavListItem("Feedback", R.drawable.ic_09_chat_22x));
    }
}
