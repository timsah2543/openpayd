package com.example.openpayd.model;

import com.example.openpayd.service.exchange_interface.IResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Component
public class ObjectResponse extends BaseResponse implements IResponse {
    private Object data;

    public ObjectResponse(int code, Message message, Object data)
    {
        super(code, message);
        this.data = data;
    }
}
