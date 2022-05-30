package com.example.openpayd;


import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.openpayd.model.response.ResponseModel;
import com.example.openpayd.service.ExchangeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;


@SpringBootTest
public class OpenpaydApplicationTests{

    @Autowired
    public ExchangeServiceImpl exchangeService;

    @Test
    public void getExchangeRate(){
       HttpHeaders httpHeaders = new HttpHeaders();
       String from = "GBP";
       String to = "USD";
       ResponseEntity<ResponseModel> response = exchangeService.getExchangeRate(httpHeaders,from,to);
        assertEquals(200, response.getStatusCode().value());
    }


}
