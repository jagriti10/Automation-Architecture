package com.w2a.products.builders;

import java.util.List;

import com.w2a.payloads.Order;
import com.w2a.payloads.PaymentSource;
import com.w2a.payloads.PurchaseUnits;

public class OrderBuilder {
	
	private final Order order;
	
	private OrderBuilder() { order = new Order();}
	
	public static OrderBuilder withIntent(String intent) {
		OrderBuilder builder = new OrderBuilder();
		builder.order.setIntent(intent);
		return builder;	
	}
	
    public OrderBuilder withPurchaseUnits(List<PurchaseUnits> purchaseUnits) {
        order.setPurchase_units(purchaseUnits);
        return this;
    }
    
    public OrderBuilder withPaymentSource(PaymentSource paymentSource) {
    	order.setPayment_source(paymentSource);
        return this;
    }
    
    public Order build() {
        return this.order;
    }
	

}
