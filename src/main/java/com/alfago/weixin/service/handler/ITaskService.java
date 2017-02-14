package com.alfago.weixin.service.handler;

public interface ITaskService {

	/*
	 * 提交任务，并且持久化到数据库
	 */
	boolean registerTask();
	
	/*
	 * 生成具体的任务清单
	 */
	void beforeTaskHandle();
	
	/*
	 * 正是处理任务
	 */
	boolean handleTask();
	
	/*
	 * 任务结束后收集任务信息
	 * 
	 */
	void afterTaskCompleted();
}
