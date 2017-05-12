package com.alfago.weixin.persistence.mongo.repository;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

public abstract class AbstractRepository<T extends Object, ID extends Serializable>{

    protected MongoTemplate mongoTemplate;
    
    protected String collection;
    
    protected final static Integer RETRYTIME = 10;

    private ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 10, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.CallerRunsPolicy());
    
    private Logger logger = Logger.getLogger(getClass());
    
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public void insert(final T entity) {
		mongoTemplate.insert(entity, collection);
	}

	public void insert(final List<T> entities) {
		mongoTemplate.insert(entities, collection);
	}

	public T findOne(final Query query) {
		T result = (T) mongoTemplate.findOne(query, this.getEntityClass(), collection);
		return result;
	}

	public List<T> findAll(final Query query) {
		List<T> list = (List<T>) mongoTemplate.find(query, this.getEntityClass(), collection);
		return list;
	}

	public void update(final Query query, final Update update) {
		
		final Class entityClass = this.getEntityClass();
		WriteResult ws = mongoTemplate.updateMulti(query, update, entityClass, collection);
        if (ws.getN() == 0) {
            exec.execute(new Runnable() {

                public void run() {
                    int num = 0;
                    WriteResult res = mongoTemplate.updateMulti(query, update, entityClass , collection);
                    while (res.getN() == 0 && num < RETRYTIME) {
                        res = mongoTemplate.updateMulti(query, update, entityClass, collection);
                        num++;
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            logger.error(e);
                        }
                    }
                    if (res.getN() == 0) {
                        logger.error("fianl error");
                    }
                }
            });
        }
	}


	public void remove(final Query query) {
		WriteResult ws = mongoTemplate.remove(query, this.getEntityClass(), collection);
	}
	

	/**
	 * 获取需要操作的实体类class
	 * 
	 * @return
	 */
	protected abstract Class getEntityClass();	
}
