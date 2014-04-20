package com.stefankendall.QuickAttack.views.type;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.stefankendall.QuickAttack.R;
import com.stefankendall.QuickAttack.views.lists.CustomListItem;

import java.text.DecimalFormat;
import java.util.List;

public class MegasListItem implements CustomListItem {
    private final List<String> megas;
    private final MegaDelegate megaDelegate;

    public MegasListItem(List<String> megas, MegaDelegate megaDelegate) {
        this.megas = megas;
        this.megaDelegate = megaDelegate;
    }

    @Override
    public View fillView(View view, LayoutInflater inflater) {
        if (view == null) {
            view = inflater.inflate(R.layout.megas_list_item, null);
        }

        final Button mega1 = (Button) view.findViewById(R.id.mega1);
        Button mega2 = (Button) view.findViewById(R.id.mega2);
        if (mega1 != null && mega2 != null) {
            if (this.megas.size() == 1) {
                mega1.setText("Mega");
                mega2.setVisibility(View.INVISIBLE);
            }

            View.OnClickListener megaTapped = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view == mega1) {
                        megaDelegate.switchTo(megas.get(0));
                    } else {
                        megaDelegate.switchTo(megas.get(1));
                    }
                }
            };

            mega1.setOnClickListener(megaTapped);
            mega2.setOnClickListener(megaTapped);
        }
        return view;
    }
}
