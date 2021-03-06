package com.stefankendall.QuickAttack.views.stats;

import com.stefankendall.QuickAttack.data.PokemonStore;
import com.stefankendall.QuickAttack.views.lists.SimpleListAdapter;

import java.util.Map;

public class PokemonStatsListAdapter extends SimpleListAdapter {
    public PokemonStatsListAdapter(String pokemon) {
        super();

        Map<String, Double> stats = PokemonStore.instance().statsFor(pokemon);
        items.add(new PokemonStatsListItem("HP", stats.get("hp").intValue()));
        items.add(new PokemonStatsListItem("Attack", stats.get("attack").intValue()));
        items.add(new PokemonStatsListItem("Defense", stats.get("defense").intValue()));
        items.add(new PokemonStatsListItem("Sp. Attack", stats.get("special_attack").intValue()));
        items.add(new PokemonStatsListItem("Sp. Defense", stats.get("special_defense").intValue()));
        items.add(new PokemonStatsListItem("Speed", stats.get("speed").intValue()));
    }
}
