package com.LaZY.eshop.com.LaZY.eshop.service;

import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 21:10
 */
public interface BaseService<T> {
    public void saveEntity(T t);
    public void updateEntity(T t);
    public void saveOrUpdatentity(T t);
    public void deleteEntity(T t);
    public T getEntity(T t);

    public List<T> findByHQL(String hql, Object... objects);
    public void execHQL(String hql,Object... objects);
}
