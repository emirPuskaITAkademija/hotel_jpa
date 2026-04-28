package com.academy.hotel_jpa.entity.user.privilege;

import com.academy.hotel_jpa.entity.AbstractDao;

public class PrivilegeDao extends AbstractDao<Privilege, Integer> {
    public PrivilegeDao() {
        super(Privilege.class);
    }
}
