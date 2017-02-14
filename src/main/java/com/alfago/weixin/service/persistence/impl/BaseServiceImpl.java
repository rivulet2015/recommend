package com.alfago.weixin.service.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alfago.weixin.common.beans.UserEntity;
import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.service.persistence.IBaseService;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作, 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型 PK :代表对象的主键类型
 *
 * @author StarZou
 * @since 2014年6月9日 下午6:14:06
 */
public abstract class BaseServiceImpl<Model, PK> implements
		IBaseService<Model, PK> {

	private static Integer defaultBathCount = 1000;

	private Integer batchCount = defaultBathCount;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 定义成抽象方法,由子类实现,完成dao的注入
	 *
	 * @return GenericDao实现类
	 */
	public abstract IBaseDao<Model, PK> getDao();

	public abstract SqlSessionFactory getSessionFactory();

	/**
	 * 插入对象
	 *
	 * @param model
	 *            对象
	 */
	public int insert(Model model) {
		return getDao().insertSelective(model);
	}

	/**
	 * 更新对象
	 *
	 * @param model
	 *            对象
	 */
	public int update(Model model) {
		return getDao().updateByPrimaryKeySelective(model);
	}

	/**
	 * 通过主键, 删除对象
	 *
	 * @param id
	 *            主键
	 */
	public int delete(PK id) {
		return getDao().deleteByPrimaryKey(id);
	}

	/**
	 * 通过主键, 查询对象
	 *
	 * @param id
	 *            主键
	 * @return
	 */
	public Model selectById(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	public Model selectOne() {
		return null;
	}

	public List<Model> selectList() {
		return null;
	}

	public void insertBatch(List<Model> models) {

		SqlSession batchSqlSession = null;
		try {
			batchSqlSession = getSessionFactory().openSession(ExecutorType.BATCH, false);
			
			for (int index = 0; index < models.size(); index++) {

				getDao().insertSelective(models.get(index));

				if (index != 0 && index % batchCount == 0) {
					batchSqlSession.commit();
				}
			}
			batchSqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (batchSqlSession != null) {
				batchSqlSession.close();
			}
		}
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public Integer getBatchCount() {
		return batchCount;
	}

	public void setBatchCount(Integer batchCount) {
		this.batchCount = batchCount;
	}
	
	

}