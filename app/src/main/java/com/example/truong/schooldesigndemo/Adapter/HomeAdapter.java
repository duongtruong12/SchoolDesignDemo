package com.example.truong.schooldesigndemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truong.schooldesigndemo.CustomView.GridSpacingItemDecoration;
import com.example.truong.schooldesigndemo.Object.HouseDTO;
import com.example.truong.schooldesigndemo.Object.RoomDTO;
import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.Utils;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = HomeAdapter.class.getSimpleName();
    private Context context;
    private List<Object> items;
    private HouseDTO houseDTO;
    private List<RoomDTO> roomDTOS;
    private final int HEADER_HOUSE = 1;
    private final int ROOM_LIST = 2;
    private OnClickRoom onClickRoom;

    public interface OnClickRoom {
        void onClickRoom(RoomDTO roomDTO);
    }

    public HomeAdapter(Context context, List<Object> items, HouseDTO houseDTO, List<RoomDTO> roomDTOS, OnClickRoom onClickRoom) {
        this.context = context;
        this.items = items;
        this.roomDTOS = roomDTOS;
        this.houseDTO = houseDTO;
        this.onClickRoom = onClickRoom;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        RecyclerView.ViewHolder holder;
        switch (viewType) {
            case HEADER_HOUSE:
                view = inflater.inflate(R.layout.layout_recycler_view, parent, false);
                holder = new HeaderHome(view);
                break;
            case ROOM_LIST:
                view = inflater.inflate(R.layout.layout_recycler_view, parent, false);
                holder = new ListRoom(view);
                break;
            default:
                view = inflater.inflate(R.layout.layout_recycler_view, parent, false);
                holder = new ListRoom(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == HEADER_HOUSE)
            verticalView((HeaderHome) holder);
        else if (holder.getItemViewType() == ROOM_LIST)
            horizontalView((ListRoom) holder);
    }

    private void verticalView(HeaderHome h) {
        try {
            HeaderHomeAdapter adapter1 = new HeaderHomeAdapter(context, houseDTO);
            h.recyclerView.setLayoutManager(new LinearLayoutManager(context));
            h.recyclerView.setAdapter(adapter1);
        } catch (Throwable e) {
            Log.e(TAG, "verticalView: ", e);
        }
    }


    private void horizontalView(ListRoom h) {
        ListRoomAdapter adapter = new ListRoomAdapter(context, roomDTOS, new ListRoomAdapter.OnClickRoom() {
            @Override
            public void onClickRoom(RoomDTO roomDTO) {
                onClickRoom.onClickRoom(roomDTO);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
        h.recyclerView.setAdapter(adapter);
        h.recyclerView.setLayoutManager(mLayoutManager);
        h.recyclerView.setHasFixedSize(true);
        h.recyclerView.setNestedScrollingEnabled(false);
        h.recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Utils.dpToPx(context, 16), true));
        h.recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof HouseDTO)
            return HEADER_HOUSE;
        if (items.get(position) instanceof RoomDTO)
            return ROOM_LIST;
        return -1;
    }

    private class HeaderHome extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        private HeaderHome(View v) {
            super(v);
            recyclerView = v.findViewById(R.id.inner_recyclerView);
        }
    }

    public class ListRoom extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        private ListRoom(View v) {
            super(v);
            recyclerView = v.findViewById(R.id.inner_recyclerView);
        }
    }
}

