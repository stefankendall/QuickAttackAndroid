package com.stefankendall.QuickAttack;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public abstract class SingleFragmentActivity extends Activity {
    public Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        this.fragment = getFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (this.fragment == null) {
            this.fragment = createFragment();
            getFragmentManager().beginTransaction().add(R.id.fragmentContainer, this.fragment).commit();
        }
    }

    protected abstract Fragment createFragment();
}