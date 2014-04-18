package com.stefankendall.QuickAttack.views.stats;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

public class PokemonCompareStatsListItem implements CustomListItem {
    private final String type;
    private final int value1;
    private final int value2;

    public PokemonCompareStatsListItem(String type, int value1, int value2) {
        this.type = type;
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.stats_list_compare_item, null);
        }

        TextView statType = (TextView) view.findViewById(R.id.stat_type);
        TextView statValue1 = (TextView) view.findViewById(R.id.stat_value_1);
        TextView statValue2 = (TextView) view.findViewById(R.id.stat_value_2);

        if (statType != null) {
            statType.setText(this.type);
            statValue1.setText(this.value1 + "");
            statValue2.setText(this.value2 + "");
        }

        return view;
    }
}
