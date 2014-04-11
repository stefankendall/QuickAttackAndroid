package com.stefankendall.QuickAttack.data;

import android.test.AndroidTestCase;
import junit.framework.Assert;

import java.util.List;
import java.util.Map;

public class PokemonStoreTests extends AndroidTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        new DataLoader().load();
    }

    public void testReturnsInstances() {
        Assert.assertNotNull(PokemonStore.instance());
        Assert.assertEquals(PokemonStore.instance(), PokemonStore.instance());
    }

    public void testLoadsPokemonDataFromFile() {
        Assert.assertEquals(PokemonStore.instance().pokemonData.size(), 749);
        List<String> types = PokemonStore.instance().typesFor("Charizard");
        Assert.assertEquals(types.size(), 2);
        Assert.assertTrue(types.contains("fire"));
        Assert.assertTrue(types.contains("flying"));

        Assert.assertEquals(PokemonStore.instance().names().get(0), "Abomasnow");
    }

    public void testFiltersPokemonNames() {
        List<String> filteredList = PokemonStore.instance().namesMatching("Mime");
        Assert.assertEquals(filteredList.size(), 1);
        Assert.assertEquals(filteredList.get(0), "Mime Jr");

        Assert.assertEquals(PokemonStore.instance().namesMatching("").size(), 749);
    }

    public void testFiltersCaseInsensitive() {
        List<String> matching = PokemonStore.instance().namesMatching("abra");
        Assert.assertTrue(matching.contains("Abra"));
    }

    public void testFindsMegas() {
        List<String> charizardMegas = PokemonStore.instance().megasFor("Charizard");
        Assert.assertEquals(charizardMegas.size(), 2);
        Assert.assertTrue(charizardMegas.contains("Mega Charizard X"));

        List<String> bidoofMegas = PokemonStore.instance().megasFor("Bidoof");
        Assert.assertTrue(bidoofMegas.isEmpty());
    }

    public void testFindsStats() {
        Map<String, Double> stats = PokemonStore.instance().statsFor("Charizard");
        Double hp = stats.get("hp");
        Assert.assertEquals(hp.intValue(), 78);
    }
}
