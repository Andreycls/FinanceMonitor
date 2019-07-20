package com.itdel.asemjr.dwgapps;

/**
 * Created by asemJr on 7/17/2019.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
public class CustomRecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView textView = null;

    public CustomRecyclerViewHolder(View itemView) {
        super(itemView);

        if(itemView != null)
        {
            textView = (TextView)itemView.findViewById(R.id.custom_refresh_recycler_view_text_view);
        }
    }

    public TextView getTextView() {
        return textView;
    }
}
