package com.yash.microservices.labs.moneyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "money-exchange")
//@FeignClient(name = "money-exchange", url = "localhost:8000")
@FeignClient(name="money-exchange")
public interface MoneyExchangeProxy {

    @GetMapping("/money-exchange/from/{from}/to/{to}")
    public MoneyConversion retriveExchangeValue(@PathVariable String from,
                                                @PathVariable String to);
}
