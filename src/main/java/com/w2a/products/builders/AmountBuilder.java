package com.w2a.products.builders;

import com.w2a.payloads.Amount;

public class AmountBuilder {
	
	private final Amount amount;
	
	public AmountBuilder() {
		amount = new Amount();
	}
	
	public static AmountBuilder withcurrencyCode(String currencyCode) {
		AmountBuilder builder = new AmountBuilder();
		builder.amount.setCurrency_code(currencyCode);
		return builder;
	}
	
	public AmountBuilder withValue(String value) {
		amount.setValue(value);
		return this;                              
	}
	
	public Amount build() {return this.amount;}

}
