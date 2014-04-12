package com.stefankendall.QuickAttack.views;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.stefankendall.QuickAttack.data.PokemonStore;

public class PokemonListAdapter extends ArrayAdapter<String> {
    private final Activity activity;

    public PokemonListAdapter(Activity activity, String filter) {
        super(activity, android.R.layout.simple_list_item_1, PokemonStore.instance().namesMatching(filter));
        this.activity = activity;
    }
}
