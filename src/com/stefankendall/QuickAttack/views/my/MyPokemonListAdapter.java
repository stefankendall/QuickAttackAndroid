package com.stefankendall.QuickAttack.views.my;

import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

public class MyPokemonListAdapter extends SimpleListAdapter {
    public MyPokemonListAdapter() {
        super();

        this.items.add(new AddListItem());
    }
}
