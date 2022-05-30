package com.example.openpayd;

import com.example.openpayd.constant.ErrorMessagesConstants;
import com.example.openpayd.constant.SuccessMessagesConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({
        ErrorMessagesConstants.class,
        SuccessMessagesConstants.class
})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EntityScan
public class OpenpaydApplication {
    private static final Logger LOGGER = LogManager.getLogger(OpenpaydApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(OpenpaydApplication.class, args);
    }
}
