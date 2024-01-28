package com.w2a.products.builders;

import com.w2a.payloads.Amount;
import com.w2a.payloads.PurchaseUnits;

public class PurchaseUnitsBuilder {
	
	private final PurchaseUnits purchaseUnits;
	
	private PurchaseUnitsBuilder() {purchaseUnits = new PurchaseUnits(); } 
	
	public static PurchaseUnitsBuilder withReferenceId(String referenceId) {
		PurchaseUnitsBuilder builder = new PurchaseUnitsBuilder();
		builder.purchaseUnits.setReference_id(referenceId);
		return builder;
	} 
	
	public PurchaseUnitsBuilder withAmount(Amount amount) {
		purchaseUnits.setAmount(amount);
		return this;
	}
	
	public PurchaseUnits build() { return this.purchaseUnits ;}
}
