package cn.itcast.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import cn.itcast.dao.IBaseDao;
import cn.itcast.entity.Employee;

/**
 * 所有dao的通用操作，希望所有的dao都继承此类
 * @author Jie.Yuan
 *
 * @param <T>
 */
 public class BaseDao<T> implements IBaseDao<T> {
	
	// 当前操作的实际的bean类型
	private Class<T> clazz;
	// 获取类名称
	private String className;
	
	// 反射泛型
	public BaseDao(){
		Type type = this.getClass().getGenericSuperclass();
		// 转换为参数化类型
		ParameterizedType pt = (ParameterizedType) type;  // BaseDao<Employee>
		// 得到实际类型
		Type types[] = pt.getActualTypeArguments();
		// 获取实际类型
		clazz = (Class<T>) types[0];
		
		className = clazz.getSimpleName();//例如：Employee
	}


	// 容器注入
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	//@Override
	public void delete(int id) {
		sessionFactory
			.getCurrentSession()
			.createQuery("delete from " + className + " where id=?")
			.setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	//@Override
	public T findById(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	//@Override
	public List<T> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}

	//@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	//@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

}
