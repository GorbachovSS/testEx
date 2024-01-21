package com.sgor.testEx.conf;

import com.sgor.testEx.controller.StringController;
import com.sgor.testEx.service.StringExecutor;
import com.sgor.testEx.service.StringExecutorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public StringExecutor stringExecutor() {
        return new StringExecutorImpl();
    }

    @Bean
    public StringController stringController(StringExecutor stringExecutor) {
        return new StringController(stringExecutor);
    }
}
