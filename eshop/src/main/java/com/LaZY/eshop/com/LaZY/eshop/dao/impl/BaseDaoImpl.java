package com.LaZY.eshop.com.LaZY.eshop.dao.impl;

import com.LaZY.eshop.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 20:20
 */
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    //连接池
    private SessionFactory sf;
    //接受T的具体类型
    private Class<T> clazz;

    public BaseDaoImpl(){
        //取得子类的泛型超类
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class)type.getActualTypeArguments()[0];
    }

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public void saveEntity(T t) {
        sf.getCurrentSession().save(t);
    }

    public void updateEntity(T t) {
        sf.getCurrentSession().update(t);
    }

    public void saveOrUpdatentity(T t) {
        sf.getCurrentSession().saveOrUpdate(t);
    }

    public void deleteEntity(T t) {
        sf.getCurrentSession().delete(t);
    }

    public T getEntity(T t) {
        return null;
    }


    /***
     * 按照hql查询
     * @return
     */
    public List<T> findByHQL(String hql,Object... objects) {
        Query q = sf.getCurrentSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            q.setParameter(i,objects[i]);
        }
        return q.list();
    }

    /***
     * 按hql进行批量写操作
     * @param hql
     * @param objects
     */
    public void execHQL(String hql, Object... objects) {
        Query q = sf.getCurrentSession().createQuery(hql);
        for (int i = 0; i < objects.length; i++) {
            q.setParameter(i,objects[i]);
        }
        q.executeUpdate();
    }
}
