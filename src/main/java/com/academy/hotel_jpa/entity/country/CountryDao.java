package com.academy.hotel_jpa.entity.country;

import com.academy.hotel_jpa.entity.AbstractDao;

public class CountryDao extends AbstractDao<Country, Integer> {

    public CountryDao() {
        super(Country.class);
    }
}
