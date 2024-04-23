package com.develop.devcourse.common.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;


@Configuration
public class StorageConfig {
    private final String firebaseConfigPath = "devcourse-dfaf1-firebase-adminsdk-xzndv-170139cd6e.json";
    @Bean
    public Storage storage() throws IOException {
        Resource resource = new ClassPathResource(firebaseConfigPath);
        InputStream inputStream = resource.getInputStream();
        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(inputStream))
                .build()
                .getService();
    }
}
