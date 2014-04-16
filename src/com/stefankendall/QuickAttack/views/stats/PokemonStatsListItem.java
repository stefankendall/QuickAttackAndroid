package com.stefankendall.QuickAttack.views.stats;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

public class PokemonStatsListItem implements CustomListItem {
    private final String type;
    private final int value;

    public PokemonStatsListItem(String type, int value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.stats_list_item, null);
        }

        TextView statType = (TextView) view.findViewById(R.id.stat_type);
        TextView statValue = (TextView) view.findViewById(R.id.stat_value);

        if (statType != null) {
            statType.setText(this.type);
            statValue.setText(this.value + "");
        }

        return view;
    }
}
