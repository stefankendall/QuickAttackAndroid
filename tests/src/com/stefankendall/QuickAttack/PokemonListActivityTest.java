package com.stefankendall.QuickAttack;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.stefankendall.QuickAttack.PokemonListActivityTest \
 * com.stefankendall.QuickAttack.tests/android.test.InstrumentationTestRunner
 */
public class PokemonListActivityTest extends ActivityInstrumentationTestCase2<PokemonListActivity> {

    public PokemonListActivityTest() {
        super("com.stefankendall.QuickAttack", PokemonListActivity.class);
    }

}
