package com.academy.hotel_jpa.entity.reservation.guest;

import com.academy.hotel_jpa.entity.AbstractDao;

public class GuestDao extends AbstractDao<Guest, Integer> {
    public GuestDao() {
        super(Guest.class);
    }
}
