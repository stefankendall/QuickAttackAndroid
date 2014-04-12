package com.stefankendall.QuickAttack.data;

import com.google.common.collect.Lists;
import junit.framework.Assert;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.Map;

public class TypeCalculatorTests extends TestCase {
    public void testReturnsTyepEffectivenessForTypes() {
        Map<String, BigDecimal> effectiveness = new TypeCalculator().effectivenessAgainst(Lists.newArrayList("bug", "grass"));
        Assert.assertEquals(effectiveness.keySet().size(), 18);
        Assert.assertEquals(effectiveness.get("flying"), new BigDecimal(4));
    }
}
