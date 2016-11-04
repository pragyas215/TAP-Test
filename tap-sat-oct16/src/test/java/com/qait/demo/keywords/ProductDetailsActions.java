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
import static com.qait.automation.utils.YamlReader.getYamlValue;

public class ProductDetailsActions extends GetPage {

	WebDriver driver;
	private EventFiringWebDriver e_driver;

	public ProductDetailsActions(WebDriver driver) {
		super(driver, "HomePage");
		this.driver = driver;

	}

	public void AddTheProductToCart() {
		if(driver.getWindowHandles().size()>1){
		for(String winHandle : driver.getWindowHandles()){
		     driver.switchTo().window(winHandle);
		 }
		}
		element("add_to_cart_btn").click();
	}
	public void AddToCompare(){
		click(element("AddToCompare"));
		logMessage("clicked on Add To compare button");
	}

	public void verifyBuyNowButton(){
		Assert.assertTrue(element("btn_buyNow").isDisplayed());
	}
	
	public void EnterPincodeInPincodeField(){
		Assert.assertTrue(element("textbox_enterPincode").isDisplayed());
		element("textbox_enterPincode").sendKeys(getYamlValue("pincode"));
		click(element("btn_check"));
		logMessage("clicked on pincode checkbutton");
		
	}
	
	public void verifyingPriceSectionIsPresent(){
		Assert.assertTrue(element("text_Price").isDisplayed());
	}
}
