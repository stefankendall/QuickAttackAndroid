package com.stefankendall.QuickAttack.views;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.common.collect.ImmutableMap;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class PokemonTypeListItem implements CustomListItem {
    private final String type;
    private final BigDecimal effectiveness;
    private final ImmutableMap<String, Integer> colorsForType;

    public PokemonTypeListItem(String type, BigDecimal effectiveness) {
        this.type = type;
        this.effectiveness = effectiveness;

        this.colorsForType = ImmutableMap.<String, Integer>builder()
                .put("normal", Color.BLACK)
                .put("fighting", Color.rgb(175, 0, 0))
                .put("flying", Color.rgb(168, 144, 240))
                .put("poison", Color.rgb(160, 64, 160))
                .put("ground", Color.rgb(146, 125, 68))
                .put("rock", Color.rgb(184, 160, 56))
                .put("bug", Color.rgb(109, 120, 21))
                .put("ghost", Color.rgb(112, 88, 152))
                .put("steel", Color.rgb(156, 156, 156))
                .put("fire", Color.rgb(234, 0, 0))
                .put("water", Color.BLUE)
                .put("grass", Color.rgb(0, 132, 0))
                .put("electric", Color.rgb(186, 179, 0))
                .put("psychic", Color.rgb(248, 88, 136))
                .put("ice", Color.rgb(99, 141, 141))
                .put("dragon", Color.rgb(112, 56, 248))
                .put("dark", Color.rgb(73, 57, 47))
                .put("fairy", Color.rgb(238, 127, 195))
                .build();
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.type_effectiveness_list_item, null);
        }

        TextView typeText = (TextView) view.findViewById(R.id.type);
        TextView effectiveness = (TextView) view.findViewById(R.id.effectiveness);
        if (typeText != null) {
            typeText.setText(this.type);
            typeText.setTextColor(this.colorsForType.get(this.type));
            effectiveness.setText(new DecimalFormat("#0.##").format(this.effectiveness) + "x");
        }
        return view;
    }
}
