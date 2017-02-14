package com.alfago.weixin.common.task;

import com.alfago.weixin.common.beans.TaskEntity;

public interface ITaskScheduler {

	boolean handleTaskRegister(TaskEntity taskEntity);
	
	boolean beforeTaskToHandle(TaskEntity taskEntity);
	
	boolean handleTask(TaskEntity taskEntity);
	
	boolean afterTaskComplete(TaskEntity taskEntity);	
	
}
