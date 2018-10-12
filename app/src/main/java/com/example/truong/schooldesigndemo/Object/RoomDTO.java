package com.example.truong.schooldesigndemo.Object;

import android.os.Parcel;
import android.os.Parcelable;

public class RoomDTO implements Parcelable {
    private String room;
    private String deviceNumber;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public RoomDTO() {

    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(room);
        out.writeString(deviceNumber);
    }


    @SuppressWarnings("rawtypes")
    public static final Parcelable.Creator<RoomDTO> CREATOR
            = new Parcelable.Creator<RoomDTO>() {
        public RoomDTO createFromParcel(Parcel in) {
            return new RoomDTO(in);
        }

        public RoomDTO[] newArray(int size) {
            return new RoomDTO[size];
        }
    };

    @SuppressWarnings("unchecked")
    private RoomDTO(Parcel in) {
        room = in.readString();
        deviceNumber = in.readString();
    }
}
