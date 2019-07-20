package com.itdel.asemjr.dwgapps;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by asemJr on 2/2/2018.
 */

public class CustomRecyclerViewScrollActivity extends AppCompatActivity {private static final String LOG_TAG = CustomRecyclerViewScrollActivity.class.getSimpleName();

    private RecyclerView recyclerView = null;

    private List<CustomRecyclerViewItem> itemList = null;

    private CustomRecyclerViewDataAdapter customRecyclerViewDataAdapter = null;

    private ProgressBar progressBar = null;

    // This handler is used to update activity UI components/
    private Handler uiHandler = null;

    private int MESSAGE_UPDATE_RECYCLER_VIEW = 1;

    private String MESSAGE_KEY_NEW_ITEM_INDEX = "MESSAGE_KEY_NEW_ITEM_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_refresh_recycler_view);

        setTitle("dev2qa.com - Android RecyclerView Horizontal Scroll Example.");

        initControls();

        // Create the recyclerview.
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.custom_refresh_recycler_view);
        // Create the grid layout manager with 2 columns.
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        // Set layout manager.
        recyclerView.setLayoutManager(layoutManager);

        // Create car recycler view data adapter with car item list.
        customRecyclerViewDataAdapter = new CustomRecyclerViewDataAdapter(itemList);
        // Set data adapter.
        recyclerView.setAdapter(customRecyclerViewDataAdapter);

        // Scroll RecyclerView a little to make later scroll take effect.
        recyclerView.scrollToPosition(1);
    }

    private void initControls()
    {
        if(recyclerView == null)
        {
            recyclerView = (RecyclerView)findViewById(R.id.custom_refresh_recycler_view);

            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                    int firstCompleteVisibleItemPosition = -1;
                    int lastCompleteVisibleItemPosition = -1;
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();

                    if(layoutManager instanceof GridLayoutManager)
                    {
                        GridLayoutManager gridLayoutManager = (GridLayoutManager)layoutManager;
                        firstCompleteVisibleItemPosition = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                        lastCompleteVisibleItemPosition = gridLayoutManager.findLastCompletelyVisibleItemPosition();
                    }else if(layoutManager instanceof  LinearLayoutManager)
                    {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager)layoutManager;
                        firstCompleteVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                        lastCompleteVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                    }

                    String message = "";

                    // Means scroll at beginning ( top to bottom or left to right).
                    if(firstCompleteVisibleItemPosition == 0)
                    {
                        // dy < 0 means scroll to bottom, dx < 0 means scroll to right at beginning.
                        if(dy < 0 || dx < 0)
                        {
                            // Means scroll to bottom.
                            if(dy < 0)
                            {
                                loadData(true);
                            }

                            // Means scroll to right.
                            if(dx < 0 )
                            {
                                loadData(true);
                            }
                        }
                    }
                    // Means scroll at ending ( bottom to top or right to left )
                    else if(lastCompleteVisibleItemPosition == (totalItemCount - 1))
                    {
                        // dy > 0 means scroll to up, dx > 0 means scroll to left at ending.
                        if(dy > 0 || dx > 0)
                        {
                            // Scroll to top
                            if(dy > 0)
                            {
                                loadData(false);
                            }

                            // Scroll to left
                            if(dx > 0 )
                            {
                                loadData(false);
                            }
                        }
                    }

                    if(message.length() > 0) {
                        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        if(uiHandler == null)
        {
            uiHandler = new Handler()
            {
                @Override
                public void handleMessage(Message msg) {
                    // If the message want to refresh list view.
                    if(msg.what == MESSAGE_UPDATE_RECYCLER_VIEW)
                    {
                        // Refresh list view after add item data.
                        customRecyclerViewDataAdapter.notifyDataSetChanged();
                    }

                    Bundle bundle = msg.getData();
                    int newItemIndex = bundle.getInt(MESSAGE_KEY_NEW_ITEM_INDEX);
                    recyclerView.scrollToPosition(newItemIndex - 1);

                    // Stop showing the progress bar.
                    progressBar.setVisibility(View.GONE);
                }
            };
        }

        if(itemList == null)
        {
            itemList = new ArrayList<CustomRecyclerViewItem>();
            for(int i=0;i<6;i++)
            {
                CustomRecyclerViewItem item = new CustomRecyclerViewItem();
                item.setText("Card " + (i + 1));
                itemList.add(item);
            }
        }

        if(progressBar == null)
        {
            progressBar = (ProgressBar)findViewById(R.id.custom_refresh_recycler_view_progressbar);
        }
    }


    private void loadData(final boolean insertDataAtBeginning)
    {

        // Show progressbar first.
        progressBar.setVisibility(View.VISIBLE);

        Thread workerThread = new Thread()
        {
            @Override
            public void run() {
                try {

                    Thread.sleep(3000);

                    int currItemListSize = itemList.size();

                    int newItemIndex = 0;

                    // Only add one RecyclerView item.
                    for (int i = currItemListSize; i < currItemListSize + 1; i++){

                        CustomRecyclerViewItem newViewItem = new CustomRecyclerViewItem();
                        newViewItem.setText("Card " + (i + 1));

                        if (insertDataAtBeginning) {
                            itemList.add(i - currItemListSize, newViewItem);
                            newItemIndex = 0;
                        }else
                        {
                            itemList.add(newViewItem);
                            newItemIndex = itemList.size() - 1;
                        }

                        Message message = new Message();
                        message.what = MESSAGE_UPDATE_RECYCLER_VIEW;
                        Bundle bundle = new Bundle();
                        bundle.putInt(MESSAGE_KEY_NEW_ITEM_INDEX, newItemIndex);
                        message.setData(bundle);
                        uiHandler.sendMessage(message);
                    }
                }catch(InterruptedException ex)
                {
                    Log.e(LOG_TAG, ex.getMessage(), ex);
                }
            }
        };

        workerThread.start();
    }
}