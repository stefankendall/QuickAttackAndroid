package com.stefankendall.QuickAttack.views.my;

import android.app.Fragment;
import android.os.Bundle;
import com.stefankendall.QuickAttack.SingleFragmentActivity;

public class MyPokemonSelectListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new MyPokemonSelectListFragment();
    }
}
