package com.alfago.weixin.service.persistence.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alfago.weixin.persistence.dao.IBaseDao;
import com.alfago.weixin.service.persistence.ISelfTractionBaseService;

public abstract class SelfTranctionBaseServiceImpl<Model, PK> implements ISelfTractionBaseService<Model, PK> {
	
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
	
	
	public void insertBatch(List<Model> models) {

		SqlSession batchSqlSession = null;
		try {
			batchSqlSession = getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
			
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
