package com.stefankendall.QuickAttack.data;

import android.test.AndroidTestCase;
import junit.framework.Assert;

import java.util.List;

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
}
