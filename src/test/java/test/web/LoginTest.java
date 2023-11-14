package test.web;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.base.W2aCoreTest;
import com.w2a.endpoints.BankDemoSiteEndPoints;
import com.w2a.screens.HomePage;
import com.w2a.utilies.Constants;

public class LoginTest extends W2aCoreTest {

	@Test
	public void HomepageTest() {

		log.info("Verify all the elements are displayed");
		Assert.assertTrue(driver.findElement(HomePage.LOGO).isDisplayed());
		Assert.assertTrue(driver.findElement(HomePage.USERID_LABEL).isDisplayed());
		Assert.assertTrue(driver.findElement(HomePage.USERID_INPUT).isEnabled());
		Assert.assertTrue(driver.findElement(HomePage.PASSWORD_LABEL).isDisplayed());
		Assert.assertTrue(driver.findElement(HomePage.PASSWORD_INPUT).isEnabled());
		Assert.assertTrue(driver.findElement(HomePage.LOGIN_BTN).isEnabled());
		Assert.assertTrue(driver.findElement(HomePage.RESET_BTN).isEnabled());
	}

	@DataProvider()
	public Object[][] invalidCredentials() {
		log.trace("In the data provider");
		return new Object[][] { { HomePage.USERID_INPUT }, { HomePage.PASSWORD_INPUT } };
	}


	@Test(dataProvider = "invalidCredentials")
	public void loginTestWithInvalidUserID(By inputField) {
		log.info("Verify login with invalid userID and password");

		WebElement input_field = driver.findElement(inputField);
		String invalidInput = RandomStringUtils.randomAlphabetic(10);
		input_field.sendKeys(invalidInput);

		driver.findElement(HomePage.LOGIN_BTN).click();

		String errorMsg = driver.switchTo().alert().getText();
		Assert.assertEquals(errorMsg, Constants.USER_NOT_VALID_ERROR);

		log.info("Accepting the alert");
		driver.switchTo().alert().accept();

		log.info("Waiting for the page to reload");
		new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(driver.findElement(HomePage.USERID_LABEL)));
	}

	@Test
	public void loginTestWithValidCredentials() {
		log.info("Verify login with valid userID and password");

		WebElement userId_input = driver.findElement(HomePage.USERID_INPUT);
		WebElement password_input = driver.findElement(HomePage.PASSWORD_INPUT);

		log.info("Entering valid UserId and Password");
		userId_input.sendKeys(Constants.VALID_USERID);
		password_input.sendKeys(Constants.VALID_PASSWORD);

		driver.findElement(HomePage.LOGIN_BTN).click();

		log.trace("User reached manager page");
		Assert.assertTrue(driver.getCurrentUrl().contains(BankDemoSiteEndPoints.managerHomePageUrl));
		Assert.assertTrue(driver.findElement(HomePage.WELCOME_LABEL).isDisplayed());
	}

}
