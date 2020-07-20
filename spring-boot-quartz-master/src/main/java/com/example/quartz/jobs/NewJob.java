package com.example.quartz.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by haoxy on 2018/9/28.
 * E-mail:hxyHelloWorld@163.com
 * github:https://github.com/haoxiaoyong1014
 */
public class NewJob implements BaseJob{

    private static Logger log = LoggerFactory.getLogger(NewJob.class);

    public NewJob() {

    }
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("1."+context.getJobDetail());
        System.out.println("2."+context.getJobInstance());
        System.out.println("3."+context.getTrigger());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info("New Job执行时间: " + sdf.format(new Date()));
    }
}
