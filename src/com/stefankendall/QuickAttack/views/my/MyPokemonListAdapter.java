package com.stefankendall.QuickAttack.views.my;

import com.stefankendall.QuickAttack.data.MyPokemonStore;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;
import com.stefankendall.QuickAttack.views.lists.SimpleListItem;

public class MyPokemonListAdapter extends SimpleListAdapter {
    public MyPokemonListAdapter() {
        this(true);
    }

    public MyPokemonListAdapter(boolean hasAdd) {
        super();

        for (String pokemon : MyPokemonStore.instance().getPokemon()) {
            this.items.add(new SimpleListItem(pokemon));
        }

        if (hasAdd) {
            this.items.add(new AddListItem());
        }
    }
}
