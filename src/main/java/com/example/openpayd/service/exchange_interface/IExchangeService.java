package com.example.openpayd.service.exchange_interface;

import com.example.openpayd.model.request.RequestModel;
import com.example.openpayd.model.response.ResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface IExchangeService {
    ResponseEntity<ResponseModel> getExchangeRate(HttpHeaders httpHeaders, String from, String to);
    ResponseEntity<ResponseModel> getConvert(HttpHeaders httpHeaders, String from, String to, Double amount);
    ResponseEntity<ResponseModel> getHistory(HttpHeaders httpHeaders,String from, String date);
}
