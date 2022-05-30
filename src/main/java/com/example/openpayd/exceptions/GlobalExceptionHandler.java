package com.example.openpayd.exceptions;

import com.example.openpayd.constant.ErrorMessagesConstants;
import com.example.openpayd.model.ObjectResponse;
import com.example.openpayd.service.exchange_interface.IResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    private final ObjectMapper objectMapper;
    private final ErrorMessagesConstants errorMessagesConstants;
    private ObjectResponse objectResponse;

    public GlobalExceptionHandler(ObjectMapper objectMapper, ErrorMessagesConstants errorMessagesConstants)
    {
        this.objectMapper = objectMapper;
        this.errorMessagesConstants = errorMessagesConstants;
        this.objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        this.objectResponse = new ObjectResponse();
        objectResponse.setData(null);
    }

    //region ALL Unspecified Exceptions
    @ExceptionHandler(Exception.class)
    public IResponse handleAllExceptions(Exception ex)
    {
        ex.printStackTrace();
        objectResponse.setCode(1000);
        objectResponse.setMessage(errorMessagesConstants.getGeneralException());
        return objectResponse;
    }
    //endregion

}
