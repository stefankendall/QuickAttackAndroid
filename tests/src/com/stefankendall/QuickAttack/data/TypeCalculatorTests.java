package com.stefankendall.QuickAttack.data;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TypeCalculatorTests extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
        new DataLoader().load();
    }

    public void testReturnsTyepEffectivenessForTypes() {
        Map<String, BigDecimal> effectiveness = new TypeCalculator().effectivenessAgainst(Lists.newArrayList("bug", "grass"));
        Assert.assertEquals(effectiveness.keySet().size(), 18);
        Assert.assertEquals(effectiveness.get("flying"), new BigDecimal(4));
    }

    public void testSuperEffectiveTypes() {
        List<String> types = new TypeCalculator().superEffectiveTypes(PokemonStore.instance().typesFor("Scizor"));
        Assert.assertEquals(types.size(), 1);
        Assert.assertEquals(types.get(0), "fire");
    }

    public void testNotEffectiveTypes() {
        List<String> types = new TypeCalculator().notEffectiveTypes(PokemonStore.instance().typesFor("Scizor"));

        List<String> expected = Lists.newArrayList(
                "bug",
                "dragon",
                "fairy",
                "grass",
                "ice",
                "normal",
                "psychic",
                "steel"
        );

        Assert.assertEquals(expected.size(), types.size());
        for (String expect : expected) {
            Assert.assertTrue(types.contains(expect));
        }
    }

    public void testImmunteTypes() {
        List<String> types = new TypeCalculator().immuneTypes(PokemonStore.instance().typesFor("Scizor"));
        Assert.assertEquals(types.size(), 1);
        Assert.assertEquals(types.get(0), "poison");
    }
}
