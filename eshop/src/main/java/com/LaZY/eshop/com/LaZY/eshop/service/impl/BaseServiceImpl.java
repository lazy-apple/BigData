package com.LaZY.eshop.com.LaZY.eshop.service.impl;

import com.LaZY.eshop.com.LaZY.eshop.service.BaseService;
import com.LaZY.eshop.dao.BaseDao;

import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 21:12
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    private BaseDao<T> dao;

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void saveEntity(T t) {
        dao.saveEntity(t);
    }

    public void updateEntity(T t) {
        dao.updateEntity(t);
    }

    public void saveOrUpdatentity(T t) {
        dao.saveOrUpdatentity(t);
    }

    public void deleteEntity(T t) {
        dao.deleteEntity(t);
    }

    public T getEntity(T t) {
        return dao.getEntity(t);
    }

    public List<T> findByHQL(String hql, Object... objects) {
        return dao.findByHQL(hql, objects);
    }

    public void execHQL(String hql, Object... objects) {
        dao.execHQL(hql,objects);
    }
}
