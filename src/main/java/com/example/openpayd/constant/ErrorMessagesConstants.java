package com.example.openpayd.constant;

import com.example.openpayd.model.Message;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "errormessages")
@Data
public class ErrorMessagesConstants
{
    private Message nullParameter;
    private Message generalException;
}
