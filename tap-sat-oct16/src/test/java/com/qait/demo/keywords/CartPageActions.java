package com.qait.demo.keywords;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Assert;

import com.qait.automation.getpageobjects.GetPage;
import com.qait.automation.utils.YamlReader;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

public class CartPageActions extends GetPage {

	WebDriver driver;
	private EventFiringWebDriver e_driver;

	public CartPageActions(WebDriver driver) {
		super(driver, "HomePage");
		this.driver = driver;

	}

	public void verifyCart() {
		Assert.assertTrue(element("Proceed_To_Checkout").isDisplayed()|| element("cart").getText()=="1");
	}

	public void clickOnProceedToCheckOut(){
		click(element("Proceed_To_Checkout"));
	}
	public void verifyViewCartButton(){
		Assert.assertTrue(element("btn_ViewCart").isDisplayed());
		click(element("btn_ViewCart"));
	}
	
	public void verifyingPincodeFieldIsPresentInShoppingCartPage(){
		isElementDisplayed("textfield_Pincode");
		logMessage("Pincode field is present in the shopping cart page");
	}
	
	public void verifyRemoveButtonIsPresentInShoppingCartPage(){
		isElementDisplayed("btn_Remove");
	}
	public void verifyingPriceFieldIsPresentInShoppingCartPage(){
		isElementDisplayed("text_Price");
	}
	public void verifyingProceedToPayButton(){
		Assert.assertTrue(element("btn_proceedToPay").isDisplayed());
	}
}
