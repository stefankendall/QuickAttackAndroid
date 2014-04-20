package com.stefankendall.QuickAttack.views.type;

import com.google.common.collect.Ordering;
import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.data.TypeCalculator;
import com.stefankendall.QuickAttack.views.lists.HeaderListItem;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class PokemonTypeListAdapter extends SimpleListAdapter {
    public PokemonTypeListAdapter(String pokemon, MegaDelegate megaDelegate) {
        super();

        List<String> pokemonTypes = PokemonStore.instance().typesFor(pokemon);
        List<String> superEffectiveTypes = new TypeCalculator().superEffectiveTypes(pokemonTypes);
        List<String> immuneTypes = new TypeCalculator().immuneTypes(pokemonTypes);
        List<String> notEffectiveTypes = new TypeCalculator().notEffectiveTypes(pokemonTypes);
        Map<String, BigDecimal> effectiveness = new TypeCalculator().effectivenessAgainst(pokemonTypes);

        this.items.add(new TypeInfoListItem(pokemonTypes));
        List<String> megas = PokemonStore.instance().megasFor(pokemon);
        if(megas.size() > 0){
            this.items.add(new MegasListItem(megas, megaDelegate));
        }

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
}
