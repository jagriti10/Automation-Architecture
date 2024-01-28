package com.w2a.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter

public class Order {
	private String intent;
	
	private List<PurchaseUnits> purchase_units;
	
	private PaymentSource payment_source;

}
