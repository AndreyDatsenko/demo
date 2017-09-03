package com.example.demo.config;

import net.gpedro.integrations.slack.SlackApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SlackApiConfig {

    @Value("${slack.webhook}")
    private String slackWebhook;

    @Bean
    public SlackApi slackApi() {
        return new SlackApi(slackWebhook);
    }
}
