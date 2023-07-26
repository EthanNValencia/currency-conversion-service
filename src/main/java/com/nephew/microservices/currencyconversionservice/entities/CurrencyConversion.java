package com.nephew.microservices.currencyconversionservice.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CurrencyConversion {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private String environment;
	private LocalDate date;
	
	public CurrencyConversion(CurrencyConversion currencyConversion, BigDecimal quantity) {
		super();
		this.id = currencyConversion.getId();
		this.from = currencyConversion.getFrom();
		this.to = currencyConversion.getTo();
		this.conversionMultiple = currencyConversion.getConversionMultiple();
		this.quantity = quantity;
		this.totalCalculatedAmount = quantity.multiply(currencyConversion.getConversionMultiple());
		this.environment = currencyConversion.getEnvironment();
		this.date = currencyConversion.getDate();
	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple, String environment, LocalDate date) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = quantity.multiply(conversionMultiple);
		this.environment = environment;
		this.date = date;
	}

	public CurrencyConversion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", environment=" + environment + ", totalCalculatedAmount="
				+ totalCalculatedAmount + ", date=" + date + "]";
	}

}
