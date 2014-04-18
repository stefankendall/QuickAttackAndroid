package com.stefankendall.QuickAttack.views.stats;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

public class PokemonStatsCompareHeader implements CustomListItem {

    private final String pokemon1;
    private final String pokemon2;

    public PokemonStatsCompareHeader(String pokemon1, String pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.stats_list_compare_header, null);
        }

        TextView pokemon1Text = (TextView) view.findViewById(R.id.pokemon1);
        TextView pokemon2Text = (TextView) view.findViewById(R.id.pokemon2);
        if (pokemon1Text != null) {
            pokemon1Text.setText(this.pokemon1);
            pokemon2Text.setText(this.pokemon2);
        }
        return view;
    }
}
