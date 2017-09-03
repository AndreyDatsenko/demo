package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorServiceDefault implements GeneratorService {

    private  final NotificationService notificationService;

    @Autowired
    public GeneratorServiceDefault(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void digitGenerate(Integer limit) {
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            int data = rand.nextInt(50) + 1;

            if(data > limit){
                notificationService.sendNotification("data " + data + " more than limit");
            }
            System.out.println(data);
        }
    }
}
