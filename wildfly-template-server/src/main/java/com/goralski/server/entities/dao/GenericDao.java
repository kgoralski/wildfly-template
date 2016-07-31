package com.goralski.server.entities.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by kgoralski on 23/07/16.
 */

public abstract class GenericDao<T> {
    @Inject
    protected EntityManager entityManager;
    private Class<T> clazz;

    public GenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    public GenericDao() {
    }

    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("SELECT t FROM " + clazz.getSimpleName() + " t")
                .getResultList();
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}