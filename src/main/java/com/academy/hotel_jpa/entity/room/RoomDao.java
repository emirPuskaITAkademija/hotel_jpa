package com.academy.hotel_jpa.entity.room;

import com.academy.hotel_jpa.entity.AbstractDao;

public class RoomDao extends AbstractDao<Room, Integer> {
    public RoomDao() {
        super(Room.class);
    }
}
