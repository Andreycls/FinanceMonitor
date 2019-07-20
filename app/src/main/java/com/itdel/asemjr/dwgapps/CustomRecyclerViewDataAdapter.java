package com.itdel.asemjr.dwgapps;

/**
 * Created by asemJr on 7/17/2019.
 */
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CustomRecyclerViewDataAdapter extends Adapter {
    private List<CustomRecyclerViewItem> viewItemList;

    public CustomRecyclerViewDataAdapter(List<CustomRecyclerViewItem> viewItemList) {
        this.viewItemList = viewItemList;
    }


    public CustomRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View itemView = layoutInflater.inflate(R.layout.activity_custom_refresh_recycler_view_item, parent, false);

        // Create and return our customRecycler View Holder object.
        CustomRecyclerViewHolder ret = new CustomRecyclerViewHolder(itemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    public void onBindViewHolder(CustomRecyclerViewHolder holder, int position) {
        if(viewItemList!=null) {
            // Get car item dto in list.
            CustomRecyclerViewItem viewItem = viewItemList.get(position);

            if(viewItem != null) {
                // Set car item title.
                holder.getTextView().setText(viewItem.getText());
            }
        }
    }


    public int getItemCount() {
        int ret = 0;
        if(viewItemList!=null)
        {
            ret = viewItemList.size();
        }
        return ret;
    }
}
