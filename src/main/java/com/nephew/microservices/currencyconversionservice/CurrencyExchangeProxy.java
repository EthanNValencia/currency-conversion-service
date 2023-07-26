package com.nephew.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nephew.microservices.currencyconversionservice.entities.CurrencyConversion;

// @FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping(path = "currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveCurrentExchangeRate(@PathVariable String from, @PathVariable String to);
	
}
