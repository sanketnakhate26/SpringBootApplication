package com.example.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MyScheduler {

    // Every 3 seconds Schedule
    @Scheduled(cron = "*/3 * * * * *")
    public void firstScheduler(){
      //  System.out.println(new Date());
    }
}
