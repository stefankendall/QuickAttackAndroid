package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class PokemonCompareActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new PokemonListCompareFragment();
    }
}
