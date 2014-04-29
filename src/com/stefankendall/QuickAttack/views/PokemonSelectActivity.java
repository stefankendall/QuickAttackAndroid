package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class PokemonSelectActivity extends SingleFragmentActivity {
    public static final String EXTRA_TITLE = "extra_title";

    @Override
    protected Fragment createFragment() {
        return new PokemonListCompareFragment();
    }
}
