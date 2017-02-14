package com.alfago.weixin.persistence.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alfago.weixin.common.domain.TaskInfoInDetail;

public interface TaskInfoInDetailRepository extends MongoRepository<TaskInfoInDetail,String>{

	
}
