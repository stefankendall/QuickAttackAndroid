package com.stefankendall.QuickAttack.views.my;

import com.stefankendall.QuickAttack.data.MyPokemonStore;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;
import com.stefankendall.QuickAttack.views.lists.SimpleListItem;

public class MyPokemonDeletingListAdapter extends SimpleListAdapter {
    public MyPokemonDeletingListAdapter() {
        super();

        for (String pokemon : MyPokemonStore.instance().getPokemon()) {
            this.items.add(new SimpleListItem(pokemon));
        }
    }
}
