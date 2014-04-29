package com.stefankendall.QuickAttack.views.my;

import android.app.Fragment;
import android.os.Bundle;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class MyPokemonListActivity extends SingleFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupNavigation();
    }

    @Override
    protected Fragment createFragment() {
        return new MyPokemonListFragment();
    }
}
