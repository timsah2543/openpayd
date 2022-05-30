package com.example.openpayd.constant;

import com.example.openpayd.model.Message;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "successmessages")
public class SuccessMessagesConstants
{
    private Message success;

}
