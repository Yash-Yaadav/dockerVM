package com.yash.microservices.labs.moneyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyExchangeRepo extends JpaRepository<MoneyExchange, Long> {
    MoneyExchange findByFromAndTo(String from, String to);
}
