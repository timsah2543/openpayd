package com.example.openpayd.model.mapper;

import com.example.openpayd.model.request.RequestModel;
import com.example.openpayd.model.response.ResponseModel;
import com.example.openpayd.model.response.ResponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FromRequestToResponseMapper {
    @Autowired
    private ResponseModel responseModel;
    @Autowired
    private ObjectMapper objectMapper;

    public ResponseModel createResponseModel(RequestModel requestModel, String to)
    {
        responseModel.setFrom(requestModel.getBase());
        responseModel.setTo(to);
        responseModel.setResult(objectMapper.convertValue(requestModel.getResult(), ResponseResult.class));
        responseModel.setResult(objectMapper.convertValue(requestModel.getResults(), ResponseResult.class));
        if (requestModel.getUpdated() != null)
        {
            responseModel.setDate(requestModel.getUpdated());
        }
       else
        {
            responseModel.setDate(requestModel.getDate());
        }
        return responseModel;
    }
}
