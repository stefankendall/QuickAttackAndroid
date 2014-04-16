package com.stefankendall.QuickAttack.views.type;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.stefankendall.QuickAttack.App;
import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.data.TypeCalculator;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;
import com.stefankendall.QuickAttack.views.lists.HeaderListItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PokemonTypeListAdapter extends BaseAdapter {
    private List<CustomListItem> items;

    public PokemonTypeListAdapter(String pokemon) {
        this.items = Lists.newArrayList();

        List<String> pokemonTypes = PokemonStore.instance().typesFor(pokemon);
        List<String> superEffectiveTypes = new TypeCalculator().superEffectiveTypes(pokemonTypes);
        List<String> immuneTypes = new TypeCalculator().immuneTypes(pokemonTypes);
        List<String> notEffectiveTypes = new TypeCalculator().notEffectiveTypes(pokemonTypes);
        Map<String, BigDecimal> effectiveness = new TypeCalculator().effectivenessAgainst(pokemonTypes);

        addTypes(superEffectiveTypes, "Super Effective", effectiveness);
        addTypes(immuneTypes, "Immune", effectiveness);
        addTypes(notEffectiveTypes, "Not Effective", effectiveness);
    }

    private void addTypes(List<String> types, String header, Map<String, BigDecimal> effectiveness) {
        if (types.size() > 0) {
            this.items.add(new HeaderListItem(header));
            for (String type : Ordering.natural().sortedCopy(types)) {
                this.items.add(new PokemonTypeListItem(type, effectiveness.get(type)));
            }
        }
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
