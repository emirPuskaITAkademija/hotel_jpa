package com.academy.hotel_jpa.entity.user;

import com.academy.hotel_jpa.entity.AbstractDao;
import com.academy.hotel_jpa.entity.EmfHolder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;

//CRUD user/User
public class UserDao extends AbstractDao<User, Integer> {

    public UserDao() {
        super(User.class);
    }

    public User login(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            return null;
        }
        //query na bazu user/User i vidjeti šta će baza vratiti
        //JPA named queries
        EntityManagerFactory emf = EmfHolder.entityManagerFactory();
        try (EntityManager entityManager = emf.createEntityManager()) {
            Query query = entityManager.createNamedQuery("User.findByUsernameAndPassword", User.class);
            User user = (User) query
                    .setParameter("username", username)
                    .setParameter("pass", password)
                    .getSingleResultOrNull();
            return user;
        } catch (NonUniqueResultException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
