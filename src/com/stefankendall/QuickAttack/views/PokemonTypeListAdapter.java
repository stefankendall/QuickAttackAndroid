package com.stefankendall.QuickAttack.views;

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
import com.stefankendall.QuickAttack.views.lists.SimpleListItem;

import java.util.List;

public class PokemonTypeListAdapter extends BaseAdapter {
    private List<CustomListItem> items;

    public PokemonTypeListAdapter(String pokemon) {
        this.items = Lists.newArrayList();

        List<String> superEffectiveTypes = new TypeCalculator().superEffectiveTypes(PokemonStore.instance().typesFor(pokemon));
        List<String> immuneTypes = new TypeCalculator().immuneTypes(PokemonStore.instance().typesFor(pokemon));
        List<String> notEffectiveTypes = new TypeCalculator().notEffectiveTypes(PokemonStore.instance().typesFor(pokemon));

        addTypes(superEffectiveTypes, "Super Effective");
        addTypes(immuneTypes, "Immune");
        addTypes(notEffectiveTypes, "Not Effective");
    }

    private void addTypes(List<String> types, String header) {
        if (types.size() > 0) {
            this.items.add(new HeaderListItem(header));
            for (String type : Ordering.natural().sortedCopy(types)) {
                this.items.add(new SimpleListItem(type));
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
