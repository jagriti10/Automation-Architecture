package com.w2a.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PurchaseUnits {
	
	private String reference_id;
	private Amount amount;
}
