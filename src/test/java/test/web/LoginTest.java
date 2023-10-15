package test.web;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.W2aCoreTest;
import com.w2a.screens.HomePage;

public class LoginTest extends W2aCoreTest{
	
	@Test
	public void login() {
		
		AssertJUnit.assertTrue(driver.findElement(HomePage.LOGO).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(HomePage.USERID_LABEL).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(HomePage.USERID_INPUT).isEnabled());
		AssertJUnit.assertTrue(driver.findElement(HomePage.PASSWORD_LABEL).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(HomePage.PASSWORD_INPUT).isEnabled());
		AssertJUnit.assertTrue(driver.findElement(HomePage.LOGIN_BTN).isEnabled());
		AssertJUnit.assertTrue(driver.findElement(HomePage.RESET_BTN).isEnabled());
	
	}
	

}
