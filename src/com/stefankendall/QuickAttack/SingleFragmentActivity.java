package com.stefankendall.QuickAttack;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Fragment fragment = getFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = createFragment();
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();
}
