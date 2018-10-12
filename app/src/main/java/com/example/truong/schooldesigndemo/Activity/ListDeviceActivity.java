package com.example.truong.schooldesigndemo.Activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.truong.schooldesigndemo.Adapter.ListRoomAdapter;
import com.example.truong.schooldesigndemo.CustomView.GridSpacingItemDecoration;
import com.example.truong.schooldesigndemo.Object.RoomDTO;
import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.Utils;
import com.example.truong.schooldesigndemo.constanst.Constanst;

import java.util.ArrayList;
import java.util.List;

public class ListDeviceActivity extends CommonActivity {

    private static final String TAG = ListDeviceActivity.class.getSimpleName();
    private List<RoomDTO> roomDTOs = new ArrayList<>();
    private TextView tvRoom;
    private ImageView imgRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_device);
        installToolbar("");

        Bundle b = getIntent().getExtras();

        RecyclerView recyclerView = findViewById(R.id.rc_list_device);
        tvRoom = findViewById(R.id.tv_room);
        imgRoom = findViewById(R.id.img_room);
        try {
            if (b != null) {
                RoomDTO roomDTO = b.getParcelable(Constanst.ParcelKey.ROOM_DTO);
                if (roomDTO != null) {
                    tvRoom.setText(Utils.getRoomName(context, roomDTO.getRoom()));
                    imgRoom.setImageDrawable(Utils.getRoomImage(context, roomDTO.getRoom()));
                }
            }
            installList();

            ListRoomAdapter adapter = new ListRoomAdapter(context, roomDTOs, new ListRoomAdapter.OnClickRoom() {
                @Override
                public void onClickRoom(RoomDTO roomDTO) {

                }
            });
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, Utils.dpToPx(context, 16), true));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        } catch (Throwable e) {
            Log.e(TAG, "onCreate: ", e);
        }

    }

    private void installList() {

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("4/8 ON");
        roomDTO.setRoom(Constanst.Device.LIGHTING);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("3/5 LOCK");
        roomDTO.setRoom(Constanst.Device.DOOR);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("2/4 ON");
        roomDTO.setRoom(Constanst.Device.GAS);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("2/5 ACTIVE");
        roomDTO.setRoom(Constanst.Device.CAMERA);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("24° C");
        roomDTO.setRoom(Constanst.Device.TEMP);
        roomDTOs.add(roomDTO);

    }
}
