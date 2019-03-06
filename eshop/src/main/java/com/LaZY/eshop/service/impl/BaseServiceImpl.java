package com.LaZY.eshop.service.impl;

import com.LaZY.eshop.dao.BaseDao;
import com.LaZY.eshop.service.BaseService;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * BaseService实现类.
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> dao ;
    private Class clazz;
    public BaseServiceImpl() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }

    public BaseDao<T> getDao() {
        return dao;
    }

    public void setDao(BaseDao<T> dao) {
        this.dao = dao;
    }

    public void saveEntity(T t) {
        dao.saveEntity(t);
    }

    public void updateEntity(T t) {
        dao.updateEntity(t);
    }

    public void saveOrUpdateEntity(T t) {
        dao.saveOrUpdateEntity(t);
    }

    public void deleteEntity(T t) {
        dao.deleteEntity(t);
    }

    public T getEntity(Integer id) {
        return dao.getEntity(id);
    }

    public List<T> findByHQL(String hql, Object... objects) {
        return dao.findByHQL(hql,objects);
    }

    public void execHQL(String hql, Object... objects) {
        dao.execHQL(hql,objects);
    }

    /***
     * 查找所有实体，表的所有信息
     * @return
     */
    public List<T> findAllEntities() {
        String hql = "from " + clazz.getSimpleName();
        System.out.println(hql);//test
        return this.findByHQL(hql);
    }
}