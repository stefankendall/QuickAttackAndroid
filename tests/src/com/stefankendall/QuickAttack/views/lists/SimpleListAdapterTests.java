package com.stefankendall.QuickAttack.views.lists;

import android.test.AndroidTestCase;
import junit.framework.Assert;

public class SimpleListAdapterTests extends AndroidTestCase {
    public void testReturnsViewTypeCount(){
        SimpleListAdapter adapter = new SimpleListAdapter();
        adapter.items.add(new SimpleListItem(""));
        adapter.items.add(new SimpleListItem(""));
        Assert.assertEquals(adapter.getViewTypeCount(), 1);

        adapter.items.add(new HeaderListItem(""));
        adapter.items.add(new SimpleListItem(""));
        Assert.assertEquals(adapter.getViewTypeCount(), 2);
    }

    public void testReturnsViewTypeIdForPosition(){
        SimpleListAdapter adapter = new SimpleListAdapter();
        adapter.items.add(new HeaderListItem(""));
        adapter.items.add(new SimpleListItem(""));
        adapter.items.add(new SimpleListItem(""));
        adapter.items.add(new HeaderListItem(""));
        adapter.items.add(new SimpleListItem(""));
        Assert.assertEquals(adapter.getItemViewType(0), 0);
        Assert.assertEquals(adapter.getItemViewType(1), 1);
        Assert.assertEquals(adapter.getItemViewType(2), 1);
        Assert.assertEquals(adapter.getItemViewType(3), 0);
        Assert.assertEquals(adapter.getItemViewType(4), 1);

    }
}
