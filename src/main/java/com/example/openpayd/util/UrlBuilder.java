package com.example.openpayd.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
public class UrlBuilder {

    private String baseUrl = "https://api.fastforex.io/";
    private String apiKey = "9c2451c458-e274d02de3-rcosmz";

    public String getExchangeRate(String from, String to)
    {
        return baseUrl + "fetch-one?from=" + from + "&to=" + to + "&api_key=" + apiKey;
    }

    public String getConvert(String from, String to, Double amount)
    {
        return baseUrl + "convert?from=" + from + "&to=" + to + "&amount=" + amount +"&api_key=" + apiKey;
    }

    public String getHistorical(String from, String date)
    {
        return baseUrl + "historical?date=" + date + "&from=" + from + "&api_key=" + apiKey;
    }
}
