package com.w2a.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
	
	private String currency_code;
	private String value;
}
