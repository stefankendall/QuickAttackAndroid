package com.stefankendall.QuickAttack.views.stats;

import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

import java.util.Map;

public class PokemonStatsCompareListAdapter extends SimpleListAdapter {
    public PokemonStatsCompareListAdapter(String pokemon1, String pokemon2) {
        super();

        Map<String, Double> pokemon1Stats = PokemonStore.instance().statsFor(pokemon1);
        Map<String, Double> pokemon2Stats = PokemonStore.instance().statsFor(pokemon2);
        items.add(new PokemonCompareStatsListItem("HP", pokemon1Stats.get("hp").intValue(), pokemon2Stats.get("hp").intValue()));
        items.add(new PokemonCompareStatsListItem("Attack", pokemon1Stats.get("attack").intValue(), pokemon2Stats.get("attack").intValue()));
        items.add(new PokemonCompareStatsListItem("Defense", pokemon1Stats.get("defense").intValue(), pokemon2Stats.get("defense").intValue()));
        items.add(new PokemonCompareStatsListItem("Sp. Attack", pokemon1Stats.get("special_attack").intValue(), pokemon2Stats.get("special_attack").intValue()));
        items.add(new PokemonCompareStatsListItem("Sp. Defense", pokemon1Stats.get("special_defense").intValue(), pokemon2Stats.get("special_defense").intValue()));
        items.add(new PokemonCompareStatsListItem("Speed", pokemon1Stats.get("speed").intValue(), pokemon2Stats.get("speed").intValue()));
    }
}
