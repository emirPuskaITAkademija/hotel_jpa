package com.academy.hotel_jpa.entity.reservation;

import com.academy.hotel_jpa.entity.AbstractDao;

//CRUD operacije nad reservation/Reservation
public class ReservationDao extends AbstractDao<Reservation, Integer> {
    public ReservationDao() {
        super(Reservation.class);
    }
}
