package com.stefankendall.QuickAttack.views.stats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.Lists;
import com.stefankendall.QuickAttack.App;
import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.util.List;
import java.util.Map;

public class PokemonStatsListAdapter extends BaseAdapter {
    private List<CustomListItem> items;
    public PokemonStatsListAdapter(String pokemon) {
        items = Lists.newArrayList();

        Map<String, Double> stats = PokemonStore.instance().statsFor(pokemon);
        items.add(new PokemonStatsListItem("HP", stats.get("hp").intValue()));
        items.add(new PokemonStatsListItem("Attack", stats.get("attack").intValue()));
        items.add(new PokemonStatsListItem("Defense", stats.get("defense").intValue()));
        items.add(new PokemonStatsListItem("Sp. Attack", stats.get("special_attack").intValue()));
        items.add(new PokemonStatsListItem("Sp. Defense", stats.get("special_defense").intValue()));
        items.add(new PokemonStatsListItem("Speed", stats.get("speed").intValue()));
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        CustomListItem item = items.get(position);
        return item.fillView(convertView, LayoutInflater.from(App.getContext()));
    }
}
