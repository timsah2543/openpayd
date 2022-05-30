package com.example.openpayd.service.implementation;

import com.example.openpayd.util.RestAPICaller;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Data
@Service
@Component
public class BaseService {
    private RestAPICaller restAPICaller;

    public BaseService(RestAPICaller restAPICaller) {
        this.restAPICaller = restAPICaller;
    }
}
