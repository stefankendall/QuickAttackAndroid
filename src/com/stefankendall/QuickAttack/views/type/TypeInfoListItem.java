package com.stefankendall.QuickAttack.views.type;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.common.base.Joiner;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.util.List;

public class TypeInfoListItem implements CustomListItem {
    private final List<String> pokemonTypes;

    public TypeInfoListItem(List<String> pokemonTypes) {
        this.pokemonTypes = pokemonTypes;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.type_info_list_item, null);
        }

        TextView typeText = (TextView) view.findViewById(R.id.type_info);
        if (typeText != null) {
            typeText.setText(Joiner.on(" | ").join(this.pokemonTypes));
        }
        return view;
    }
}
