package com.example.openpayd.controller;

import com.example.openpayd.util.ResponseBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Data
@Controller
@NoArgsConstructor
@Slf4j
public class BaseController {
    private ResponseBuilder responseBuilder;

    public BaseController(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }
}
