package com.stefankendall.QuickAttack.views;

import android.app.Fragment;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.SingleFragmentActivity;
import com.stefankendall.QuickAttack.data.MyPokemonStore;

public class PokemonListActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Crashlytics.start(this);
        MyPokemonStore.instance().load();
        setupNavigation();
    }

    @Override
    protected Fragment createFragment() {
        return new PokemonListFragment();
    }
}
