package com.stefankendall.QuickAttack.views.nav;

import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

public class NavListAdapter extends SimpleListAdapter {
    public NavListAdapter() {
        super();

        this.items.add(new NavListItem("All Pokemon", android.R.drawable.ic_menu_search));
        this.items.add(new NavListItem("My Pokemon", android.R.drawable.ic_menu_search));
        this.items.add(new NavListItem("Feedback",  android.R.drawable.ic_menu_search));
    }
}
