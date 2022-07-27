package com.yash.microservices.labs.moneyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class MoneyExchangeController {
    @Autowired
    private MoneyExchangeProxy moneyExchangeProxy;

    @GetMapping("/money-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public MoneyConversion calculateMoneyConversion(@PathVariable String from,
                                                     @PathVariable String to,
                                                     @PathVariable BigDecimal quantity){
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<MoneyConversion> responseEntity = new RestTemplate().getForEntity("http://20.231.4.63:8000/money-exchange/from/{from}/to/{to}",
                MoneyConversion.class, uriVariables);

        MoneyConversion moneyConversion = responseEntity.getBody();

        return new MoneyConversion(moneyConversion.getId(),
                "from",
                "to",quantity,
                moneyConversion.getConversionMultiple(),
                quantity.multiply(moneyConversion.getConversionMultiple()),
                moneyConversion.getEnvironment() +" "+ "from resttemplate");
    }

    @GetMapping("/money-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public MoneyConversion calculateMoneyConversionfromfeign(@PathVariable String from,
                                                    @PathVariable String to,
                                                    @PathVariable BigDecimal quantity){

        MoneyConversion moneyConversion = moneyExchangeProxy.retriveExchangeValue(from, to);

        return new MoneyConversion(moneyConversion.getId(),
                "from",
                "to",quantity,
                moneyConversion.getConversionMultiple(),
                quantity.multiply(moneyConversion.getConversionMultiple()),
                moneyConversion.getEnvironment() +" "+ "feign");
    }
}
