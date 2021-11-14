package com.cafebabe.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class CreateSchemaAutoCleaner {

    @Bean
    public static BeanFactoryPostProcessor schemaFileCleanupPostProcessor() {
        return configurableListableBeanFactory -> {
            String currentDirectory = System.getProperty("user.dir");
            String createSchemaFilePath = currentDirectory + File.separator + "conf" + File.separator + "db" + File.separator + "create-schema.sql";
            File file = new File(createSchemaFilePath);
            file.delete();
        };
    }
}
