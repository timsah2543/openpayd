package com.example.openpayd.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private String from;
    private String to;
    private ResponseResult result;
    private String date;
}
