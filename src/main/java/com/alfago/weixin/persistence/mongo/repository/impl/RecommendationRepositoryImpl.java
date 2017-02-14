package com.alfago.weixin.persistence.mongo.repository.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.alfago.weixin.common.domain.Recommendation;
import com.alfago.weixin.persistence.mongo.repository.AbstractRepository;
import com.alfago.weixin.persistence.mongo.repository.RecommendationRepository;

public class RecommendationRepositoryImpl extends AbstractRepository<Recommendation,String> implements RecommendationRepository{

	
	public Recommendation findOneByContent(String content) {
		//	BasicQuery query = new BasicQuery("{\"tagName\": {$regex : '" + tagName + "'} }");
		Query query = new Query();
		Criteria criteria = new Criteria();
		query.addCriteria(criteria.where("content").is(content));
		Recommendation result = this.findOne(query);
		return result;
	}

	public List<Recommendation> findAllByContent(String content) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		query.addCriteria(criteria.where("content").is(content));
		List<Recommendation> results = this.findAll(query);
		return results;
	}

	@Override
	protected Class getEntityClass() {

		return Recommendation.class;
	}

	public void findByContentAndUpdate(String content,
			String newContent) {
		Query query = new Query();
		Criteria criteria = new Criteria();
		query.addCriteria(criteria.where("content").is(content));
        Update update = new Update();  
        update.set("content",newContent);
        this.update(query, update);
	}


}
