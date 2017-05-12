package com.alfago.weixin.service.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class TaskJob {
	@Scheduled(cron = "0/2 * * * * ?")
    public void job1() {
       // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$test job1$$$$$$$$$$$$$$$" + new Date());
    }
	@Scheduled(cron = "0/3 * * * * ?")
    public void job2() {
       // System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$test job2$$$$$$$$$$$$$$$" + new Date());
    }
}

