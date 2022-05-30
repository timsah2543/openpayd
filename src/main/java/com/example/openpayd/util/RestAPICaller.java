package com.example.openpayd.util;

import com.example.openpayd.model.request.RequestModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Data
@Component
public class RestAPICaller {
    @Autowired
    private UrlBuilder urlBuilder;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<RequestModel> getExchangeRate(HttpHeaders httpHeaders, String from, String to)
    {
        String url = getUrlBuilder().getExchangeRate(from,to);
        HttpEntity entity = new HttpEntity(httpHeaders);
        return getRestTemplate().exchange(url,HttpMethod.GET,entity,RequestModel.class);
    }

    public ResponseEntity<RequestModel> getConvert(HttpHeaders httpHeaders, String from, String to, Double amount)
    {
        String url = getUrlBuilder().getConvert(from, to, amount);
        HttpEntity entity = new HttpEntity(httpHeaders);
        return getRestTemplate().exchange(url,HttpMethod.GET,entity,RequestModel.class);
    }

    public ResponseEntity<RequestModel> getHistory(HttpHeaders httpHeaders, String from, String date)
    {
        String url = getUrlBuilder().getHistorical(from, date);
        HttpEntity entity = new HttpEntity(httpHeaders);
        return getRestTemplate().exchange(url,HttpMethod.GET,entity,RequestModel.class);
    }
}
