package com.w2a.products.builders;

import com.w2a.payloads.PayPal;
import com.w2a.payloads.PaymentSource;

public class PaymentSourceBuilder {
	
	private final PaymentSource paymentSource;
	
	private PaymentSourceBuilder() {paymentSource = new PaymentSource();}
	
	public static PaymentSourceBuilder withPayPal(PayPal paypal) {
		PaymentSourceBuilder builder = new PaymentSourceBuilder();
		builder.paymentSource.setPaypal(paypal);
		return builder;
	}
	
	public PaymentSource build() {return this.paymentSource ;}

}
