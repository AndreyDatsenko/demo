package com.example.demo.service;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceDefault implements NotificationService {

    @Value("${slack.channel}")
    private String slackChannel;

    @Value("${slack.username}")
    private String slackUsername;

    private final SlackApi slackApi;

    @Autowired
    public NotificationServiceDefault(SlackApi slackApi) {
        this.slackApi = slackApi;
    }

    @Override
    public void sendNotification(String text) {

        slackApi.call(new SlackMessage(slackChannel, slackUsername, text));

    }
}
