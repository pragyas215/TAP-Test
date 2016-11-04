/**
* This is a sample test 
* Step 1 : Open snapdeal.com/amazon.com/flipcart.com
* Step 2 : Search A product - Mobile
* Step 3 : Select First Product
* Step 4 : Add the product to cart
* Step 5 : Verify the product has been added to cart
* 
* Task : Stubs are already written , you have to implement them and run this test
*/

package com.qait.demo.tests;

import static com.qait.automation.utils.YamlReader.getYamlValue;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;
import com.qait.automation.utils.YamlReader;

public class TestLevel2_GenericEcommerseSiteTest_Stubs_Written_Method_Needs_To_Be_Implemented {

	TestSessionInitiator test;
	String baseUrl;

	@BeforeClass
	public void Start_Test_Session() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
		initVars();
		test.launchApplication(baseUrl);
	}

	@BeforeMethod
	public void handleTestMethodName(Method method) {
		test.stepStartMessage(method.getName());
	}

	private void initVars() {
		baseUrl = getYamlValue("baseUrl");
	}
	@Test(priority=1)
	public void TestStep1_VerifyTitleOfThePage(){
		test.homePage.verifyTitleIsDisplayed();
	}
	
	@Test(priority=2)
	public void TestStep2_VerifyingSignInButton(){
		test.homePage.verifySignInIsPresent();
	}
	@Test(priority=3)
	public void TestStep3_VerifyingCartIsPresent(){
		test.homePage.verifyCartImageIsPresent();
	}
	
	@Test(priority=4)
	public void TestStep4_SearchProduct(){
		test.homePage.enterProductName(getYamlValue("productName"));
		test.homePage.clickSearchIcon();
	}
	
	@Test(priority=5)
	public void TestStep5_VerifySearchResult(){
		test.resultPage.verifyResults(getYamlValue("productName"));
	}
	
	@Test(priority=6)
	public void TestStep6_SelectFirstProduct(){
		test.resultPage.clickFirstProduct();
	}
	@Test(priority=7)
	public void TestStep7_AddToCompare(){
		test.productDetailsPage.AddToCompare();
	}
	
	@Test(priority=8)
	public void TestStep8_VerifyingBuyNowIsDisplayed(){
		test.productDetailsPage.verifyBuyNowButton();
	}
	@Test(priority=9)
	public void TestStep9_VerifyingPinCode(){
		test.productDetailsPage.EnterPincodeInPincodeField();
	}
	@Test(priority=10)
	public void TestStep10_VerifyingPriceSectionIsPresent(){
		test.productDetailsPage.verifyingPriceSectionIsPresent();
	}
	@Test(priority=11)
	public void TestStep11_AddProductToCart(){
		test.productDetailsPage.AddTheProductToCart();
	}
	
	@Test(priority=12)
	public void TestStep12_VerifyingAndClickOnViewCartButton(){
		test.cartPage.verifyViewCartButton();
	}

	@Test(priority=13)
	public void TestStep13_VerifyingPinCodeFieldIsPresentInShoppingCartPage(){
		test.cartPage.verifyingPincodeFieldIsPresentInShoppingCartPage();
	}
	@Test(priority=14)
	public void TestStep14_VerifyRemoveButtonIsPresentInShoppingCartPage(){
		test.cartPage.verifyRemoveButtonIsPresentInShoppingCartPage();
	}
	
	@Test(priority=15)
	public void TestStep15_verifyingPriceFieldIsPresentInShoppingCartPage(){
		test.cartPage.verifyingPriceFieldIsPresentInShoppingCartPage();
	}
	@Test(priority=16)
	public void TestStep16_VerifyingProceedToPayButton(){
		test.cartPage.verifyingProceedToPayButton();
	}
	@Test(priority=17)
	public void TestStep17_VerifyCart(){
		test.cartPage.verifyCart();
		test.cartPage.clickOnProceedToCheckOut();
	}
	
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

	@AfterClass
	public void close_Test_Session() {
		test.closeBrowserSession();
	}

}
