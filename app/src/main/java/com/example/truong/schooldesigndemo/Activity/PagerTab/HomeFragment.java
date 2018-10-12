package com.example.truong.schooldesigndemo.Activity.PagerTab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.truong.schooldesigndemo.Activity.ListDeviceActivity;
import com.example.truong.schooldesigndemo.Adapter.HomeAdapter;
import com.example.truong.schooldesigndemo.Object.HouseDTO;
import com.example.truong.schooldesigndemo.Object.RoomDTO;
import com.example.truong.schooldesigndemo.R;
import com.example.truong.schooldesigndemo.constanst.Constanst;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private List<Object> objects = new ArrayList<>();
    private List<RoomDTO> roomDTOs = new ArrayList<>();
    private HouseDTO houseDTO = new HouseDTO();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), objects, houseDTO, roomDTOs, new HomeAdapter.OnClickRoom() {
            @Override
            public void onClickRoom(RoomDTO roomDTO) {
                if (getActivity() != null) {
                    Bundle b = new Bundle();
                    b.putParcelable(Constanst.ParcelKey.ROOM_DTO, roomDTO);
                    Intent i = new Intent(getActivity(), ListDeviceActivity.class);
                    i.putExtras(b);
                    getActivity().startActivity(i);
                }
            }
        });
        RecyclerView recyclerView = v.findViewById(R.id.rc_list);
        installList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(homeAdapter);
        return v;
    }

    private void installList() {
        houseDTO.setDeviceNumber("45");
        houseDTO.setHouseName("Mỹ Đình Plaza");

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("8");
        roomDTO.setRoom(Constanst.Room.BED_ROOM);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("15");
        roomDTO.setRoom(Constanst.Room.LIVING_ROOM);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("7");
        roomDTO.setRoom(Constanst.Room.BATH_ROOM);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("14");
        roomDTO.setRoom(Constanst.Room.KITCHEN_ROOM);
        roomDTOs.add(roomDTO);

        roomDTO = new RoomDTO();
        roomDTO.setDeviceNumber("17");
        roomDTO.setRoom(Constanst.Room.LIBRARY);
        roomDTOs.add(roomDTO);

        objects.add(houseDTO);
        objects.add(roomDTOs.get(0));
    }
}