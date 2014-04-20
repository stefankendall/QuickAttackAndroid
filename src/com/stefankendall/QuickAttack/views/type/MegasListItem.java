package com.stefankendall.QuickAttack.views.type;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.text.DecimalFormat;
import java.util.List;

public class MegasListItem implements CustomListItem {
    private final List<String> megas;

    public MegasListItem(List<String> megas) {
        this.megas = megas;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.megas_list_item, null);
        }

        TextView mega1 = (TextView) view.findViewById(R.id.mega1);
        TextView mega2 = (TextView) view.findViewById(R.id.mega2);
        if (mega1 != null && mega2 != null) {
            if (this.megas.size() == 1) {
                mega1.setText("Mega");
                mega2.setVisibility(View.INVISIBLE);
            }
        }
        return view;
    }
}
