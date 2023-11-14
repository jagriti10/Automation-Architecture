package com.w2a.screens;

import org.openqa.selenium.By;

public class HomePage {
	
    private HomePage() {
    }
    
    public static final By LOGO = By.xpath("//div[@id='site-name']");
    public static final By USERID_INPUT = By.xpath("//input[@name='uid']");
    public static final By USERID_LABEL = By.xpath("//input[@name='uid']/parent::td/preceding-sibling::td[contains(text(),'UserID')]");
    public static final By PASSWORD_INPUT = By.xpath("//input[@name='password']");
    public static final By PASSWORD_LABEL = By.xpath("//input[@name='password']/parent::td/preceding-sibling::td[contains(text(),'Password')]");
    public static final By LOGIN_BTN = By.xpath("//input[@name='btnLogin']");
    public static final By RESET_BTN = By.xpath("//input[@name='btnReset']");
    
    public static final By WELCOME_LABEL = By.xpath("//marquee[contains(text(),concat(\"Welcome To Manager\",\"'\",\"s Page of Guru99 Bank\"))]");


}