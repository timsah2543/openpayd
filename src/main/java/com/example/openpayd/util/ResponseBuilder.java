package com.example.openpayd.util;

import com.example.openpayd.model.Message;
import com.example.openpayd.model.ObjectResponse;
import com.example.openpayd.service.exchange_interface.IResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResponseBuilder {

    @Autowired
    private ObjectResponse objectResponse;

    public IResponse createOHResponse(ResponseEntity<?> ohResponseEntity, Message message)
    {
        objectResponse.setCode(ohResponseEntity.getStatusCodeValue());
        objectResponse.setMessage(message);
        objectResponse.setData(ohResponseEntity.getBody());
        return objectResponse;
    }
}
