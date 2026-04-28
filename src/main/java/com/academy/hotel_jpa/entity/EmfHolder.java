package com.academy.hotel_jpa.entity;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmfHolder {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory entityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("hotelPU");
            //TZV SHUTDOWN HOOK ... kad se bude gasila aplikacija zatvaramo emf odnosno izbjegavamo memory leak
            // resource zatvaramo pravilno
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                if(emf != null && emf.isOpen()) {
                    emf.close();
                }
            }));
        }
        return emf;
    }
}
