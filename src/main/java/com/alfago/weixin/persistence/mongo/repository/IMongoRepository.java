package com.alfago.weixin.persistence.mongo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public interface IMongoRepository <T, ID extends Serializable>{

	public void insert(final T entity);
	
	public void insert(final List<T> entities);
	
	public T findOne(final Query query);

	public List<T> findAll(final Query query);

	public void update(final Query query, final Update update);

	public void remove(final Query query);
}
