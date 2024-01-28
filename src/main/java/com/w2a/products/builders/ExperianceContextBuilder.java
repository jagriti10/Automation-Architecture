package com.w2a.products.builders;

import com.w2a.payloads.ExperienceContext;

public class ExperianceContextBuilder {
	
	private final ExperienceContext experienceContext;
	
	private ExperianceContextBuilder() { experienceContext = new ExperienceContext(); }
	
	public static ExperianceContextBuilder withPaymentMethodPreference(String paymentMethodPreference) {
		ExperianceContextBuilder builder = new ExperianceContextBuilder();
		builder.experienceContext.setPayment_method_preference(paymentMethodPreference);
		return builder;
	}
	
	public ExperianceContextBuilder withBrandName(String brandName) {
		experienceContext.setBrand_name(brandName);
		return this;
	}
	
	public ExperianceContextBuilder withLocale(String locale) {
		experienceContext.setLocale(locale);
		return this;
	}
	
	public ExperianceContextBuilder withLandingPage(String landingPage) {
		experienceContext.setLanding_page(landingPage);
		return this;
	}
	
	public ExperianceContextBuilder withShippingPreference(String shippingPreference) {
		experienceContext.setShipping_preference(shippingPreference);
		return this;
	}
	
	public ExperianceContextBuilder withUserAction(String userAction) {
		experienceContext.setUser_action(userAction);
		return this;
	}
	
	public ExperianceContextBuilder withReturnUrl(String returnUrl) {
		experienceContext.setReturn_url(returnUrl);
		return this;
	}
	
	public ExperianceContextBuilder withCancelUrl(String cancelUrl) {
		experienceContext.setCancel_url(cancelUrl);
		return this;
	}
	
	public ExperienceContext build() { return this.experienceContext; }

}
