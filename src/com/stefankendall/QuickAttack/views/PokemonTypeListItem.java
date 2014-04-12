package com.stefankendall.QuickAttack.views;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.math.BigDecimal;

public class PokemonTypeListItem implements CustomListItem {
    private final String type;
    private final BigDecimal effectiveness;

    public PokemonTypeListItem(String type, BigDecimal effectiveness) {
        this.type = type;
        this.effectiveness = effectiveness;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.type_effectiveness_list_item, null);
        }

        TextView type = (TextView) view.findViewById(R.id.type);
        TextView effectiveness = (TextView) view.findViewById(R.id.effectiveness);
        if (type != null) {
            type.setText(this.type);
            effectiveness.setText(this.effectiveness.toString() + "x");
        }
        return view;
    }
}
