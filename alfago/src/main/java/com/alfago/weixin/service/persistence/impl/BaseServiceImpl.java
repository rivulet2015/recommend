package com.alfago.weixin.service.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alfago.weixin.common.dtos.Page;
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
@Transactional(readOnly = true)
public abstract class BaseServiceImpl<Model, PK> implements
		IBaseService<Model, PK> {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 定义成抽象方法,由子类实现,完成dao的注入
	 *
	 * @return GenericDao实现类
	 */
	public abstract IBaseDao<Model, PK> getDao();
	/**
	 * 插入对象
	 *
	 * @param model
	 *            对象
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int insert(Model model) {
		return getDao().insertSelective(model);
	}

	/**
	 * 更新对象
	 *
	 * @param model
	 *            对象
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int update(Model model) {
		int result =  getDao().updateByPrimaryKeySelective(model);
		return result;
	}

	/**
	 * 通过主键, 删除对象
	 *
	 * @param id
	 *            主键
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
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

	public Model selectOne(Model model) {
		return getDao().selectOneByModel(model);
	}

	public List<Model> selectList(Model model) {
		return getDao().selectAllByModel(model);
	}

	public Page<Model> selectPage(Model model,Page<Model> page){
		int start = (page.getPageNo() - 1) * page.getPageSize();
		int size = page.getPageSize();
		int totalRecord = getDao().countSelectModel(model);
		List<Model> results = getDao().selectModelByPage(model, start, size);
		page.setResults(results);
		page.setTotalRecord(totalRecord);
		return page;
    }
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	

}