package com.w2a.products.builders;

import com.w2a.payloads.ExperienceContext;
import com.w2a.payloads.PayPal;

public class PayPalBuilder {
	
	private final PayPal payPal ;
	
	private PayPalBuilder() {
		payPal = new PayPal();
	}
	
	public static PayPalBuilder withExperienceContext(ExperienceContext experienceContext) {
		PayPalBuilder builder = new PayPalBuilder();
		builder.payPal.setExperience_context(experienceContext);
		return builder;
	} 
	
	public PayPal build() {return this.payPal;}

}
