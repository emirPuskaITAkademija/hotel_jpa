package com.academy.hotel_jpa.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.function.Function;

/**
 * CRUD
 * <li>C - Create</li>
 * <li>R - Retrieve</li>
 * <li>U - Update</li>
 * <li>D - Delete</li>
 * <p>
 * <p>
 * Session -> EntityManager (User, Privilege, Country, Town...)
 * Class
 * <p>
 * SessionFactory -> EntityManagerFactory
 * <p>
 * UserDao User.class
 * PrivilegeDao Privilege.class
 *
 *
 * SessionFactory -> EntityManagerFactory
 *
 * Session -> EntityManager
 *
 * @param <E>
 * @param <PK>
 */
public abstract class AbstractDao<E, PK> {

    private final Class<E> entityClass;

    public AbstractDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager entityManager() {
        return EmfHolder.entityManagerFactory().createEntityManager();
    }


    public E save(E entity) {
        Function<EntityManager, E> saveFunction = em -> {
            em.persist(entity);
            return entity;
        };
        return executeInTransaction(saveFunction);
    }

    public E update(E entity) {
        Function<EntityManager, E> updateFunction = em -> {
            em.merge(entity);
            return entity;
        };
        return executeInTransaction(updateFunction);
    }

    // E entity ...
    // PersistenceContext -> otkačeni detached object
    //
    public E delete(E entity) {
        Function<EntityManager, E> deleteFunction = em -> {
            if (!em.contains(entity)) {//otkačen ili detached entity
                E mergedEntity = em.merge(entity);
                em.remove(mergedEntity);
                return mergedEntity;
            } else {
                em.remove(entity);
                return entity;
            }
        };
        return executeInTransaction(deleteFunction);
    }

    public E findBy(PK primaryKey) {
        try (EntityManager em = entityManager()) {
            return em.find(entityClass, primaryKey);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<E> findAll() {
        try (EntityManager em = entityManager()) {
            //Criteria API Builder
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            //Criteria Query
            CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);
            // Specifičan select criteria query SELECT * FROM E e;
            CriteriaQuery<E> select = criteriaQuery.select(criteriaQuery.from(entityClass));
            // Create Query za izvršavanje select i daj mi result list
            return em.createQuery(select).getResultList();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    private E executeInTransaction(Function<EntityManager, E> function) {
        EntityManager em = entityManager();
        try {
            em.getTransaction().begin();
            E result = function.apply(em);
            em.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            if (em.getTransaction().isActive()) {
                em.close();
            }
            throw new RuntimeException(exception);
        } finally {
            em.close();
        }
    }


}
