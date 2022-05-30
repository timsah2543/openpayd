package com.example.openpayd.controller;

import com.example.openpayd.constant.ErrorMessagesConstants;
import com.example.openpayd.constant.SuccessMessagesConstants;
import com.example.openpayd.model.Message;
import com.example.openpayd.model.response.ResponseModel;
import com.example.openpayd.service.exchange_interface.IExchangeService;
import com.example.openpayd.service.exchange_interface.IResponse;
import com.example.openpayd.util.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ExchangeController extends BaseController {

    @Autowired
    private IExchangeService exchangeService;
    @Autowired
    private ResponseBuilder responseBuilder;
    private final SuccessMessagesConstants successMessagesConstants;
    private final ErrorMessagesConstants errorMessagesConstants;
    @Autowired
    private Message message;

    public ExchangeController(ResponseBuilder responseBuilder, SuccessMessagesConstants successMessagesConstants, ErrorMessagesConstants errorMessagesConstants) {
        super(responseBuilder);
        this.successMessagesConstants = successMessagesConstants;
        this.errorMessagesConstants = errorMessagesConstants;
    }

    @GetMapping(path = "getExchangeRate/from={from}&to={to}")
    public IResponse getExchangeRate(@RequestHeader HttpHeaders httpHeaders,
                                       @PathVariable String from,
                                       @PathVariable String to)  {
        ResponseEntity<ResponseModel> response = exchangeService.getExchangeRate(httpHeaders,from,to);
        if (response.getStatusCode() == HttpStatus.OK)
        {
            message = successMessagesConstants.getSuccess();
        }
        return responseBuilder.createOHResponse(response,message);
    }

    @GetMapping(path = "getConvert/from={from}&to={to}&amount={amount}")
    public IResponse getConvert(@RequestHeader HttpHeaders httpHeaders,
                                     @PathVariable String from,
                                     @PathVariable String to,
                                     @PathVariable Double amount)  {
        ResponseEntity<ResponseModel> response = exchangeService.getConvert(httpHeaders,from,to,amount);

        return  responseBuilder.createOHResponse(response,null);
    }

    @GetMapping(path = "getHistory/from={from}&date={date}")
    public IResponse getHistory(@RequestHeader HttpHeaders httpHeaders,
                                @PathVariable String from,
                                @PathVariable String date)  {
        ResponseEntity<ResponseModel> response = exchangeService.getHistory(httpHeaders,from, date);
        return  responseBuilder.createOHResponse(response,null);
    }
}
