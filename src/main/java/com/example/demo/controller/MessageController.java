package com.example.demo.controller;

import com.example.demo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/message")
public class MessageController {

    private final NotificationService notificationService;

    @Autowired
    public MessageController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

   @GetMapping
   public String messagePage(){
       return "message";
   }

    @PostMapping
    public String sendMessage(@RequestParam("text") String text) {
        notificationService.sendNotification(text);
        return "index";
    }
}
