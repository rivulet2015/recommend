package com.alfago.weixin.persistence.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alfago.weixin.common.domain.UserBrowseRecord;

public interface UserBrowseRecordRepository extends MongoRepository<UserBrowseRecord,String>{

	
}
