package com.LaZY.eshop.dao;

import java.util.List;

/**
 * BaseDao接口
 * @author LaZY(李志一)
 * @create 2019-03-04 20:16
 */
public interface BaseDao<T> {
    public void saveEntity(T t);
    public void updateEntity(T t);
    public void saveOrUpdatentity(T t);
    public void deleteEntity(T t);
    public T getEntity(T t);

    public List<T> findByHQL();
    public void execHQL(String hql,Object... objects);
}
