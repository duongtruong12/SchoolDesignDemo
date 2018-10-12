package com.example.truong.schooldesigndemo.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.truong.schooldesigndemo.Activity.HomeActivity;
import com.example.truong.schooldesigndemo.R;

public class ListHouseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context context;
    private static final String TAG = ListHouseAdapter.class.getSimpleName();


    public ListHouseAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_house, parent, false);
        return new ListHouseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int i) {
        ((ListHouseHolder) holder).llTotalView.setOnClickListener(this);
        ((ListHouseHolder) holder).icOverFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(((ListHouseHolder) holder).icOverFlow , getItemCount());
            }
        });
    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_total_view:
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
                break;
        }
    }

    private static class ListHouseHolder extends RecyclerView.ViewHolder {
        private LinearLayout llTotalView;
        private ImageView icOverFlow;

        private ListHouseHolder(View v) {
            super(v);
            llTotalView = v.findViewById(R.id.ll_total_view);
            icOverFlow = v.findViewById(R.id.img_more);
        }
    }

    private void showPopupMenu(final View view , final int id) {
        // inflate menu
        final PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_pick_time:
                        return true;
                    case R.id.action_info:
                        return true;
                    default:
                }
                return false;
            }
        });
        popup.show();
    }
}