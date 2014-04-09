package com.stefankendall.QuickAttack.data;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class PokemonStore {
    PokemonStore instance() {
        return null;
    }

    void load() {
    }

    List<String> names() {
        return Lists.newArrayList();
    }

    Map<String, Map> pokemonData;

    List<String> namesMatching(String name) {
        return null;
    }

    Map<String, Integer> statsFor(String name) {
        return null;
    }

    List<String> megasFor(String pokemon) {
        return null;
    }
}
