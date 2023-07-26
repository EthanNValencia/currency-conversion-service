package com.nephew.microservices.currencyconversionservice.resource;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nephew.microservices.currencyconversionservice.CurrencyExchangeProxy;
import com.nephew.microservices.currencyconversionservice.entities.CurrencyConversion;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	// http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariable);
		CurrencyConversion currencyConversion = responseEntity.getBody();
		// http://localhost:8000/currency-exchange/from/USD/to/INR
		System.out.println(currencyConversion);
		return new CurrencyConversion(currencyConversion, quantity);
		// return currencyConversion;
	}

	// http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyConversionFeign = currencyExchangeProxy.retrieveCurrentExchangeRate(from, to);
		CurrencyConversion currencyConversionReturn = new CurrencyConversion(currencyConversionFeign, quantity);
		currencyConversionReturn.setEnvironment(currencyConversionReturn.getEnvironment() + " Feign");
		return currencyConversionReturn;
	}

}
