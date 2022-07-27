package com.yash.microservices.labs.moneyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MoneyExchangeController {
    @Autowired
    private MoneyExchangeRepo moneyExchangeRepo;
    @Autowired
    private Environment environment;

    @GetMapping("/money-exchange/from/{from}/to/{to}")
    public MoneyExchange retriveExchangeValue(@PathVariable String from, @PathVariable String to){
//        MoneyExchange moneyExchange = new MoneyExchange(1000L, from, to, BigDecimal.valueOf(50));
        MoneyExchange moneyExchange = moneyExchangeRepo.findByFromAndTo(from, to);
        if(moneyExchange==null){
            throw new RuntimeException("Unable to find data");
        }
        String port = environment.getProperty("local.server.port");
        moneyExchange.setEnvironment(port);
        return moneyExchange;
    }
}
