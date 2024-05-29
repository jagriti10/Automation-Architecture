package test.api;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.testng.annotations.Test;

import com.w2a.payloads.Order;
import com.w2a.payloads.PurchaseUnits;
import com.w2a.products.builders.AmountBuilder;
import com.w2a.products.builders.ExperianceContextBuilder;
import com.w2a.products.builders.OrderBuilder;
import com.w2a.products.builders.PayPalBuilder;
import com.w2a.products.builders.PaymentSourceBuilder;
import com.w2a.products.builders.PurchaseUnitsBuilder;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class AutenticationTest {
	
	public static String clientId = "Ab4BvLl69D79RnlfDTwVbPLwNXsTl4eIVL_Du3GuBcbT1AWKWshKf-jKR9aItS3yA073P2q6RQMSS3oV";
	public static String clientSecret = "EPQnx1gpfpSiCO8E5tuWcj8yIZlWqbNO7_a442gWjBfNChkMUqHk0LVEZgxh6wdxkoDxDd26c6fDuNa-";
	RequestSpecification baseReq;

	
	@Test()
	public void AuthTest() {
		RestAssured.baseURI= "https://api-m.sandbox.paypal.com";

		
		baseReq =  RestAssured.given()
			.auth().preemptive().basic(clientId, clientSecret)
			.headers("Content-Type", ContentType.URLENC)
			.formParam("grant_type", "client_credentials");
		
		ValidatableResponse authReq = baseReq
		.when().post("/v1/oauth2/token")
	    .then().assertThat().statusCode(200);
		
        System.out.println("Access Token: " + authReq.extract().jsonPath().getString("access_token"));
	
	}
	
	@Test
	public void ordersWithJSONFileTest() {
		RestAssured.baseURI= "https://api-m.sandbox.paypal.com";
		String filePath = System.getProperty("user.dir") + "/src/main/resources/testFiles/orderPayload.json";

        File jsonFile = new File(filePath);

		baseReq =  RestAssured.given()
			.auth().preemptive().basic(clientId, clientSecret)
			.headers("Content-Type", ContentType.JSON)
			.body(jsonFile);
			
			ValidatableResponse authReq = baseReq
			.when().log().all().post("/v2/checkout/orders")
			.then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void ordersWithPOJOTest() {
		RestAssured.baseURI= "https://api-m.sandbox.paypal.com";

		Order order = orderObject().build();
		baseReq =  RestAssured.given()
			.auth().preemptive().basic(clientId, clientSecret)
			.headers("Content-Type", ContentType.JSON)
			.body(order);
			
			ValidatableResponse authReq = baseReq
			.when().log().all().post("/v2/checkout/orders")
			.then().assertThat().statusCode(200);	
	}
	
	private OrderBuilder orderObject() {
		List<PurchaseUnits> purchaseUnits = new ArrayList<>();
		UUID uuid = UUID.randomUUID();
		
		purchaseUnits.add(PurchaseUnitsBuilder
				.withReferenceId(uuid.toString())
				.withAmount(AmountBuilder.withcurrencyCode("USD")
						.withValue("100.00")
						.build())
				.build());
		
		return 
				OrderBuilder
				.withIntent("CAPTURE")
				.withPurchaseUnits(purchaseUnits)
				.withPaymentSource(PaymentSourceBuilder.withPayPal(
						PayPalBuilder.withExperienceContext(ExperianceContextBuilder
								.withPaymentMethodPreference("IMMEDIATE_PAYMENT_REQUIRED")
								.withBrandName("EXAMPLE INC")
								.withLocale("en-US")
								.withLandingPage("LOGIN")
								.withShippingPreference("NO_SHIPPING")
								.withUserAction("PAY_NOW")
								.withReturnUrl("https://example.com/returnUrl")
								.withCancelUrl("https://example.com/cancelUrl")
								.build()
								).build()
						).build());
	}
}
