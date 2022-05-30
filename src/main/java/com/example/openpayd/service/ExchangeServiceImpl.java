package com.example.openpayd.service;

import com.example.openpayd.model.mapper.FromRequestToResponseMapper;
import com.example.openpayd.model.request.RequestModel;
import com.example.openpayd.model.response.ResponseModel;
import com.example.openpayd.service.exchange_interface.IExchangeService;
import com.example.openpayd.util.RestAPICaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ExchangeServiceImpl implements IExchangeService {

    @Autowired
    private RestAPICaller restAPICaller;

    private final FromRequestToResponseMapper mapper;
    @Autowired
    private ResponseModel responseModel;

    public ExchangeServiceImpl(FromRequestToResponseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ResponseModel> getExchangeRate(HttpHeaders httpHeaders, String from, String to) {
        ResponseEntity<RequestModel> request = restAPICaller.getExchangeRate(httpHeaders, from, to);
        responseModel = mapper.createResponseModel(request.getBody(), to);
        return ResponseEntity.status(request.getStatusCode()).body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getConvert(HttpHeaders httpHeaders, String from, String to, Double amount) {
        ResponseEntity<RequestModel> request = restAPICaller.getConvert(httpHeaders,from,to,amount);
        responseModel = mapper.createResponseModel(request.getBody(), to);
        return ResponseEntity.status(request.getStatusCode()).body(responseModel);
    }

    @Override
    public ResponseEntity<ResponseModel> getHistory(HttpHeaders httpHeaders, String from, String date) {
        ResponseEntity<RequestModel> request = restAPICaller.getHistory(httpHeaders, from, date);
        responseModel = mapper.createResponseModel(request.getBody(), null);
        return ResponseEntity.status(request.getStatusCode()).body(responseModel);
    }

}
