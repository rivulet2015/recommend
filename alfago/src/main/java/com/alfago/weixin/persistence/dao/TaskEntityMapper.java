package com.alfago.weixin.persistence.dao;

import org.springframework.stereotype.Repository;

import com.alfago.weixin.common.beans.TaskEntity;
@Repository("taskEntityMapper")
public interface TaskEntityMapper extends IBaseDao<TaskEntity,Integer> {

}
