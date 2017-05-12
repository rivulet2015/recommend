package com.alfago.weixin.persistence.mongo.repository;

import java.util.List;

import com.alfago.weixin.common.domain.Recommendation;

public interface RecommendationRepository extends IMongoRepository<Recommendation,String>{

	Recommendation findOneByContent(String content);

	List<Recommendation> findAllByContent(String content);
	
	void findByContentAndUpdate(String content,String newContent);
}
