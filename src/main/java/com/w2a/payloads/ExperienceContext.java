package com.w2a.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExperienceContext {

	private String payment_method_preference;
	
	private String brand_name;
	
	private String locale;
	
	private String landing_page;
	
	private String shipping_preference;
	
	private String user_action;
	
	private String return_url;
	
	private String cancel_url;
}
