package Common_Functions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Application_Specific_Functions.NCP_Page_Function;
import Page_Objects.NCP_Account_Page;
import Page_Objects.NCP_Home_Page;
import Page_Objects.NCP_Leads_Page;
import Page_Objects.NCP_Login_Page;
import Page_Objects.NCP_Opportunity_Page;
import Page_Objects.NCP_Order_Page;
import Page_Objects.NCP_Reports_Page;
import Page_Objects.NCP_Setup_Page;
import Page_Objects.NCP_Contacts_Page;
import Page_Objects.NCP_Contracts_Page;
import Page_Objects.NCP_Dashboards_Page;
import Utility.Constant;
import Utility.DriverClass;
import Utility.ExcelUtils;
import Utility.NCP_Baseclass_TestCaseNCPSetup;
import Utility.PropertyManager;
import Utility.Report;
import Validation_Functions.Assertion_Functions;
//import javafx.scene.control.Alert;

//Common actions of complete order life cycle
public class Action_Class {
	private static final String[] AccountNames = null;
	static WebDriver driver;
	static NCP_Login_Page loginObj;
	static NCP_Home_Page homeObj;
	static NCP_Leads_Page leadsObj;
	static NCP_Order_Page orderObj;
	static NCP_Account_Page accountObj;
	static NCP_Setup_Page setupObj;
	static NCP_Opportunity_Page OpportunityObj;
	static NCP_Contacts_Page contactObj;
	static NCP_Contracts_Page contractObj;
	static NCP_Reports_Page reportObj;
	static NCP_Dashboards_Page dashboardObj;

	// static String userType;
	static String Salutation;

	// This method will invoke all the page objects
	public static void invokingObjects() {
		driver = DriverClass.driverInstance();
		loginObj = Constant.invokeNCPLoginPageObjects(driver);
		homeObj = Constant.invokeNCPHomePageObjects(driver);
		leadsObj = Constant.invokeNCPLeadsPageObjects(driver);
		orderObj = Constant.invokeNCPOrderPageObjects(driver);
		accountObj = Constant.invokeNCPAccountPageObjects(driver);
		setupObj = Constant.invokeNCPSetupPageObjects(driver);
		OpportunityObj = Constant.invokeNCPOpportunityPageObjects(driver);
		contactObj = Constant.invokeNCPContactsPageObjects(driver);
		contractObj = Constant.invokeNCPContractsPageObjects(driver);
		reportObj = Constant.invokeNCPReportsPageObjects(driver);
		dashboardObj = Constant.invokeNCPDashboardPageObjects(driver);
	}

	// Function to login SF
	public static void Login_Function() throws IOException {
		DriverClass.waitTillElementTobeVisible(driver, loginObj.username)
				.sendKeys(PropertyManager.getInstance().getusername());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.password)
				.sendKeys(PropertyManager.getInstance().getpassword());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.loginButton).click();

		// Validation point for login
		Assertion_Functions.LoginValidation();
	}

	public static void Login_Function_Users() {
		DriverClass.waitTillElementTobeVisible(driver, loginObj.username)
				.sendKeys(PropertyManager.getInstance().getusername());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.password)
				.sendKeys(PropertyManager.getInstance().getpassword());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.loginButton).click();

		// Validation point for login
		// Assertion_Functions.LoginValidation();
	}

	// Function to login SF
	public static void Login_Function2() throws IOException {
		DriverClass.waitTillElementTobeVisible(driver, loginObj.username)
				.sendKeys(PropertyManager.getInstance().getusername());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.password)
				.sendKeys(PropertyManager.getInstance().getpassword());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.loginButton).click();

		Report.testLog(true, "Logged in as Technical Support");
	}

	// Function to create a lead with negative scenario
	public static void LeadsCreationNegativeScenario() throws InterruptedException, IOException {
		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead option.");
		DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(), leadsObj.Salutation);
		Report.testLog(true, "Salutation entered:" + PropertyManager.getInstance().getSalutation());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getState(), leadsObj.state);
		Report.testLog(true, "state entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.savebtn);
		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsCreationValidation2();
	}

	// Function to convert a lead
	public static void LeadsConvertion() throws InterruptedException, IOException {

		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
//		DriverClass.elementclick(leadsObj.leadspicklist);
//		DriverClass.elementclick(leadsObj.allleads);
		DriverClass.waitfor();
		Report.testLog(true, "Search for the lead to be converted");

		DriverClass.elementclick(leadsObj.LeadBarry);

		DriverClass.waitfor();

		DriverClass.elementclick(leadsObj.Convertbtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.finalconvert);
		DriverClass.waitfor();
		Report.testLog(true, "Selected the convert button");
		Assertion_Functions.LeadsConversionValidation();

	}

	// Function to create a lead
	public static void LeadsCreation() throws InterruptedException, IOException, AWTException {

		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead option.");
		DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(),
		// leadsObj.Salutation);
		// Report.testLog(true, "Salutation entered:" +
		// PropertyManager.getInstance().getSalutation());
		// DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.waitfor();
		
		  Actions action = new Actions(driver);
			/*
			 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
		  
		 
		  
		  
		 
		  Robot robot = new Robot();
	//	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitfor();
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// DriverClass.waitfor();
		
		 WebElement scroll = driver.findElement(By.xpath("//input[@name='Phone']"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(scroll);
		  actions.perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.state).click();
		DriverClass.waitfor();
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getState(),
		// leadsObj.state);
		// Report.testLog(true, "state entered : " +
		// PropertyManager.getInstance().getState());
		// DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getLeadsource(),
		// leadsObj.leadsource);
		// Report.testLog(true, "leadsource entered : " +
		// PropertyManager.getInstance().getLeadsource());
		
		 
		
		DriverClass.elementsendvalues(PropertyManager.getInstance().getPhone(), leadsObj.phone);
		Report.testLog(true, "phone entered : " + PropertyManager.getInstance().getPhone());
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getEmail(),
		// leadsObj.email);
		// Report.testLog(true, "email entered : " +
		// PropertyManager.getInstance().getEmail());
	//	 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		 WebElement scroll2 = driver.findElement(By.xpath("//div//input[@name='Square_Feet__c']"));
		  actions.moveToElement(scroll2);
		  actions.perform();
		
	//	action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.viewdep);
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.channeltwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Channel entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.regiontwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Region entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();
		
		/*
		 * WebElement scroll3 = driver.findElement(By.
		 * xpath("//button[@class='slds-button' and contains(text(),'View all dependencies')])[2]"
		 * )); actions.moveToElement(scroll3); actions.perform();
		 */
		
		DriverClass.elementclick(leadsObj.viewdepsegment);
		DriverClass.elementclick(leadsObj.segmenttwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Segment Entered :" + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.subsegmenttwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Sub-Segment Entered :" + PropertyManager.getInstance().getSubsegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();

	//	 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//	 robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	/*
	 * WebElement scroll4 = driver.findElement(By.
	 * xpath("//div[@class='slds-form-element__control']//lightning-base-combobox[@class='slds-combobox_container']//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//div//button[@type='button' and @aria-label='Banner, --None--']"
	 * )); actions.moveToElement(scroll4); actions.perform();
	 */
	//	 WebElement scroll2 = driver.findElement(By.xpath("//div//input[@name='Square_Feet__c']"));
		  actions.moveToElement(scroll2);
		  actions.perform();
	//	  DriverClass.waitfor();
	//	Actions action = new Actions(driver);
	//	action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.Banner).click();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.Banner).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.Banner).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver, leadsObj.FSM).click();
		/*
		 * DriverClass.waitfor(); ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		 * ac.sendKeys(Keys.ENTER).build().perform(); DriverClass.waitfor();
		 */
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.Banner).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.FSM).sendKeys(Keys.ENTER);
		
		 WebElement scroll5 = driver.findElement(By.xpath("//div[@class='slds-form-element__control']//lightning-base-combobox[@class='slds-combobox_container']//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//div//button[@type='button' and @aria-label='Route To Market, --None--']"));
		  actions.moveToElement(scroll5);
		  actions.perform();
		
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.RoutetoMarket).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.Banner).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// leadsObj.RoutetoMarket).sendKeys(Keys.ENTER);

		/*
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getBanner(),
		 * leadsObj.Banner); Report.testLog(true, "Banner Entered :" +
		 * PropertyManager.getInstance().getBanner()); DriverClass.waitfor();
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getFSM(),
		 * leadsObj.FSM); Report.testLog(true, "FSM Entered :" +
		 * PropertyManager.getInstance().getFSM()); DriverClass.waitfor();
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getFSMVaIid(),
		 * leadsObj.FSMvalidfrom); Report.testLog(true, "FSM Date Entered :" +
		 * PropertyManager.getInstance().getFSMVaIid()); DriverClass.waitfor();
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getRoute(),
		 * leadsObj.RoutetoMarket); Report.testLog(true, "Route Entered :" +
		 * PropertyManager.getInstance().getRoute()); DriverClass.waitfor();
		 */
		DriverClass.elementsendvalues(PropertyManager.getInstance().getStudentno(), leadsObj.studentno);
		Report.testLog(true, "studentno Entered :" + PropertyManager.getInstance().getStudentno());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getEmployeeno(), leadsObj.employeeno);
		Report.testLog(true, "employeeno Entered :" + PropertyManager.getInstance().getEmployeeno());

		DriverClass.elementclick(leadsObj.savebtn);

		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsCreationValidation();

	}

	// Function to create an order

	public static void OrderCreation() throws InterruptedException, IOException, AWTException {
		/*
		 * DriverClass.elementclick(homeObj.OrderLink); Report.testLog(true,
		 * "Navigated to Order Object"); Report.testLog(true,
		 * "Click on create new order");
		 * DriverClass.elementclick(orderObj.NewOrderButton);
		 * DriverClass.elementclick(orderObj.FGCheckox);
		 * DriverClass.elementclick(orderObj.Nextbtn); DriverClass.waitfor(); Robot
		 * robot = new Robot();
		 * 
		 * //
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),
		 * orderObj.Orderdate); //
		 * DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),
		 * orderObj.Status);
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
		 * .sendKeys(PropertyManager.getInstance().getStatus());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Click on New Status");
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
		 * .sendKeys(PropertyManager.getInstance().getOrderDate()); Report.testLog(true,
		 * "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
		 * .sendKeys(PropertyManager.getInstance().getOrderAccount());
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); Report.testLog(true,
		 * "Enter Account Name " + PropertyManager.getInstance().getOrderAccount()); //
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(
		 * PropertyManager.getInstance().getOrdersapnumber());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
		 * .sendKeys(PropertyManager.getInstance().getPONumber()); Report.testLog(true,
		 * "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
		 * .sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		 * Report.testLog(true, "Enter Delivery Attention: " +
		 * PropertyManager.getInstance().getDeliveryAttention());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
		 * .sendKeys(PropertyManager.getInstance().getPreparedfor());
		 * Report.testLog(true, "Enter Prepared for " +
		 * PropertyManager.getInstance().getPreparedfor()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Accountdeliverynotes).click();
		 * DriverClass.elementclick(orderObj.Savebtn); DriverClass.waitfor(); String
		 * Orderno = DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); Report.testLog(true, "Order " + Orderno +
		 * " is created Successfully"); }
		 */
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
	}

	public static void OrderSubmission() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProduct());

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodsave);

		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProduct());
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// Assertion_Functions.OrderSubmitValidation();

		// validation for submission
		Report.testLog(true, "Order number sent for Submission is :" + Orderno2);

	}

	public static void OrderSubmission_Submit() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionFG)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitfor();

		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PreparedforFG)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.FGProduct);
		DriverClass.waitfor();
		Report.testLog(true, "1 Gallon Pitcher is added");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProduct());

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProduct());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Comped).click();

		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.compedCB).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Product: 1 Gallon Pitcher is Comped");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch2).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Comped).click();
		/*
		 * robot.keyPress(KeyEvent.VK_RIGHT); robot.keyRelease(KeyEvent.VK_RIGHT);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_9);
		 * robot.keyRelease(KeyEvent.VK_9); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodsave);

		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// Assertion_Functions.OrderSubmitValidation_Submit_Button();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// validation for submission
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();

	}

	public static void ProspectAccountCreation() throws AWTException, InterruptedException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Accountlink);

		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SubSegmentDep).sendKeys(PropertyManager.getInstance().
		 * getSubsegment()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SubSegmentDep).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * Report.testLog(true, "Account Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment());
		 */
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(accountObj.dependencySegment);
		 * DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver,accountObj.Subsegment).sendKeys
		 * (PropertyManager.getInstance().getSubsegment());
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); DriverClass.elementclick(accountObj.Subsegmentapply);
		 * Report.testLog(true, "Acocunt Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment()); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
				.sendKeys(PropertyManager.getInstance().getBanner());
		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ApplyChannel);

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		Report.testLog(true, "Acocunt Created : " + PropertyManager.getInstance().getPropectAccountname());
		// Assertion_Functions.ProspectAccountCreationValidation();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void User_Change() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		driver.switchTo().frame(0);

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.SystemAdminLogin);
		Report.testLog(true, "Logged in as System Admin:System Automation Successfully");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void Sap_Account_Creation() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		driver.switchTo().frame(0);

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.SystemAdminLogin);
		Report.testLog(true, "Logged in as System Adminn");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Section");

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getsapaccountname());
		Report.testLog(true, "Account Name Entered : " + PropertyManager.getInstance().getsapaccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Account Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Account Phone Entered : " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid)
				.sendKeys(PropertyManager.getInstance().getsapid());
		Report.testLog(true, "SAP_ID Entered : " + PropertyManager.getInstance().getsapid());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Account City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Account State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Channel)
				.sendKeys(PropertyManager.getInstance().getChannel());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Acocunt Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RTMSAP).click();
		// .sendKeys(PropertyManager.getInstance().getRTM());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RTMUnknown).click();
		DriverClass.waitfor();
		Report.testLog(true, "Route to market is selected as Unknown");
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.RTMSAP).sendKeys(Keys.ENTER);
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.RTMSAP).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.RTMSAP).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.RTMSAP).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 */
		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Acocunt Routetomarket Entered : " +
		 * PropertyManager.getInstance().getRoute());
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.Segment)
		 * .sendKeys(PropertyManager.getInstance().getSegment());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Acocunt Segment Entered : " +
		 * PropertyManager.getInstance().getSegment()); DriverClass.waitfor();
		 * DriverClass.elementclick(accountObj.dependencySegment);
		 * DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver,accountObj.Subsegment).sendKeys
		 * (PropertyManager.getInstance().getSubsegment());
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); DriverClass.elementclick(accountObj.Subsegmentapply);
		 * Report.testLog(true, "Acocunt Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.Region)
		 * .sendKeys(PropertyManager.getInstance().getRegion());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Acocunt Region Entered : " +
		 * PropertyManager.getInstance().getRegion());
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.Banner)
		 * .sendKeys(PropertyManager.getInstance().getBanner()); Report.testLog(true,
		 * "Acocunt Banner Entered : " + PropertyManager.getInstance().getBanner());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		Report.testLog(true, "SAP Account Created : " + PropertyManager.getInstance().getsapaccountname());
		// Assertion_Functions.SAPAccountCreationValidation();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.AccountsLink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.Accountsdd);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.Accountdelete);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.Accountdeletebutton);
		DriverClass.waitfor();

	}

	public static void Standard_Opportunity_Creation() throws InterruptedException, AWTException, IOException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		Report.testLog(true, "Navigated to Oppotunity Object");
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());

		// .sendKeys(PropertyManager.getInstance().getCloseDate());
		Report.testLog(true, "Opportunity Closedate Entered: " + PropertyManager.getInstance().getCloseDate());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "Opportunity Accountname Entered: " + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CampaignName)
				.sendKeys(PropertyManager.getInstance().getCampaignName());
		Report.testLog(true, "Opportunity CampaignName Entered: " + PropertyManager.getInstance().getCampaignName());

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.Savebtn);

		Assertion_Functions.Standard_Opportunity_Creation_Validation();

		DriverClass.waitfor();

	}

	public static void Corporate_Opportunity_Creation() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.CorporateOpportunityRadioButton);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.Nextbtn);
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());

		// .sendKeys(PropertyManager.getInstance().getCloseDate());
		Report.testLog(true, "Opportunity Closedate Entered: " + PropertyManager.getInstance().getCloseDate());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		Report.testLog(true,
				"Opportunity Accountname Entered: " + PropertyManager.getInstance().getCorporateAccountname());
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		DriverClass.waitfor();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.Savebtn);

		// Assertion_Functions.Corporate_Opportunity_Creation_Validation();
		DriverClass.waitfor();
	}

	public static void Account_Termination_Negative_Scenario() throws AWTException, IOException, InterruptedException {

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Editbtn).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatus).click();
		// .sendKeys(PropertyManager.getInstance().getNcpAccountStatusNone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatusTerminated).click();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Status edited to : " + PropertyManager.getInstance().getNcpAccountStatus());
		Report.testLog(true, "Termination Reason is : Null");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();

		// Report.testLog2(true, "Error : Account Termination Reason is not
		// subbmitted");
		DriverClass.waitfor();

		Assertion_Functions.AccountStatusErrorValidationTerminated();
		DriverClass.waitfor();
	}

	public static void Account_NCPStatus_None_Negative_Scenario()
			throws AWTException, IOException, InterruptedException {

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Editbtn).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatus).click();
		// .sendKeys(PropertyManager.getInstance().getNcpAccountStatusNone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatusNone).click();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatus).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Status edited to : " + PropertyManager.getInstance().getNcpAccountStatus());
		// Report.testLog(true, "Termination Reason is : Null");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();

		// Report.testLog2(true, "Error : Account Termination Reason is not
		// subbmitted");
		DriverClass.waitfor();

		Assertion_Functions.AccountStatusErrorValidation();
		DriverClass.waitfor();
	}

	public static void Add_Users_To_Account_Member() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountTeamlink).click();
		Report.testLog(true, "Navigated to Account :" + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AddMemberBtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.ENTER);

//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "User Entered : " + PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).click();
		// .sendKeys(PropertyManager.getInstance().getArRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Userrole).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role Entered : " + PropertyManager.getInstance().getArRole());

	}

	public static void New_Customer_Lead_Intake() throws IOException, AWTException, InterruptedException {
		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead Button.");
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		// DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(), leadsObj.Salutation);
		Report.testLog(true, "Salutation entered:" + PropertyManager.getInstance().getSalutation());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getState(), leadsObj.state);
		Report.testLog(true, "state entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getLeadsource(),leadsObj.leadsource);
		Report.testLog(true, "leadsource entered : " + PropertyManager.getInstance().getLeadsource());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getPhone(), leadsObj.phone);
		Report.testLog(true, "phone entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getEmail(), leadsObj.email);
		Report.testLog(true, "email entered : " + PropertyManager.getInstance().getEmail());

		DriverClass.waitfor();

		DriverClass.elementclick(leadsObj.savebtn);

		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsCreationValidation();
		DriverClass.waitfor();
	}

	public static void Add_Venue_To_Account() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Entered : " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.VenueLink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewVenueBtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.VenueName)
				.sendKeys(PropertyManager.getInstance().getVenueName());
		Report.testLog(true, "Venue Name Entered : " + PropertyManager.getInstance().getVenueName());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.VenueDescription)
				.sendKeys(PropertyManager.getInstance().getVenueDescription());
		Report.testLog(true, "Venue Description entered : " + PropertyManager.getInstance().getVenueDescription());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewLov)
				.sendKeys(PropertyManager.getInstance().getBrew());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Brew value entered : " + PropertyManager.getInstance().getBrew());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EspressoLov)
				.sendKeys(PropertyManager.getInstance().getEspresso());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Espresso value entered : " + PropertyManager.getInstance().getEspresso());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SaveEdit).click();

		Assertion_Functions.Add_Venue_Validation();

		DriverClass.waitfor();

	}

	public static void TAPOrderCreation() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		// Report.testLog(true, "Equipment type selected");
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		// DriverClass.elementclick(orderObj.prodsave);
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAP());
		/*
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.EditProduct).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.EditProduct).sendKeys(
		 * Keys.DOWN);
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.EditProduct).sendKeys(
		 * Keys.ENTER); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Venue_Brew_Site).sendKeys(PropertyManager.getInstance().
		 * getVenue_Brew_Site());
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Calibration_Brand).sendKeys(PropertyManager.getInstance().
		 * getCalibration_Brand()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Calibration_Brand).
		 * sendKeys(Keys.ENTER); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Service_Authorization).sendKeys(PropertyManager.getInstance().
		 * getService_Authorization()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Service_Authorization)
		 * .sendKeys(Keys.ENTER); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Service_Invoice).sendKeys(PropertyManager.getInstance().
		 * getService_Invoice()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Service_Invoice).
		 * sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.SaveEdit).click();
		 * 
		 * String Orderno2 = DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor(); //
		 * Assertion_Functions.OrderSubmitValidation();
		 * 
		 * // validation for submission Report.testLog(true,
		 * "Order number sent for Submission is :" + Orderno2); DriverClass.waitfor();
		 */

	}

	public static void TAROrderCreation() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Robot robot = new Robot();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		// .sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date is taken as todays date");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		
		
		/*
		 * if(DriverClass.waitTillElementTobeVisible(driver,orderObj.RfR).isDisplayed())
		 * { DriverClass.waitTillElementTobeVisible(driver,orderObj.RfR).click();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.ReasonNR).click();
		 * Report.testLog(true,"Reason for return is selected"); }else {
		 * System.out.println("Reason for return is available"); }
		 */
		  
		  

			DriverClass.waitTillElementTobeVisible(driver, orderObj.RRR).click();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, orderObj.ReRR).click();
			DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddTradeAssets);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
		 * .sendKeys(PropertyManager.getInstance().getProductTAP());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Enter Product name " +
		 * PropertyManager.getInstance().getProduct());
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.TARprodcheckox);
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(orderObj.Nextbtn2); DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.TARSavebutton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_RIGHT); robot.keyRelease(KeyEvent.VK_RIGHT);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_2);
		 * robot.keyRelease(KeyEvent.VK_2); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.OwnershipBtn).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect)
		 * .sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); Report.testLog(true,
		 * "Ownership status is: " +
		 * PropertyManager.getInstance().getOwnershipStatus()); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.prodsave);
		 * 
		 * Report.testLog(true, "Product added is :" +
		 * PropertyManager.getInstance().getProductTAP()); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.EditProduct).click();
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN);
		 * 
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Venue_Brew_Site)
		 * .sendKeys(PropertyManager.getInstance().getVenue_Brew_Site());
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Calibration_Brand)
		 * .sendKeys(PropertyManager.getInstance().getCalibration_Brand());
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Service_Authorization)
		 * .sendKeys(PropertyManager.getInstance().getService_Authorization());
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Service_Invoice)
		 * .sendKeys(PropertyManager.getInstance().getService_Invoice());
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.SaveEdit).click();
		 * 
		 * String Orderno2 = DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor(); //
		 * Assertion_Functions.OrderSubmitValidation();
		 * 
		 * // validation for submission Report.testLog(true,
		 * "Order number sent for Submission is :" + Orderno2);
		 * 
		 * DriverClass.waitfor();
		 */

	}

	public static void FG_Quote_Creation() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : SampleOpportunity");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NewQuoteBtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Selection to create a FG Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteName)
				.sendKeys(PropertyManager.getInstance().getQuoteName());
		DriverClass.waitfor();
		Report.testLog(true, "Quote Name entered : " + PropertyManager.getInstance().getQuoteName());
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchAccounts)
		 * .sendKeys(PropertyManager.getInstance().getSearchAccounts());
		 * Report.testLog(true, "Repreentative Account Name entered : " +
		 * PropertyManager.getInstance().getSearchAccounts());
		 * 
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * OpportunityObj.SearchContacts).sendKeys(PropertyManager.getInstance().
		 * getSearchContacts()); DriverClass.waitfor(); DriverClass.waitfor();
		 * Report.testLog(true, "Contact Name entered : " +
		 * PropertyManager.getInstance().getSearchContacts());
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		Report.testLog(true, "Phone Number entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Notes)
				.sendKeys(PropertyManager.getInstance().getNotes());
		DriverClass.waitfor();
		Report.testLog(true, "Notes entered : " + PropertyManager.getInstance().getNotes());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SaveBtn2).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteNumber).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated into newly created Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddProductsQuotes).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchprodQuote)
				.sendKeys(PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.SaveQuoteProduct);

		Report.testLog(true, "Product added successfully is :" + PropertyManager.getInstance().getProduct());

		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void TA_Quote_Creation() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Opportunity_Test2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : test1769");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NewQuoteBtn).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Selection to create a TA Quote");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteName)
				.sendKeys(PropertyManager.getInstance().getQuoteNameTA());
		DriverClass.waitfor();
		Report.testLog(true, "Quote Name entered : " + PropertyManager.getInstance().getQuoteName());
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchAccounts)
		 * .sendKeys(PropertyManager.getInstance().getSearchAccounts());
		 * Report.testLog(true, "Repreentative Account Name entered : " +
		 * PropertyManager.getInstance().getSearchAccounts()); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchContacts)
		 * .sendKeys(PropertyManager.getInstance().getSearchContacts());
		 * DriverClass.waitfor(); Report.testLog(true, "Contact Name entered : " +
		 * PropertyManager.getInstance().getSearchContacts());
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		Report.testLog(true, "Phone Number entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Notes)
				.sendKeys(PropertyManager.getInstance().getNotes());
		DriverClass.waitfor();
		Report.testLog(true, "Notes entered : " + PropertyManager.getInstance().getNotes());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SaveBtn2).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteNumberTA).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated into newly created Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddProductsQuotes).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchprodQuote)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.SaveQuoteProduct);

		Report.testLog(true, "Product added successfully is :" + PropertyManager.getInstance().getProductTAP());

		DriverClass.waitfor();

	}

	// Add contact

	public static void Add_Contact_To_Account() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearch());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(contactObj.NewContactBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Salutation)
				.sendKeys(PropertyManager.getInstance().getSalutation());
		Report.testLog(true, "Enter Salutation name " + PropertyManager.getInstance().getSalutation());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Firstname)
				.sendKeys(PropertyManager.getInstance().getFisrtname());
		Report.testLog(true, "Enter First name " + PropertyManager.getInstance().getFisrtname());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Middlename)
				.sendKeys(PropertyManager.getInstance().getMiddlename());
		Report.testLog(true, "Enter Middle name " + PropertyManager.getInstance().getMiddlename());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Lastname)
				.sendKeys(PropertyManager.getInstance().getLastname());
		Report.testLog(true, "Enter Last name " + PropertyManager.getInstance().getLastname());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Suffix)
				.sendKeys(PropertyManager.getInstance().getSuffix());
		Report.testLog(true, "Enter suffix " + PropertyManager.getInstance().getSuffix());
		// DriverClass.waitTillElementTobeVisible(driver, contactObj.phone).sendKeys(PropertyManager.getInstance().getPhone());
		// Report.testLog(true, "Enter Phone " + PropertyManager.getInstance().getPhone());
		// DriverClass.waitTillElementTobeVisible(driver,
		// contactObj.email).sendKeys(PropertyManager.getInstance().getEmail());
		// Report.testLog(true, "Enter email " +
		// PropertyManager.getInstance().getEmail());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getAccountName());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.SaveContact).click();

		Assertion_Functions.Add_Contact_Validation();
		DriverClass.waitfor();

	}

	public static void Add_NCP_Evergreen_Contract_To_Account() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(contractObj.NewContractBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractName)
				.sendKeys(PropertyManager.getInstance().getContractName());
		Report.testLog(true, "Enter Contract name " + PropertyManager.getInstance().getContractName());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.Description)
				.sendKeys(PropertyManager.getInstance().getDescription());
		Report.testLog(true, "Enter Description " + PropertyManager.getInstance().getDescription());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType)
				.sendKeys(PropertyManager.getInstance().getContractType());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Type " + PropertyManager.getInstance().getContractType());
		DriverClass.waitTillElementTobeClickable(driver, contractObj.ContractStartDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Start Date " + PropertyManager.getInstance().getContractDate());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.EquipmentNotes)
				.sendKeys(PropertyManager.getInstance().getEquipmemntNotes());
		DriverClass.waitfor();
		Report.testLog(true, "Enter Equipment Note :  " + PropertyManager.getInstance().getEquipmemntNotes());

		DriverClass.waitTillElementTobeVisible(driver, contractObj.SaveContact).click();
		DriverClass.waitfor();
		Assertion_Functions.Add_Contract_Validation();
		DriverClass.waitfor();
	}

	// This is the negative scenario for SAP account creation
	public static void NCP_SAP_Account_Creation_Negative_Scenario()
			throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
	
	
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}
		Actions act = new Actions(driver);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.SystemAdminLogin).click();
		Report.testLog(true, "Logged in as System Adminn");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Section");
		// driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.CustomerSAP);
		// driver.navigate().refresh();
		DriverClass.waitfor();
		// act.moveToElement(accountObj.RecordNext).click().build();
		// DriverClass.elementclick(accountObj.RecordNext);
		// driver.navigate().refresh();
//        DriverClass.waitfor();
//        DriverClass.waitfor();
//        DriverClass.waitfor();
		// act.moveToElement(accountObj.RecordNext).click().build();
		DriverClass.elementclick(accountObj.RecordNext);
		// robot.keyPress(KeyEvent.VK_TAB);
		// robot.keyRelease(KeyEvent.VK_TAB);
		// DriverClass.waitTillElementTobeVisible(driver,accountObj.NewAccountCreatebtn).sendKeys(Keys.DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);

//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);

		// DriverClass.waitTillElementTobeVisible(driver,accountObj.NewAccountCreatebtn).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getsapaccountname());
		Report.testLog(true, "Account Name Entered : " + PropertyManager.getInstance().getsapaccountname());
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Account Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Account Phone Entered : " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid)
				.sendKeys(PropertyManager.getInstance().getsapid2());
		Report.testLog(true, "SAP_ID Entered : " + PropertyManager.getInstance().getsapid2());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Account City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Account State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Channel)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Channel).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket)
		 * .sendKeys(PropertyManager.getInstance().getRoute());
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Routetomarket).sendKeys(Keys.ENTER); //
		 * robot.keyPress(KeyEvent.VK_ENTER); // robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Acocunt Routetomarket Entered : " +
		 * PropertyManager.getInstance().getRoute());
		 */
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RTMSAP).click();
		// .sendKeys(PropertyManager.getInstance().getRTM());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RTMUnknown).click();
		DriverClass.waitfor();
		Report.testLog(true, "Route to market is selected as Unknown");
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Segment).sendKeys(PropertyManager.getInstance().getSegment());
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Segment).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// Report.testLog(true, "Acocunt Segment Entered : " +
		// PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.dependencySegment);
		/*
		 * DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver,accountObj.Subsegment).sendKeys
		 * (PropertyManager.getInstance().getSubsegment());
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Subsegment).sendKeys(Keys.DOWN); //
		 * robot.keyPress(KeyEvent.VK_DOWN); // robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Subsegment).sendKeys(Keys.DOWN); //
		 * robot.keyPress(KeyEvent.VK_DOWN); // robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Subsegment).sendKeys(Keys.ENTER); //
		 * robot.keyPress(KeyEvent.VK_ENTER); // robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); DriverClass.elementclick(accountObj.Subsegmentapply);
		 * Report.testLog(true, "Acocunt Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment()); DriverClass.waitfor();
		 */
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Region).sendKeys(PropertyManager.getInstance().getRegion());
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Region).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// Report.testLog(true, "Acocunt Region Entered : " +
		// PropertyManager.getInstance().getRegion());
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Banner).sendKeys(PropertyManager.getInstance().getBanner());
		// Report.testLog(true, "Acocunt Banner Entered : " +
		// PropertyManager.getInstance().getBanner());
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.Banner).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.elementclick(accountObj.save);
		// Report.testLog(true, "SAP Account Created : " +
		// PropertyManager.getInstance().getsapaccountname());
		// Assertion_Functions.SAPAccountCreationValidation();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitfor();

		Assertion_Functions.SAP_Account_Negative_Scenario_Validation();

		/*
		 * String exp =
		 * "duplicate value found: SAP_Ext_ID__c duplicates value on record with id: 00118000011jhiZ"
		 * ; WebElement a = driver.findElement(By.className("errorsList")); String act =
		 * a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp, act); Report.testLog(true,
		 * "SAP Account not Created: Duplicate SAP id error");
		 */
	}

	public static void Add_NCP_Negotiated_Contract_To_Account() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch2());
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.NCPContractObj).click().perform();

		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(contractObj.NewContractBtn);
		DriverClass.waitfor();

		DriverClass.elementclick(contractObj.NegotiatedRecord);
		DriverClass.waitfor();

		// NegotiatedRecord

		DriverClass.waitTillElementTobeVisible(driver, contractObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractName)
				.sendKeys(PropertyManager.getInstance().getContractName());
		Report.testLog(true, "Enter Contract name " + PropertyManager.getInstance().getContractName());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		// act.moveToElement(contractObj.CollegeAccount).click().perform();
		// DriverClass.waitTillElementTobeVisible(driver,contractObj.AccountName).sendKeys(PropertyManager.getInstance().getOrderAccount());

		DriverClass.waitfor();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.Description)
				.sendKeys(PropertyManager.getInstance().getDescription2());
		Report.testLog(true, "Enter Description " + PropertyManager.getInstance().getDescription2());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType)
				.sendKeys(PropertyManager.getInstance().getContractType2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,
		// contractObj.ContractType).sendKeys(PropertyManager.getInstance().getContractType2());
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Type " + PropertyManager.getInstance().getContractType2());
		DriverClass.waitTillElementTobeClickable(driver, contractObj.ContractStartDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Enter Contract Start Date " + PropertyManager.getInstance().getContractDate());
		// DriverClass.waitTillElementTobeVisible(driver,contractObj.EquipmentNotes).sendKeys(PropertyManager.getInstance().getEquipmemntNotes());
		// DriverClass.waitfor();
		// Report.testLog(true, "Enter Equipment Note : " +
		// PropertyManager.getInstance().getEquipmemntNotes());

		DriverClass.waitTillElementTobeVisible(driver, contractObj.SaveContact).click();
		DriverClass.waitfor();
		Assertion_Functions.Add_Contract_Validation();
		DriverClass.waitfor();
	}

	public static void TAPOrderForEventsCreation() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
//		robot.keyPress(KeyEvent.VK_RIGHT);
//		robot.keyRelease(KeyEvent.VK_RIGHT);
//		DriverClass.waitfor();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		DriverClass.waitfor();
//		robot.keyPress(KeyEvent.VK_2);
//		robot.keyRelease(KeyEvent.VK_2);
//		DriverClass.waitfor();
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();

		// DriverClass.elementclick(orderObj.prodsave);
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();

		// Assertion_Functions.OrderSubmitValidation();
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();

		// validation for submission
		Report.testLog(true, "Order number sent for Submission is :" + Orderno2);
		DriverClass.waitfor();

	}

	// changes##############################################################################################################
	// Function to login SF for user setup
	public static void login_UserSetup() throws IOException {
		DriverClass.waitTillElementTobeVisible(driver, loginObj.username)
				.sendKeys(PropertyManager.getInstance().getusername());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.password)
				.sendKeys(PropertyManager.getInstance().getpassword());
		DriverClass.waitTillElementTobeVisible(driver, loginObj.loginButton).click();

		// Validation point for login
		Assertion_Functions.loginValidationUserSetup();
	}

	public static void editRoles() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPSALES);
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getErAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getErAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getSpecialistUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getArRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.newEditButton).click();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole)
				.sendKeys(PropertyManager.getInstance().getErRole());
	//	Report.testLog(true, "Role : " + PropertyManager.getInstance().getErRole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role Updated : " + PropertyManager.getInstance().getErRole());
		Assertion_Functions.eRolesValidation();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addRoles() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPSALES);
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "account" + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AddMemberBtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.ENTER);
		Report.testLog(true, "User Entered : " + PropertyManager.getInstance().getUserName());
		System.out.println(PropertyManager.getInstance().getErRole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole)
				.sendKeys(PropertyManager.getInstance().getErRole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Assertion_Functions.aRolesNegativeValidation();
	}

	public static void OrderSubmission_Without_Mandatory_Field()
			throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Status).sendKeys(Keys.ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		
		/*
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());

		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		// DriverClass.waitTillElementTobeVisible(driver,orderObj.DeliveryAttention).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		// Report.testLog(true, "Enter Delivery Attention: " +
		// PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.waitfor();
//		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProduct());
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();

		Assertion_Functions.FG_Order_Negative_Scenario_Validation();

//	DriverClass.elementclick(orderObj.Changestatus);
//	DriverClass.waitfor();

		/*
		 * String exp =
		 * "To mark this Order as Ready to Submit, Delivery Attention To, Prepared For, and PO Number (if"
		 * +" Account PO Requirements"+" on the Account is "+"Mandatory PO Number"
		 * +") must be completed."; WebElement a = driver.findElement(By.
		 * xpath("//span[@class='toastMessage forceActionsText' and contains(text(),  'To mark this Order as Ready to Submit, Delivery Attention To, Prepared For, and PO Number (if "
		 * +"Account PO Requirements"+" on the Account is "+"Mandatory PO Number"
		 * +") must be completed.')]")); String act = a.getText();
		 * System.out.println("Error Message is: " + act); Assert.assertEquals(exp,
		 * act); Report.testLog(true,
		 * "Order is not sent to SAP: Mandatory fields not filled");
		 */

		// validation for submission
		// Report.testLog(true, "Order number sent for Submission is :" + Orderno2 );

	}

	public static void Add_Contact_To_Account_Negative_Scenario()
			throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearch());
		DriverClass.waitfor();
		Actions action = new Actions(driver);
		action.moveToElement(homeObj.con).click().perform();
		DriverClass.waitfor();
		DriverClass.elementclick(contactObj.NewContactBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Salutation)
				.sendKeys(PropertyManager.getInstance().getSalutation());
		Report.testLog(true, "Enter Salutation name " + PropertyManager.getInstance().getSalutation());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Firstname)
				.sendKeys(PropertyManager.getInstance().getFirstName());
		Report.testLog(true, "Enter First name " + PropertyManager.getInstance().getFisrtname());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Middlename)
				.sendKeys(PropertyManager.getInstance().getMiddlename());
		Report.testLog(true, "Enter Middle name " + PropertyManager.getInstance().getMiddlename());
		// DriverClass.waitTillElementTobeVisible(driver,contactObj.Lastname).sendKeys(PropertyManager.getInstance().getLastname());
		// Report.testLog(true, "Enter Last name " +
		// PropertyManager.getInstance().getLastname());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.Suffix)
				.sendKeys(PropertyManager.getInstance().getSuffix());
		Report.testLog(true, "Enter suffix " + PropertyManager.getInstance().getSuffix());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.email)
				.sendKeys(PropertyManager.getInstance().getEmail());
		Report.testLog(true, "Enter email " + PropertyManager.getInstance().getEmail());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getAccountName());
		DriverClass.waitTillElementTobeVisible(driver, contactObj.SaveContact).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * String exp = "We hit a snag."; WebElement a = driver.findElement(By.
		 * xpath("//h2[@class='slds-truncate slds-text-heading_medium']")); String act =
		 * a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp,act); Report.testLog(true,
		 * "Contact not Create: Last Name field not filled");
		 */

		Assertion_Functions.Add_Contact_Negative_Scenario_Validation();
		// DriverClass.waitfor();
	}

	public static void FG_Order_Cloning() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());

		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitfor();
		// act.moveToElement(orderObj.searchprod).click().perform();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
//robot.keyPress(KeyEvent.VK_ENTER);
//robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodsave);
		/*
		 * DriverClass.waitfor(); DriverClass.elementclick(orderObj.quantitySearch);
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.qtyInput).sendKeys("3"); DriverClass.waitfor();
		 */
		// .sendKeys(PropertyManager.getInstance().getQuantity());
		// DriverClass.elementclick(orderObj.qtysave);

//DriverClass.waitTillElementTobeVisible(driver,orderObj.Nextbtn2).sendKeys(Keys.ARROW_RIGHT);
//robot.keyPress(KeyEvent.VK_RIGHT);
//robot.keyRelease(KeyEvent.VK_RIGHT);
//DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.ENTER);
//robot.keyPress(KeyEvent.VK_ENTER);
//robot.keyRelease(KeyEvent.VK_ENTER);
		// DriverClass.waitfor();
		// DriverClass.waitfor();

//robot.keyPress(KeyEvent.VK_9);
//robot.keyRelease(KeyEvent.VK_9);
		/*
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Accountname).sendKeys(Keys.ENTER);
		 * //robot.keyPress(KeyEvent.VK_ENTER); //robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.prodsave); DriverClass.waitfor();
		 * DriverClass.waitfor();
		 */

		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductnew());
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.CloneOrderButton);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount)
				.sendKeys(PropertyManager.getInstance().getSearchAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getSearchAccount());
//DriverClass.elementsendvalues(PropertyManager.getInstance().getSearchAccount(), orderObj.SearchAccount);

		DriverClass.elementclick(orderObj.AccountCheckBox);
		Report.testLog(true, "Account selection for cloning the order");
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */

		/*
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 */

		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.CloneButton);
		DriverClass.waitfor();

		driver.switchTo().alert().accept();
		DriverClass.waitfor();
		Report.testLog(true, "Closing the popup page");

		DriverClass.elementclick(orderObj.CloneCancelButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.NotificationIcon);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigation to cloned order");

		Assertion_Functions.Cloning_Order_Validation();

		DriverClass.elementclick(orderObj.SuccessfulCloning);
		DriverClass.waitfor();
//Report.testLog(true, "Cloning is successful");

	}

	public static void NCP_TAP_Order_Creation_Negative_Scenario()
			throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		Report.testLog(true, "Click on New Order Button");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		Report.testLog(true, "Select TAP Order Check box");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		Report.testLog(true, "Click on Next Button");
		DriverClass.waitfor();
		// Robot robot = new Robot();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		 * act.moveToElement(orderObj.Espresso).click().perform(); Report.testLog(true,
		 * "Equipment type selected");
		 */
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter Retrieval Installation" + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.elementclick(orderObj.Savebtn);

		/*
		 * String exp = "These required fields must be completed: Phone"; WebElement a =
		 * driver.findElement(By.
		 * xpath("//li[contains(text(), 'These required fields must be completed: Phone')]"
		 * )); String act = a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp,act); Report.testLog(true,
		 * "TAP Order not created:Phone field not filled");
		 */

		Assertion_Functions.TAP_Order_Negative_Scenario_Validation();

	}

	public static void Standard_Opportunity_Creation_Negative_Scenario()
			throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		Report.testLog(true, "Navigated to Oppotunity Object");
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Opportunity Closedate Entered: " + PropertyManager.getInstance().getCloseDate());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "Opportunity Accountname Entered: " + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
		 * .sendKeys(PropertyManager.getInstance().getStage()); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Opportunity Stagename Entered: " +
		 * PropertyManager.getInstance().getStage());
		 */
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CampaignName)
				.sendKeys(PropertyManager.getInstance().getCampaignName());
		Report.testLog(true, "Opportunity CampaignName Entered: " + PropertyManager.getInstance().getCampaignName());
		DriverClass.elementclick(OpportunityObj.Savebtn);
		DriverClass.waitfor();

		Assertion_Functions.Standard_Opportunity_Negative_Scenario_Validation();

		DriverClass.waitfor();

		/*
		 * String exp = "We hit a snag."; WebElement a = driver.findElement(By.
		 * xpath("//h2[@class='slds-truncate slds-text-heading_medium']")); String act =
		 * a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp,act); Report.testLog(true,
		 * "Standard Opportunity not created:Stage field is not given	");
		 */

	}

	public static void NCP_Corporate_Account_Summaries_Account_Creation()
			throws InterruptedException, AWTException, IOException {
		// Robot robot = new Robot();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		// Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearchCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Searched for: " + PropertyManager.getInstance().getObjectSearchCAS());
		// Action act = New Action(driver);

		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.NewCASbutton);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewCASbutton).click();

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountSummaryNameSearch)
				.sendKeys(PropertyManager.getInstance().getAccountNameCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Account Summary Name: " + PropertyManager.getInstance().getAccountNameCAS());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).click();
	//			.sendKeys(PropertyManager.getInstance().getSearchAccountCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	Report.testLog(true, "Account Name Searched: " + PropertyManager.getInstance().getSearchAccountCAS());
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		Report.testLog(true, "An Account is selection from the suggestions");
		DriverClass.waitfor();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SaveButtonCAS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Corporate Account Summaries:Regional Account Created");

		Assertion_Functions.Corporate_Account_Summaries_Account_Validation();

		// Report.testLog(true, "Corporate Account Summary Account Created");

	}

	public static void TA_Quote_Creation_Negative_Scenario() throws InterruptedException, IOException, AWTException {
		// Robot robot = new Robot();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Opportunity_Test2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : test1769");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NewQuoteBtn).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Selection to create a TA Quote");
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN);
		 */

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.TAQuoteRadioBtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Quote selected :TA Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteName)
				.sendKeys(PropertyManager.getInstance().getQuoteNameTA());
		DriverClass.waitfor();
		Report.testLog(true, "Quote Name entered : " + PropertyManager.getInstance().getQuoteName());

		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.DraftStatus).click();
		// DriverClass.waitfor();

		/*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(OpportunityObj.NoneStatus).click().perform();
		 * Report.testLog(true, "Click on New Status");
		 */
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.StatusO).click();
		DriverClass.waitfor();
		// .sendKeys(PropertyManager.getInstance().getStatusOpp());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.StatusNONE).click();

		/*
		 * robot.keyPress(KeyEvent.VK_UP); robot.keyRelease(KeyEvent.VK_UP);
		 */
		// Actions act = new Actions(driver);
		// act.moveToElement(OpportunityObj.NoneStatus).click().perform();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NoneStatus).sendKeys(Keys.UP);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NoneStatus).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();

		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchAccounts).sendKeys(PropertyManager.getInstance().getSearchAccounts());
		// DriverClass.waitfor();
		// DriverClass.waitfor();
		// Report.testLog(true,"Repreentative Account Name entered : " +
		// PropertyManager.getInstance().getSearchAccounts());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchAccounts).sendKeys(Keys.DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchAccounts).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchContacts).sendKeys(PropertyManager.getInstance().getSearchContacts());
		// DriverClass.waitfor();
		// DriverClass.waitfor();
		// Report.testLog(true, "Contact Name entered : " +
		// PropertyManager.getInstance().getSearchContacts());
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchContacts).sendKeys(Keys.DOWN);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SearchContacts).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		// DriverClass.waitfor();
		Report.testLog(true, "Phone Number entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Notes)
				.sendKeys(PropertyManager.getInstance().getNotes());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Phone Number entered : " + PropertyManager.getInstance().getNotes());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SaveBtn2).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * String exp = "These required fields must be completed: Status"; WebElement a
		 * = driver.findElement(By.
		 * xpath("//li[contains(text(),'These required fields must be completed: Status')]"
		 * )); String act = a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp,act); Report.testLog(true,
		 * "TA Quote not created:Status field is not given");
		 */

		Assertion_Functions.TA_Quote_Negative_Scenario_Validation();

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * OpportunityObj.QuoteNumberTA).click(); DriverClass.waitfor();
		 * DriverClass.waitfor(); Report.testLog(true,
		 * "Navigated into newly created Quote");
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * OpportunityObj.AddProductsQuotes).click(); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * OpportunityObj.SearchprodQuote)
		 * .sendKeys(PropertyManager.getInstance().getProductTAP());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Enter Product name " +
		 * PropertyManager.getInstance().getProductTAP()); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.elementclick(orderObj.prodcheckox);
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Nextbtn2); DriverClass.waitfor();
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_RIGHT);
		 * robot.keyRelease(KeyEvent.VK_RIGHT);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_9);
		 * robot.keyRelease(KeyEvent.VK_9);
		 * 
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * DriverClass.waitfor();
		 * DriverClass.elementclick(OpportunityObj.SaveQuoteProduct);
		 * DriverClass.waitfor();
		 * 
		 * Report.testLog(true,
		 * "Product not added successfully :Ownership status is not assigned");
		 * 
		 * DriverClass.waitfor();
		 */
	}

	public static void FG_Quote_Cloning() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : SampleOpportunity");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.NewQuoteBtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Selection to create a FG Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteName)
				.sendKeys(PropertyManager.getInstance().getQuoteName());
		DriverClass.waitfor();
		Report.testLog(true, "Quote Name entered : " + PropertyManager.getInstance().getQuoteName());
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchAccounts)
		 * .sendKeys(PropertyManager.getInstance().getSearchAccounts());
		 * Report.testLog(true, "Repreentative Account Name entered : " +
		 * PropertyManager.getInstance().getSearchAccounts()); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER); DriverClass.waitfor();
		 */
		/*
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 */

		/*
		 * DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchContacts)
		 * .sendKeys(PropertyManager.getInstance().getSearchContacts());
		 * 
		 * // DriverClass.waitfor(); Report.testLog(true, "Contact Name entered : " +
		 * PropertyManager.getInstance().getSearchContacts()); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); // DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		Report.testLog(true, "Phone Number entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Notes)
				.sendKeys(PropertyManager.getInstance().getNotes());
		DriverClass.waitfor();
		Report.testLog(true, "Notes entered : " + PropertyManager.getInstance().getNotes());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SaveBtn2).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.QuoteNumber).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated into newly created Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddProductsQuotes).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchprodQuote)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.SaveQuoteProduct);

		Report.testLog(true, "Product added successfully is :" + PropertyManager.getInstance().getProduct());

		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(OpportunityObj.QuoteCloneButton);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount)
				.sendKeys(PropertyManager.getInstance().getSearchAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getSearchAccount());
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getSearchAccount(),
		// orderObj.SearchAccount);

		Actions action = new Actions(driver);

		DriverClass.elementclick(orderObj.AccountCheckBox);
		Report.testLog(true, "Account selection for cloning the quote");
		DriverClass.waitfor();
		DriverClass.waitfor();

		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.CloneButton);
		DriverClass.waitfor();

		driver.switchTo().alert().accept();
		DriverClass.waitfor();
		Report.testLog(true, "Closing the popup page");

		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * DriverClass.elementclick(orderObj.CloneCancelButton); DriverClass.waitfor();
		 */

		DriverClass.elementclick(orderObj.NotificationIcon);
		DriverClass.waitfor();
		Report.testLog(true, "Navigation to cloned quote");

		Assertion_Functions.Cloning_Quote_Validation();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.SuccessfulCloning);
		// Report.testLog(true, "Cloning is successful");
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	// NEW
	public static void addSpecialistRole() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPSALES);
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "account" + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AddMemberBtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser)
				.sendKeys(PropertyManager.getInstance().getSpecialistUserName());
		Report.testLog(true, "user:" + PropertyManager.getInstance().getSpecialistUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Searchuser).sendKeys(Keys.ENTER);
		Report.testLog(true, "User Entered : " + PropertyManager.getInstance().getSpecialistUserName());
		System.out.println(PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole)
				.sendKeys(PropertyManager.getInstance().getArRole());
		Report.testLog(true, "Role Entered : " + PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Userrole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Assertion_Functions.aRolesValidation();
	}

	public static void createEvent() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.elementclick(setupObj.calendarObject);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.newEvent).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.subjectOfEvent).sendKeys("Call");
		DriverClass.waitTillElementTobeClickable(driver, setupObj.call).click();
		Report.testLog(true, "Subject : Call");
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, setupObj.meetingType).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.inPerson).click();
		Report.testLog(true, "meeting type : In person");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, setupObj.locationOfEvent).sendKeys("hall");
		Report.testLog(true, "Location: hall");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		Assertion_Functions.eventValidation();

	}

	public static void createTask() throws InterruptedException, AWTException, IOException {

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Tasksobject);
		// DriverClass.elementclick(setupObj.taskObject);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Actionbutton);
		// DriverClass.elementclick(setupObj.newTask);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Newtask);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.Nextbtn2).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.subjectOfEvent).sendKeys("Email");
		Report.testLog(true, "Subject added Successfully");
		DriverClass.waitTillElementTobeClickable(driver, setupObj.email).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDateObj).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date added Successfully");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Assertion_Functions.taskValidation();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * setupObj.locationOfEvent).sendKeys("Space");
		 * 
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeClickable(driver,
		 * accountObj.SavebtnMember).click();
		 */

	}

	public static void Change_Owner_of_Standard_Opportunity() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		// Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		Report.testLog(true, "Navigated to Oppotunity Object");
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		/*
		 * DriverClass.elementclick(OpportunityObj.CloseDate); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(OpportunityObj.Today); DriverClass.waitfor();
		 */
		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.CloseDate2).sendKeys(PropertyManager.getInstance().getCloseDateOp());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "Opportunity Accountname Entered: " + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.CampaignName).sendKeys(PropertyManager.getInstance().getCampaignName());
		// Report.testLog(true, "Opportunity CampaignName Entered: " +
		// PropertyManager.getInstance().getCampaignName());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Closedate Entered: Today");

		DriverClass.elementclick(OpportunityObj.Savebtn);

		Assertion_Functions.Standard_Opportunity_Creation_Validation();

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.ChangeOwnerbtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner)
				.sendKeys(PropertyManager.getInstance().getNewOwner());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.OwnerSubmit);
		DriverClass.waitfor();

		Report.testLog(true, "Owner Name Entered: " + PropertyManager.getInstance().getNewOwner());
		DriverClass.waitfor();

	}

	public static void TAPOrderForEventsCreationNegativeScenario()
			throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.todayDate).click();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.Orderdate).sendKeys(PropertyManager.getInstance().getOrderDate());
		// Report.testLog(true, "Enter Order Date " +
		// PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();

		Assertion_Functions.TAP_Order_Events_Negative_Scenario_Validation();

		// Report.testLog(true, "TAP will not be created as Sample Account is not
		// selected");
		DriverClass.waitfor();

	}

	public static void editAccountStatus() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameCMSV).click();
		Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
		DriverClass.waitfor();
		DriverClass.waitfor();
		// Actions action = new Actions(driver);
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccountStatusbtn).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountStatusdropdown).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
//			Actions act = new Actions(driver);
//			act.moveToElement()

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountStatusdropdown).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountStatusdropdown).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountStatusdropdown).sendKeys(Keys.ENTER);

//			robot.keyPress(KeyEvent.VK_UP);
//			robot.keyRelease(KeyEvent.VK_UP);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			robot.keyRelease(KeyEvent.VK_ENTER);

		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.NCPAccountStatusNone).sendKeys(PropertyManager.getInstance().getNcpAccountStatusNone());
		// DriverClass.waitfor();
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Status edited to : None ");
		// Report.testLog(true, "Termination Reason is : Null");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();
		// Report.testLog(true, "Error : These required fields must be completed: NCP
		// Account Status");
		Assertion_Functions.EditAccountStatusNone();
		Assertion_Functions.EditAccountStatusNone1();
		DriverClass.waitfor();

	}

	public static void addManagerRoleFoodService() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getErAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getErAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getManagerUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon1).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addManagerRoleFoodServicenegativescenario()
			throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES); DriverClass.waitfor();
		 */
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getErAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getErAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getManagerUserName1());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getISARUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.Cancelbutton).click();
		DriverClass.waitfor();

		Report.testLog(true, "User Role will not be added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void addNAERoleMarketPlace() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getNAERole());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.UP);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getNAERole());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addManagerRoleMarketPlace() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getManagerUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role will not be added");

	}

	public static void addNotesCreationinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Opportunity_Test2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : test1769");
		DriverClass.elementclick(homeObj.NotesLink);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NewNotesButton);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.NotesTitle)
				.sendKeys(PropertyManager.getInstance().getNotesTitle());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.NotesData)
				.sendKeys(PropertyManager.getInstance().getNotesData());
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.NotesSubmit);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Notes added : " + PropertyManager.getInstance().getNotesTitle());

	}

	public static void textfileUploadinOpportunity() throws InterruptedException, AWTException, IOException {
		Actions action = new Actions(driver);
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Opportunity_Test2).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : Test1769");

		// action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FilesDD).click();
		DriverClass.waitfor();
		Report.testLog(true, "Files option selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddFiles).click();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Files");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.checkbox).click();
		DriverClass.waitfor();
		action.click(OpportunityObj.AddSampleFile).build().perform();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeClickable(driver,
		// OpportunityObj.AddSampleFile);
		Report.testLog(true, " File uploaded ");

	}

	public static void qaSurveyCreation() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch3());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.QASurvey).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.QASurveyNew).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to QA Survey");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.QASurveyAccountSearch)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.QASurveyAccountSearch).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.QASurveyAccountSearch).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Selected :" + PropertyManager.getInstance().getAccountname());

		DriverClass.waitTillElementTobeVisible(driver, homeObj.QASurveyVenuesSearch)
				.sendKeys(PropertyManager.getInstance().getVenueName());
		DriverClass.waitfor();
		act.moveToElement(homeObj.VenueSelection).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,homeObj.QASurveyVenuesSearch).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,homeObj.QASurveyVenuesSearch).sendKeys(Keys.ENTER);
		Report.testLog(true, "Venue Selected :" + PropertyManager.getInstance().getVenueName());
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.QASurveyDateSearch).click();
		// .sendKeys(PropertyManager.getInstance().getQASurveyDate());
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		// Report.testLog(true, "Date Selected :" +
		// PropertyManager.getInstance().getQASurveyDate());
		// DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralPlexiCube).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralPlexiCube).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralPlexiCube).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralBrandedHotCup).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandedHotCup).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandedHotCup).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralBrandedHPlasticCup).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandedHPlasticCup).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandedHPlasticCup).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralBrandMarketingCurrent).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandMarketingCurrent).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralBrandMarketingCurrent).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralMenuBoard).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralMenuBoard).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralMenuBoard).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralOperatorWebsite).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralOperatorWebsite).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralOperatorWebsite).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralPOSOrderArea).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralPOSOrderArea).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralPOSOrderArea).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralOnlySBUXBeverages).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralOnlySBUXBeverages).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralOnlySBUXBeverages).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.GeneralCustomerExperience).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralCustomerExperience).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.GeneralCustomerExperience).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeClickable(driver, homeObj.QASurveySaveButton).click();
		Report.testLog(true, " QA Survey Record Created ");
		DriverClass.waitfor();

	}

	public static void qaSurveyPDFGeneration() throws InterruptedException, AWTException, IOException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch3());
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.QASurvey).click().perform();
		Report.testLog(true, "Navigated to QA Survey");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExistingQASurvey).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.createPDFbutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, " QA Survey PDF Created ");

	}

	public static void reportCreation() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(reportObj.Reportlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, " Navigated to Report tab ");

		DriverClass.waitTillElementTobeVisible(driver, reportObj.NewReport).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, " Clicked on New Report Button ");

		// DriverClass.waitTillElementTobeVisible(driver,
		// reportObj.SearchReportType).click();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title = 'Report Builder']")));
	//	DriverClass.waitTillElementTobeVisible(driver, reportObj.ReportContinueButton).click();
		DriverClass.waitfor();
		Report.testLog(true, " Selected the Account for the Report ");
		
		DriverClass.waitTillElementTobeVisible(driver, reportObj.ReportType).click();
		DriverClass.waitfor();
		Report.testLog(true, " Selected the Accounts as the Report type");
		
		DriverClass.waitTillElementTobeVisible(driver, reportObj.StartReportBtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, reportObj.ReportSavebutton).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, reportObj.SaveReport).click();
		DriverClass.waitfor();
		Report.testLog(true, " New Report got saved ");

	}

	public static void Average_Days_to_Convert() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.ReportsLink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Reports Object");
		DriverClass.elementclick(homeObj.AllReports);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to All Reports");
//	DriverClass.elementclick(homeObj.SearchReports);
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SearchReports)
				.sendKeys(PropertyManager.getInstance().getReportsAvgDateToConvert());
		DriverClass.waitfor();
		Report.testLog(true, "Searched for Converted Leads");
		DriverClass.elementclick(homeObj.ConvertedLeads);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Converted Leads");
		Report.testLog(true, "Average Days to convert field is added in the converted leads");
	}

	public static void Equipment_Provided_ReadOnly_Field() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		Report.testLog(true, "Searched for SAP Account");

		DriverClass.elementclick(accountObj.sapAccount);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "NAvigated to  SAP Account");
		Actions act = new Actions(driver);
		DriverClass.elementclick(accountObj.sapAccountEdit);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ViewAD);
		DriverClass.waitfor();

		DriverClass.elementclick(accountObj.EquipmentProvidedDD);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EquipmentProvidedDD).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EquipmentProvidedDD).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.Applybutton);
		DriverClass.waitfor();

		DriverClass.elementclick(accountObj.Savebutton);
		DriverClass.waitfor();
		Assertion_Functions.EquipmentProvidedErrorValidation();
		DriverClass.waitfor();

		// act.doubleClick(accountObj.EquipmentProvided).build().perform();

	}

//Adding Sr.manager in FS channel

	public static void addSrManagerRoleFoodService() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getErAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getErAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole)
				.sendKeys(PropertyManager.getInstance().getSrManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getSrManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addSpecialistRoleFoodService() throws InterruptedException, AWTException, IOException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		// DriverClass.waitfor();
		// DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getErAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getErAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getSpecialistUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		// .sendKeys(PropertyManager.getInstance().getArRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getArRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addSrManagerRoleMarketPlace() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole)
				.sendKeys(PropertyManager.getInstance().getSrManagerTeamRole());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getSrManagerTeamRole());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void addSpecialistRoleMarketPlace() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_Evans);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		/*
		 * DriverClass.elementclick(homeObj.Objectsearch); DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NCPSALES);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getArAccountName());
		Report.testLog(true, "Account : " + PropertyManager.getInstance().getArAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.erAccount).click();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.AccountTeamlink).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.ManageTeam).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.addTeamMember).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchUserFS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, accountObj.teamMemberRole).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.teamMemberRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.SavebtnMember).click();
		DriverClass.waitfor();
		Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getSPROLE());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberIcon).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DeleteTeamMemberButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

	public static void FGSampleOrderCreation() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGSampleCheckox);
		Report.testLog(true, "FG SAmple Order is selcted");

		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());

		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		/*
		 * DriverClass.elementclick(orderObj.quantitySearch); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.qtyInput)
		 * .sendKeys(PropertyManager.getInstance().getQuantity());
		 * DriverClass.waitfor(); // Assertion_Functions.OrderCreation_Validation();
		 * DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();

		/*
		 * DriverClass.waitfor(); String Orderno2 =
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor(); //
		 * Assertion_Functions.OrderSubmitValidation();
		 * 
		 * // validation for submission Report.testLog(true,
		 * "Order number sent for Submission is :" + Orderno2); DriverClass.waitfor();
		 */
	}

//Dashboard Creation

	public static void Dashboard_Creation() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearchDashboard());
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(dashboardObj.Dashboard).click().perform();
		DriverClass.waitfor();
		DriverClass.elementclick(dashboardObj.NewDashboard);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title = 'dashboard'])[2]")));
		// DriverClass.elementclick(dashboardObj.NameNewDashboard);
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.NameNewDashboard)
				.sendKeys(PropertyManager.getInstance().getDashboard());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Dashboard name :" + PropertyManager.getInstance().getDashboard());

		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.DashboardCreatebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title = 'dashboard'])[3]")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.AddComponent).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.AllReports).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Selected All Reports ");
		// driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@title =
		// 'dashboard'])[2]")));
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.SelectDashboardReport).click();
		Report.testLog(true, "Selected Account List from All Reports ");
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.Selectbutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.Addbutton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.closealert).click();

		// Alert alt = new Alert(driver);
		// driver.switchTo().alert().dismiss();
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.Savebutton).click();
		DriverClass.waitfor();

		Report.testLog(true, "Dashboard Saved ");
		DriverClass.waitTillElementTobeVisible(driver, dashboardObj.Donebutton).click();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, dashboardObj.DropdownDashboard).click();
//	DriverClass.waitTillElementTobeVisible(driver, dashboardObj.DeleteDashboard).click();
//	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, dashboardObj.deletepopupDashboard).click();
//	
//	DriverClass.waitTillElementTobeVisible(driver, dashboardObj.SaveDashboard).click();

		// Report.testLog(true, "Enter Contract name " +
		// PropertyManager.getInstance().getContractName());

	}

	public static void Revenue_Calculator_Creation() throws InterruptedException, IOException, AWTException {
		/*
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * setupObj.NCPSalesLogin).click(); Report.testLog(true,
		 * "Logged in as NCP Sales"); DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent();
		 */

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Opportunity_Test2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : test1769");
		// DriverClass.elementclick(homeObj.RevenueCalculatorLink);

		/*
		 * DriverClass.elementclick(homeObj.NewRevenueCalculatorDropdown);
		 * DriverClass.waitfor();
		 * DriverClass.elementclick(homeObj.NewRevenueCalculator);
		 * DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.RevCal);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NewRevCal);
		DriverClass.waitfor();

//			DriverClass.waitfor();
//			DriverClass.elementclick(homeObj.NewRC);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SBUXUnits)
				.sendKeys(PropertyManager.getInstance().getSBUXUnits());

		Report.testLog(true, "SBUX Units entered: " + PropertyManager.getInstance().getSBUXUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FrappuccinoUnits)
				.sendKeys(PropertyManager.getInstance().getFrappuccinoUnits());

		Report.testLog(true, "Frappuccino Units entered: " + PropertyManager.getInstance().getFrappuccinoUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SyrupsandSauces)
				.sendKeys(PropertyManager.getInstance().getSyrupsandsauces());

		Report.testLog(true, "Syrups&sauces Units entered: " + PropertyManager.getInstance().getSyrupsandsauces());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.NonDairyUnits)
				.sendKeys(PropertyManager.getInstance().getNonDairyUnits());

		Report.testLog(true, "Non Dairy Units entered: " + PropertyManager.getInstance().getNonDairyUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.RefreshersUnits)
				.sendKeys(PropertyManager.getInstance().getRefreshersUnits());

		Report.testLog(true, "Refresher Units entered: " + PropertyManager.getInstance().getRefreshersUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TeavanaHotUnits)
				.sendKeys(PropertyManager.getInstance().getTeavanaHotUnits());

		Report.testLog(true, "Teavana Hot Units entered: " + PropertyManager.getInstance().getTeavanaHotUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TeavanaColdUnits)
				.sendKeys(PropertyManager.getInstance().getTeavanaColdUnits());

		Report.testLog(true, "Teavana Cold Units entered: " + PropertyManager.getInstance().getTeavanaColdUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SBCUnits)
				.sendKeys(PropertyManager.getInstance().getSBCUnits());

		Report.testLog(true, "SBC Units entered: " + PropertyManager.getInstance().getSBCUnits());
		// DriverClass.waitTillElementTobeVisible(driver,
		// homeObj.SBCLiquidCoffee).sendKeys(PropertyManager.getInstance().getSBCLiquidCoffee());

		// Report.testLog(true, "SBC Liquid Coffee entered: " +
		// PropertyManager.getInstance().getSBCLiquidCoffee());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ChameleonKegs)
				.sendKeys(PropertyManager.getInstance().getChameleonKegs());

		Report.testLog(true, "Chameleon Kegs entered: " + PropertyManager.getInstance().getChameleonKegs());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ChameleonBIB)
				.sendKeys(PropertyManager.getInstance().getChameleonBIB());

		Report.testLog(true, "Chameleon BIB entered: " + PropertyManager.getInstance().getChameleonBIB());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ChameleonWholeBean)
				.sendKeys(PropertyManager.getInstance().getChameleonWholeBean());

		Report.testLog(true, "ChameleonWholeBean entered: " + PropertyManager.getInstance().getChameleonWholeBean());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SelectUnits)
				.sendKeys(PropertyManager.getInstance().getSelectUnits());

		Report.testLog(true, "Select Units entered: " + PropertyManager.getInstance().getSelectUnits());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.KcupUnits)
				.sendKeys(PropertyManager.getInstance().getKcupUnits());

		Report.testLog(true, "K-cup Units entered: " + PropertyManager.getInstance().getKcupUnits());
		DriverClass.elementclick(homeObj.SaveRC);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Revenue Calculator created");
		DriverClass.elementclick(homeObj.QuoteCheckListView);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.RevenueDD);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.DeleteRC);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.DeleteRevCal);
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

//NCP Evergreen Contract cloning Test cases

	public static void Cloning_NCP_Evergreen_Contract() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(contractObj.NewContractBtn);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contractObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractName)
				.sendKeys(PropertyManager.getInstance().getContractName());
		Report.testLog(true, "Enter Contract name " + PropertyManager.getInstance().getContractName());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName).sendKeys(Keys.DOWN);
		/*
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 */
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName).sendKeys(Keys.ENTER);
		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.Description)
				.sendKeys(PropertyManager.getInstance().getDescription());
		Report.testLog(true, "Enter Description " + PropertyManager.getInstance().getDescription());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType)
				.sendKeys(PropertyManager.getInstance().getContractType());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.ENTER);
		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Type " + PropertyManager.getInstance().getContractType());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractStartDate).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		// .sendKeys(PropertyManager.getInstance().getContractDate());
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Start Date " + PropertyManager.getInstance().getContractDate());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.EquipmentNotes)
				.sendKeys(PropertyManager.getInstance().getEquipmemntNotes());
		DriverClass.waitfor();
		Report.testLog(true, "Enter Equipment Note :  " + PropertyManager.getInstance().getEquipmemntNotes());

		DriverClass.waitTillElementTobeVisible(driver, contractObj.SaveContact).click();
		DriverClass.waitfor();
	//	Assertion_Functions.Add_Contract_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contractObj.EGClone).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contractObj.EGCloneSave).click();
		DriverClass.waitfor();
		Report.testLog(true, "Evergreen contract cloning is successful");

	}

	public static void NCP_Corporate_Account_Summaries_National_Account_Creation()
			throws InterruptedException, AWTException, IOException {
		// Robot robot = new Robot();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesNAE).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearchCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Searched for: " + PropertyManager.getInstance().getObjectSearchCAS());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.NewCASbutton);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewCASbutton).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.NationalAccountSummary).click();
		DriverClass.waitfor();
		Report.testLog(true, "Record type selected: NationalAccountSummary");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NextbuttonNAS).click();
		DriverClass.waitfor();

//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountSummaryNameSearch)
				.sendKeys(PropertyManager.getInstance().getAccountNameCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Account Summary Name: " + PropertyManager.getInstance().getAccountNameCAS());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS)
				.sendKeys(PropertyManager.getInstance().getSearchAccountCAS());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Account Name Searched: " + PropertyManager.getInstance().getSearchAccountCAS());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountNameSearchCAS).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SaveButtonCAS);
		DriverClass.waitfor();
		DriverClass.waitfor();

		Assertion_Functions.Corporate_Account_Summaries_Account_Validation();

	}

	public static void TAR_Order_For_Events() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventsCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
//	Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");

//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Status).sendKeys(PropertyManager.getInstance().getStatus());
//	DriverClass.waitfor();
//	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);

		/*
		 * DriverClass.elementclick(orderObj.Orderdate); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.SelectDate); DriverClass.waitfor();
		 */

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.AddTradeAssets);
		Report.testLog(true, "Clicked on Add Trade Assets ");
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.TAREventSelected);
		Report.testLog(true, "TAR Event is selected ");
		DriverClass.elementclick(orderObj.TARSave);
		DriverClass.waitfor();
		Report.testLog(true, "Trade Asset is Added Successfully");

	}

	public static void NCP_TAP_Order_Creation_Negative_Scenario_Without_Ownership_status()
			throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		Report.testLog(true, "Click on New Order Button");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		Report.testLog(true, "Select TAP Order Check box");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		Report.testLog(true, "Click on Next Button");
		DriverClass.waitfor();
		// Robot robot = new Robot();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);

		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();
		// Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter Retrieval Installation" + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		Report.testLog(true, "Click on Add Product Button");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();

		/*
		 * String exp = "These required fields must be completed: Phone"; WebElement a =
		 * driver.findElement(By.
		 * xpath("//li[contains(text(), 'These required fields must be completed: Phone')]"
		 * )); String act = a.getText(); System.out.println("Error Message is: " + act);
		 * Assert.assertEquals(exp,act); Report.testLog(true,
		 * "TAP Order not created:Phone field not filled");
		 */

		Assertion_Functions.TAP_Order_Negative_Scenario_Without_Ownership_status();

	}

	public static void TAPOrderForEventsCreationNegativeScenarioWithoutOwnershipstatus()
			throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter Retrieval Installation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.PhonenumTAP)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipBtn).click();
		// act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
//	DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
//	Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();

		Assertion_Functions.TAP_Order_Events_Negative_Scenario_Without_Ownership_status();

		// Report.testLog(true, "TAP will not be created as Sample Account is not
		// selected");
		DriverClass.waitfor();

	}

	public static void Create_Related_Account_In_Account() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameMember).click();
		DriverClass.waitfor();
		
		if(DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).isDisplayed()) {
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).click();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccounts).click();
		}else {
			DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccounts).click();
		}
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.ShowAllLink).click(); Report.testLog(true,
		 * "Click on Show All under Quick links section"); // Report.testLog(true,
		 * "Navigated to Account :" + //
		 * PropertyManager.getInstance().getOrderAccount()); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.RelatedAccounts).click(); DriverClass.waitfor();
		 */
		Report.testLog(true, "Navigated to Related Accounts Page");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewVenueBtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Button on Related Accounts page");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NextBtnRelatedAccounts).click();
		DriverClass.waitfor();
		Report.testLog(true, "Click on Next button on New Related Account pop-up");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SearchAccountsReport)
				.sendKeys(PropertyManager.getInstance().getSearchAccountTest());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SearchAccountsReport).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SearchAccountsReport).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Related Account : " + PropertyManager.getInstance().getSearchAccount());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BroadlinerCustNumber)
				.sendKeys(PropertyManager.getInstance().getBroadlinerCustNum());
		DriverClass.waitfor();
		Report.testLog(true,
				"User Broadliner Customer Number : " + PropertyManager.getInstance().getBroadlinerCustNum());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).sendKeys(Keys.ENTER);
		Report.testLog(true, "Set Distributor Active as Yes and Save");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.SavebtnReport).click();
		DriverClass.waitfor();
		Report.testLog(true, "Related Account is Created");

	}

	public static void addingSpecialistAsTeamMemberinOpportunity()
			throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

		// action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getArRole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.Specialist).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
		// Report.testLog(true, "User Role added : " +
		// PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddSpecialistTeamMemberOpportunity();

	}

//Function to create a lead with negative scenario
	public static void LeadsCreationNewCustomerLeadIntakeNegativeScenario() throws InterruptedException, IOException {

		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead option.");
		DriverClass.elementclick(leadsObj.NewCustomerLeadIntake);
		DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(), leadsObj.Salutation);
		Report.testLog(true, "Salutation entered:" + PropertyManager.getInstance().getSalutation());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
//		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
//		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getState(), leadsObj.state);
		Report.testLog(true, "state entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.savebtn);
		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsIntakeCreationValidation();
	}

	public static void Corporate_Opportunity_Creation_Negative_Scenario()
			throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.elementclick(OpportunityObj.CorporateRecordType);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType).sendKeys(Keys.ENTER);

		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.CloseDate).sendKeys(PropertyManager.getInstance().getCloseDate());
		// Report.testLog(true, "Opportunity Closedate Entered: " +
		// PropertyManager.getInstance().getCloseDate());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true,
				"Opportunity Accountname Entered: " + PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource).sendKeys(Keys.ENTER);

		DriverClass.waitfor();

		DriverClass.elementclick(OpportunityObj.Savebtn);
		DriverClass.waitfor();
		// Report.testLog(true, "Corporate Opportunity is not created as close date is
		// not given ");

		Assertion_Functions.Corporate_Opportunity_Creation_Negative_Validation();
		DriverClass.waitfor();
	}

	public static void Change_Owner_Corporate_Opportunity_Creation()
			throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		// Robot robot = new Robot();
		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());

		// .sendKeys(PropertyManager.getInstance().getCloseDate());
		Report.testLog(true, "Opportunity Closedate Entered: " + PropertyManager.getInstance().getCloseDate());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true,
				"Opportunity Accountname Entered: " + PropertyManager.getInstance().getCorporateAccountname());
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.Savebtn);

		DriverClass.waitfor();
		Report.testLog(true, "Corporate Opportunity created ");

		// Assertion_Functions.Corporate_Opportunity_Creation_Validation();
		DriverClass.waitfor();

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.ChangeOwnerbtn);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner)
				.sendKeys(PropertyManager.getInstance().getNewOwner());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.OwnerSubmit);
		DriverClass.waitfor();
		Report.testLog(true, "Owner changed to " + PropertyManager.getInstance().getNewOwner());

	}

//////////////////**********Cloning Corporate Opportunity************/////////////////

	public static void Cloning_Corporate_Opportunity() throws InterruptedException, AWTException, IOException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.elementclick(OpportunityObj.CorporateRecordType);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType).sendKeys(Keys.ENTER);

		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());

		// .sendKeys(PropertyManager.getInstance().getCloseDateOp());

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true,
				"Opportunity Accountname Entered: " + PropertyManager.getInstance().getCorporateAccountname());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Closedate Entered: Today");
		DriverClass.elementclick(OpportunityObj.Savebtn);
		DriverClass.waitfor();
		Report.testLog(true, "Corporate Opportunity created ");

// Assertion_Functions.Corporate_Opportunity_Creation_Validation();

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.CloneButtonStandard);
		DriverClass.waitfor();
		Report.testLog(true, "Clone button is clicked");
		DriverClass.elementclick(OpportunityObj.CloneSaveStandard);
		DriverClass.waitfor();
		Report.testLog(true, "Cloning is successful");

	}

/////////////////////**************Cloning Standard Opportunity***********//////////////////

	public static void Standard_Opportunity_Cloning() throws InterruptedException, AWTException, IOException {
//Robot robot = new Robot();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		Report.testLog(true, "Navigated to Oppotunity Object");
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NewBtn);
		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.NextBtn);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityName)
				.sendKeys(PropertyManager.getInstance().getOpportunityName());
		Report.testLog(true, "Opportunity Name Entered: " + PropertyManager.getInstance().getOpportunityName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType)
				.sendKeys(PropertyManager.getInstance().getOpportunityType());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityType).sendKeys(Keys.ENTER);

		Report.testLog(true, "Opportunity Type Entered: " + PropertyManager.getInstance().getOpportunityType());
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.CloseDate).sendKeys(PropertyManager.getInstance().getCloseDateOp());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "Opportunity Accountname Entered: " + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Accountname).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Stagename).sendKeys(Keys.ENTER);

		Report.testLog(true, "Opportunity Stagename Entered: " + PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource)
				.sendKeys(PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.LeadSource).sendKeys(Keys.ENTER);

		Report.testLog(true, "Opportunity LeadSource Entered: " + PropertyManager.getInstance().getLeadsource());
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CampaignName).sendKeys(PropertyManager.getInstance().getCampaignName());
//	Report.testLog(true, "Opportunity CampaignName Entered: " + PropertyManager.getInstance().getCampaignName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.CloseDate).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Closedate Entered:Today ");
		DriverClass.elementclick(OpportunityObj.Savebtn);

		Assertion_Functions.Standard_Opportunity_Creation_Validation();

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.CloneButtonStandard);
		DriverClass.waitfor();
		Report.testLog(true, "Clone button is clicked");
		DriverClass.elementclick(OpportunityObj.CloneSaveStandard);
		DriverClass.waitfor();
		Report.testLog(true, "Cloning is successful");

	}

////////////////////*****************Related Contacts Creation******************/////////////////

	public static void RelatedContacts_Creation() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameMember).click();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.RelatedContactslink);
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.NewContactButton);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ContactLastName)
				.sendKeys(PropertyManager.getInstance().getContactLastName());
		DriverClass.waitfor();
		Report.testLog(true, "Last Name entered:" + PropertyManager.getInstance().getContactLastName());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ContactPhone)
				.sendKeys(PropertyManager.getInstance().getContactPhone());
		DriverClass.waitfor();
		Report.testLog(true, "Phone entered:" + PropertyManager.getInstance().getContactPhone());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ContactEmail)
				.sendKeys(PropertyManager.getInstance().getContactEmail());
		DriverClass.waitfor();
		Report.testLog(true, "Email entered:" + PropertyManager.getInstance().getContactEmail());
		DriverClass.elementclick(homeObj.ContactSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Contact saved");
	}

///// Adding NAE as Team Member in Opportunity //////

	public static void addingNAEAsTeamMemberinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

		// action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getNAERole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.NAE).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
		// Report.testLog(true, "User Role added : " +
		// PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddNAETeamMemberOpportunity();

	}

///// Adding ISAR Role as Team Member in Opportunity ////////

	public static void addingISARAsTeamMemberinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.NCPSalesLogin);
		Report.testLog(true, "Logged in as NCP sales Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

		// action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getISARTeamRole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.ISAR).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
		// Report.testLog(true, "User Role added : " +
		// PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddISARTeamMemberOpportunity();

	}

///// Adding Sr Manager as Team Member in opportunity /////////////

	public static void addingSrManagerAsTeamMemberinOpportunity()
			throws InterruptedException, AWTException, IOException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

		// action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getSrManagerTeamRole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.SrManager).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
		// Report.testLog(true, "User Role added : " +
		// PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddSrManagerTeamMemberOpportunity();

	}

///// Adding Manager as Team Member in opportunity /////////////

	public static void addingManagerAsTeamMemberinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

//action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getManagerTeamRole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.Manager).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
//Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddManagerTeamMemberOpportunity();

	}

///// Adding Lead as Team Member in opportunity /////////////

	public static void addingLeadAsTeamMemberinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

//action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getLeadRole());
//DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
//DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.Lead).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
//Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Assertion_Functions.AddLeadTeamMemberOpportunity();

	}

///// Removing All Members from opportunity /////////////

	public static void removeAllMemberinOpportunity() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SampleOpportunity).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity selected : sampleOpportunity");

//action.sendKeys(Keys.PAGE_DOWN).build().perform();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.OpportunityTeam).click();
		DriverClass.waitfor();
		Report.testLog(true, "Opportunity Team selected");

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddOpportunityTeamMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Add Opportunity Team Members");
//Add NAE Role
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole).click();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getNAERole());
		// DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.SelectTeamRole).click();
		// DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.NAE).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

//click on next row

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamRole1).click();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SelectTeamRole)
				.sendKeys(PropertyManager.getInstance().getLeadRole());
//DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SelectTeamRole).click();
//DriverClass.waitTillElementTobeVisible(driver,OpportunityObj.SelectTeamRole).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
//Actions act = new Actions(driver);
		act.moveToElement(OpportunityObj.Lead).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.AddTeamUser1).click();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers)
				.sendKeys(PropertyManager.getInstance().getUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchUsers).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeClickable(driver, OpportunityObj.SaveBtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Team members are added opportunity team.");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.RemoveAllMembers).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Removebutton).click();
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Remove All Members button");
//Report.testLog(true, "User Role added : " + PropertyManager.getInstance().getArRole());
		DriverClass.waitfor();
		Report.testLog(true, "All the team members are removed from this opportunity team.");
//Assertion_Functions.AddLeadTeamMemberOpportunity();

	}

///// Adding NAE as Team Member in Opportunity //////

	public static void keySalesforcereportsAndDashboardsLinksValidation()
			throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Homepage);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Home Page");
		DriverClass.elementclick(homeObj.TopClosed);
		DriverClass.waitfor();
		// driver.switchTo().frame(homeObj.Reportframe);
		Assertion_Functions.topClosedOpportunities();
//		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Homepage);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.LeadAge);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to lead Age Report");
		DriverClass.waitfor();
		DriverClass.waitfor();
//driver.switchTo().frame(homeObj.Reportframe);
//String opp1= DriverClass.waitTillElementTobeVisible(driver, homeObj.LeadAgePage).getText();
//System.out.println(opp1);
//Assertion_Functions.leadAge(); 
//driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Homepage);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.OpportunityAging);
		DriverClass.waitfor();
//hold all window handles in array list
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
//switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());
		driver.switchTo().frame(homeObj.Reportframe);
		String opp = DriverClass.waitTillElementTobeVisible(driver, homeObj.OpportunityAgingPage).getText();
		System.out.println(opp);
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Report");
//Assertion_Functions.OpportunityAging(); 
//switch to parent window
		driver.switchTo().window(newTb.get(0));
		System.out.println("Page title of parent window: " + driver.getTitle());
//driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Homepage);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.AccountsDashboard);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// driver.switchTo().frame(homeObj.Reportframe);
//Assertion_Functions.accountDashboardPage(); 

		Report.testLog(true, "Navigated to Account Dashboard");

	}

//// TAP Event Order Negative Qunatity Check //////

	public static void TAPEventOrder_Negative_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.PhonenumTAP)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("-2");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Negative_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

///// Change Owner Leads/////

	public static void Change_Owner_Leads() throws InterruptedException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead option.");
//	DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(), leadsObj.Salutation);
		Report.testLog(true, "Salutation entered:" + PropertyManager.getInstance().getSalutation());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getState(),
		// leadsObj.state);
		DriverClass.elementclick(leadsObj.state);
		DriverClass.waitfor();
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();

		Report.testLog(true, "state entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLeadsource(), leadsObj.leadsource);
		Report.testLog(true, "leadsource entered : " + PropertyManager.getInstance().getLeadsource());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getPhone(), leadsObj.phone);
		Report.testLog(true, "phone entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getEmail() + "1", leadsObj.email);
		Report.testLog(true, "email entered : " + PropertyManager.getInstance().getEmail());

		DriverClass.elementclick(leadsObj.viewdep);
		DriverClass.elementclick(leadsObj.channeltwo);
		DriverClass.waitfor();
//	Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Channel entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.regiontwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Region entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.viewdepsegment);
		DriverClass.elementclick(leadsObj.segmenttwo);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Segment Entered :" + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.subsegmenttwo);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Segment Entered :" + PropertyManager.getInstance().getSubsegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.elementsendvalues(PropertyManager.getInstance().getBanner(), leadsObj.Banner);

		DriverClass.elementclick(leadsObj.Banner);
		DriverClass.waitfor();

		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();

		DriverClass.waitfor();
		Report.testLog(true, "Banner Entered :" + PropertyManager.getInstance().getBanner());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFSM(), leadsObj.FSM);
		DriverClass.waitfor();
		Report.testLog(true, "FSM Entered :" + PropertyManager.getInstance().getFSM());
		DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFSMVaIid(), leadsObj.FSMvalidfrom);
		Report.testLog(true, "FSM Date Entered :" + PropertyManager.getInstance().getFSMVaIid());
		DriverClass.waitfor();
//	DriverClass.elementsendvalues(PropertyManager.getInstance().getRoute(), leadsObj.RoutetoMarket);

		DriverClass.elementclick(leadsObj.RoutetoMarket);
		DriverClass.waitfor();

		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();

		Report.testLog(true, "Route Entered :" + PropertyManager.getInstance().getRoute());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getStudentno(), leadsObj.studentno);
		Report.testLog(true, "studentno Entered :" + PropertyManager.getInstance().getStudentno());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getEmployeeno(), leadsObj.employeeno);
		Report.testLog(true, "employeeno Entered :" + PropertyManager.getInstance().getEmployeeno());

		DriverClass.elementclick(leadsObj.savebtn);

		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsCreationValidation();

		DriverClass.elementclick(leadsObj.changeOwnerIcon);
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner)
				.sendKeys(PropertyManager.getInstance().getNewOwner());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.DOWN);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SearchOwner).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		DriverClass.elementclick(OpportunityObj.changeOwnerButton);
		DriverClass.waitfor();
		Report.testLog(true, "Owner changed to " + PropertyManager.getInstance().getNewOwner());

	}

///////////////***********TAP Order Negative quantity**********///////////////////

	public static void TAPOrder_Negative_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();
		// Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter Retrieval Installation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("-2");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		Assertion_Functions.Order_Negative_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

//////////////***************FG Order Negative quantity**********////////////////

	public static void FGOrder_Negative_Quantity_Check() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.FGCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation).sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
//Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("-2");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).
		 * sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).
		 * sendKeys(Keys.ENTER); Report.testLog(true, "Ownership status is: " +
		 * PropertyManager.getInstance().getOwnershipStatus()); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Negative_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

//////////////////*****************FG Order Decimal quantity*********//////////////

	public static void FGOrder_Decimal_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesNAE).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.FGCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation).sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
//Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2.5");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).
		 * sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.OwnershipSelect).
		 * sendKeys(Keys.ENTER); Report.testLog(true, "Ownership status is: " +
		 * PropertyManager.getInstance().getOwnershipStatus()); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Decimal_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}
//////////////////****************TAP Order decimal quantity************///////////

	public static void TAPOrder_Decimal_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();
		// Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter Retrieval Installation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2.5");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		Assertion_Functions.Order_Decimal_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();

	}

/////////////////////*****************TAP Event Decimal quantity*****************///////////////

	public static void TAPEventOrder_Decimal_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesNAE).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter Retrieval Installation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.PhonenumTAP)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2.5");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Decimal_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

////////////****************FG Zero quantity check**************////////////

	public static void FGOrder_Zero_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.FGCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation).sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
//Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("0");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Zero_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void TAP_Order_Zero_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();
		// Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation).sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
//Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum2)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

//DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
//Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("0");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
//DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Zero_Quantity_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void FG_QuoteToOrder_Conversion() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quoteconversionpdf).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : Quoteconversionpdf");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quotes Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotedd).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGConverttoOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// OpportunityObj.OrderAfterConversion).isDisplayed();
		// Report.testLog(true, "Quote is converted to Order");
		Assertion_Functions.FGOrderConversion_Validation();

	}

	public static void ProspectAccountCreationNegative() throws AWTException, InterruptedException, IOException {
		Robot robot = new Robot();
		/*
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * 
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * setupObj.NCPSalesLogin).click(); Report.testLog(true,
		 * "Logged in as NCP Sales"); DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent();
		 */

		DriverClass.elementclick(homeObj.Accountlink);

		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
// robot.keyPress(KeyEvent.VK_ENTER);
// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SubSegmentDep).sendKeys(PropertyManager.getInstance().
		 * getSubsegment()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SubSegmentDep).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * Report.testLog(true, "Account Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment());
		 */
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(accountObj.dependencySegment);
		 * DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver,accountObj.Subsegment).sendKeys
		 * (PropertyManager.getInstance().getSubsegment());
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_DOWN);
		 * robot.keyRelease(KeyEvent.VK_DOWN); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); DriverClass.elementclick(accountObj.Subsegmentapply);
		 * Report.testLog(true, "Acocunt Subsegment Entered : " +
		 * PropertyManager.getInstance().getSubsegment()); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
//DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
//DriverClass.waitfor();

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BannerDep).sendKeys(PropertyManager.getInstance().getBanner());
		 * Report.testLog(true, "Account Banner Entered : " +
		 * PropertyManager.getInstance().getBanner());
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BannerDep).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.elementclick(accountObj.ApplyChannel);
		 */

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		// Report.testLog(true, "Acocunt Created : " +
		// PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();
		Assertion_Functions.ProspectAccountNegativeScenarioValidation();
		DriverClass.waitfor();
		DriverClass.waitfor();
	}

	public static void MassUpdate_Task_Status() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Tasksobject);
		// DriverClass.elementclick(setupObj.taskObject);
		DriverClass.waitfor();
	//	DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.elementclick(homeObj.TasksListView);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch)
				.sendKeys(PropertyManager.getInstance().getTaskListView());
		Report.testLog(true, "List View selected : " + PropertyManager.getInstance().getTaskListView());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task1);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Tasks are selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus)
				.sendKeys(PropertyManager.getInstance().getTaskStatus2());
		Report.testLog(true, "Task Status selected : " + PropertyManager.getInstance().getTaskStatus2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Status is updated");
		DriverClass.elementclick(homeObj.Task1);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Tasks are selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus)
				.sendKeys(PropertyManager.getInstance().getTaskStatus1());
		Report.testLog(true, "Task Status selected : " + PropertyManager.getInstance().getTaskStatus1());

		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Status is updated");
	}

	public static void Dependency_BrewOnly_PreScheduledVenue() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.sapAccount);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.EditAccount);
		DriverClass.waitfor();
		DriverClass.waitfor();

		if (DriverClass.waitTillElementTobeVisible(driver, accountObj.SBUXActivecb).isSelected()) {
			/*
			 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
			 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
			 */
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS).click();
			Actions act = new Actions(driver);
			act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
			Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.Savebutton);

		} else {
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SBUXActivecb).click();
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS).click();
			Actions act = new Actions(driver);
			act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
			Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.Savebutton);
		}
		DriverClass.waitfor();
		Assertion_Functions.BrewOnlyErrorValidation();
		DriverClass.waitfor();
	}

	public static void FG_QuoteToPdf_Conversion() throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quoteconversionpdf).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : Quoteconversionpdf");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quotes Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotedd).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGConverttopdfButton).click();
		DriverClass.waitfor();
		Report.testLog(true, "Quote Preview is displayed");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Createpdfbutton).click();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is created");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SavetoQuotebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is saved to Quote");

	}

	public static void Dependency_Espresso_PreScheduledVenue() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.sapAccount);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.EditAccount);
		DriverClass.waitfor();
		DriverClass.waitfor();

		if (DriverClass.waitTillElementTobeVisible(driver, accountObj.SBUXActivecb).isSelected()) {
			/*
			 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
			 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
			 */
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.EspressoPPS).click();
			Actions act = new Actions(driver);
			act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
			Report.testLog(true, "SBUX Espresso Portion pack size is changed to None");
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.Savebutton);

		} else {
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SBUXActivecb).click();
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.EspressoPPS).click();
			Actions act = new Actions(driver);
			act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
			Report.testLog(true, "SBUX Espresso Portion pack size is changed to None");
			// DriverClass.waitTillElementTobeVisible(driver,
			// accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.Savebutton);
		}
		DriverClass.waitfor();
		Assertion_Functions.EspressoErrorValidation();
		DriverClass.waitfor();
	}

	public static void MassUpdate_Task_AssignedTo() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(homeObj.Tasksobject);
		// DriverClass.elementclick(setupObj.taskObject);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.TasksListView);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch)
				.sendKeys(PropertyManager.getInstance().getTaskListView());
		Report.testLog(true, "List View selected : " + PropertyManager.getInstance().getTaskListView());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task1);

		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Task is selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AssignedToSearch)
				.sendKeys(PropertyManager.getInstance().getISARUserName());
		Report.testLog(true, "User selected : " + PropertyManager.getInstance().getISARUserName());
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.RakeshSaraUser).click().perform();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// homeObj.TaskStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned to new user");
		DriverClass.elementclick(homeObj.Task1);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Task is selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AssignedToSearch)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		Report.testLog(true, "Assigned to : " + PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		act.moveToElement(homeObj.JosephDohenyIII).click().perform();
		// DriverClass.waitTillElementTobeVisible(driver,
		// homeObj.TaskStatus).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned back to original user");
	}

	public static void Add_Related_Bill_To_Account() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.AccountsListView);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.AllAccounts);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getProspectAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getProspectAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ProspectAccount);
		DriverClass.waitfor();
		// Report.testLog(true, "Account selected:" +
		// PropertyManager.getInstance().getAccountname());
		// DriverClass.elementclick(accountObj.ShowAllLink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).click();
		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.RelatedAccounts);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccounts).click();
		// DriverClass.elementclick(accountObj.RelatedAccountslink);
		// DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.RelatedAccountsdd);
		Report.testLog(true, "Navigated to Related Accounts");
		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.NewBtnRelatedAccountsdd);
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewBtnRelatedAccounts).click();
		// DriverClass.elementclick(accountObj.NewBtnRelatedAccounts);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.NCPOnBoardingBillTo);
		DriverClass.waitfor();
		Report.testLog(true, "Record type selected: NCP Onboarding Bill To");
		DriverClass.elementclick(accountObj.NextBtnRelatedAccounts);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToAccountName)
				.sendKeys(PropertyManager.getInstance().getBillToAccountName());
		Report.testLog(true, "Account name:" + PropertyManager.getInstance().getBillToAccountName());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToStreet)
				.sendKeys(PropertyManager.getInstance().getBillToStreet());
		Report.testLog(true, "Street name:" + PropertyManager.getInstance().getBillToStreet());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToCity)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "City name:" + PropertyManager.getInstance().getCity());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToZip)
				.sendKeys(PropertyManager.getInstance().getBillToZip());
		Report.testLog(true, "Zip code:" + PropertyManager.getInstance().getBillToZip());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToStateProvince)
				.sendKeys(PropertyManager.getInstance().getState());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToStateProvince).sendKeys(Keys.ENTER);

		Report.testLog(true, "State selected:" + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToCountry)
				.sendKeys(PropertyManager.getInstance().getCountry());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BillToCountry).sendKeys(Keys.ENTER);
		Report.testLog(true, "Country selected:" + PropertyManager.getInstance().getCountry());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		DriverClass.waitfor();
		Report.testLog(true, "Related Account is created");

	}

	public static void Add_Related_Distributor_Account_Negative()
			throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.AccountsListView);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.AllAccounts);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapAccount).click();

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccounts).click();

		Report.testLog(true, "Navigated to Related Accounts");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.NewBtnRelatedAccounts).click();

		DriverClass.waitfor();
		// DriverClass.elementclick(accountObj.NCPOnBoardingBillTo);
		// DriverClass.waitfor();
		Report.testLog(true, "Record type selected: NCP Distributor");
		DriverClass.elementclick(accountObj.NextBtnRelatedAccounts);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccountSearch)
				.sendKeys(PropertyManager.getInstance().getSearchAccountTest());
		Report.testLog(true, "Account name:" + PropertyManager.getInstance().getSearchAccountTest());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccountSearch).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RelatedAccountSearch).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.BroadlinerCustNumber).sendKeys(PropertyManager.getInstance().getBroadlinerCustNum());
		// Report.testLog(true, "Broadliner Customer Number:" +
		// PropertyManager.getInstance().getBroadlinerCustNum());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DistributorActive).sendKeys(Keys.ENTER);
		Report.testLog(true, "Set Distributor Active as Yes");
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.RelatedAccountNegativeValidation();

	}

	public static void TAPEventOrder_Zero_Quantity_Check() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.PhonenumTAP)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("0");
//
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderQuantitybox).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.Order_Zero_Quantity_Validation();

	}

	public static void MassUpdate_Task_Positive_Scenario() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(homeObj.Tasksobject);
		// DriverClass.elementclick(setupObj.taskObject);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.TasksListView);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch)
				.sendKeys(PropertyManager.getInstance().getTaskListView());
		Report.testLog(true, "List View selected : " + PropertyManager.getInstance().getTaskListView());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task1);

		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Task is selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AssignedToSearch)
				.sendKeys(PropertyManager.getInstance().getISARUserName());
		Report.testLog(true, "User selected : " + PropertyManager.getInstance().getISARUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.RakeshSaraUser).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus)
				.sendKeys(PropertyManager.getInstance().getTaskStatus2());
		Report.testLog(true, "Task Status selected : " + PropertyManager.getInstance().getTaskStatus2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus).sendKeys(Keys.ENTER);
		DriverClass.waitfor();

		// DriverClass.waitTillElementTobeVisible(driver,
		// homeObj.TaskStatus).sendKeys(Keys.ENTER);
		// DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned to new user");
		DriverClass.elementclick(homeObj.Task1);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Task is selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AssignedToSearch)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		Report.testLog(true, "Assigned to : " + PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		act.moveToElement(homeObj.JosephDohenyIII).click().perform();
		// DriverClass.waitTillElementTobeVisible(driver,
		// homeObj.TaskStatus).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TaskStatus)
				.sendKeys(PropertyManager.getInstance().getTaskStatus1());
		DriverClass.waitfor();
		Report.testLog(true, "Task Status selected : " + PropertyManager.getInstance().getTaskStatus1());
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned back to original user");
	}

	public static void MassUpdate_Task_Negative_Scenario() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(homeObj.Tasksobject);
		// DriverClass.elementclick(setupObj.taskObject);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.TasksListView);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch)
				.sendKeys(PropertyManager.getInstance().getTaskListView());
		Report.testLog(true, "List View selected : " + PropertyManager.getInstance().getTaskListView());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TasksListViewSearch).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Task1);

		DriverClass.elementclick(homeObj.Task2);
		DriverClass.waitfor();
		Report.testLog(true, "Task is selected");
		DriverClass.elementclick(homeObj.TaskDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdate);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='accessibility title']")));
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MassUpdateSave);
		DriverClass.waitfor();
		Report.testLog(true, "Clicked on Save button without giving Assigned to and status fields");
		Assertion_Functions.MassUpdateNegativeScearioValidation();
		DriverClass.waitfor();
	}

	public static void SAPAccountProductGuideCreation() throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AccountLinkDropdown).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AllAcountSelection).click();
		Report.testLog(true, "All Accounts list view is selected ");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.CreateProductGuide).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChameleonSelection).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RightArrowSelection).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.CreatePDFButton).click();
		Report.testLog(true, "PDF Created Successfully ");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).click();
		Report.testLog(true, "Show All Clicked Successfully");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FilesLink).click();
		Report.testLog(true, "Selected Files under Related links");
		DriverClass.waitfor();
		DriverClass.waitfor();

		// Assertion_Functions.ProductGuideCreation();
		String AN = "Sample Order Account";
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.AccountNameStorage).getText();
		String id = "0003223064";
	//	String id2 = "0002981859";
		
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.SapidStorage).getText();          0002981859

		String Filename = DriverClass.waitTillElementTobeVisible(driver, accountObj.FileNaminglink).getText();

		if ((Filename).contains(AN) && (Filename).contains(id) && (Filename).contains("Product Guide")) {
			System.out.println("File name contains Account name and SAPid");
			Report.testLog(true, "File name contains Account name and SAPid");
		} else {
			System.out.println("File name is incorrect");
			Report.testLog2(false, "File name is incorrect");
		}

	}

	public static void Representative_Account_ProductGuide_Creation()
			throws InterruptedException, AWTException, IOException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		// In Progress

		/*
		 * DriverClass.elementclick(reportObj.Reportlink); DriverClass.waitfor();
		 * DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,reportObj.AllReports).click();
		 * DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,reportObj.SearchAllReports).
		 * sendKeys(PropertyManager.getInstance().getRepresentative());
		 * DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,reportObj.
		 * RepresentativeReportslink).click(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AccountLinkDropdown).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.AllAcountSelection).click();
		Report.testLog(true, "All Accounts list view is selected ");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getSearchAccountTest());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getSearchAccountTest());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RepresentativeAccount).click();
		DriverClass.waitfor();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Dropdown).click();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RepCreateProductGuide).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChameleonSelection).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.RightArrowSelection).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.CreatePDFButton).click();
		Report.testLog(true, "PDF Created Successfully ");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ShowAllLink).click();
		Report.testLog(true, "ShowAll Clicked Successfully");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FilesLink).click();
		Report.testLog(true, "Selected Files under Related links");
		DriverClass.waitfor();
		DriverClass.waitfor();

		// Assertion_Functions.ProductGuideCreation();
		String RAN = "TestRepresentativeAccount";
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.RepAccountNameStorage).getText();
		String Rid = "0000281746";
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.RepSapidStorage).getText();

		String Filename2 = DriverClass.waitTillElementTobeVisible(driver, accountObj.FileNaminglink2).getText();
		Report.testLog(true, Filename2);
		if ((Filename2).contains(RAN) && !(Filename2).contains(Rid)) {
			System.out.println("File name contains only Account name and not SAPid");
			Report.testLog(true, "File name contains only Account name and not SAPid");
		} else {
			System.out.println("File name is incorrect");
			Report.testLog(false, "File name is incorrect");
		}
	}

	public static void NCP_Negotiated_Contract_Cloning() throws InterruptedException, IOException, AWTException {
		Robot robot = new Robot();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearch2());
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.NCPContractObj).click().perform();

		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(contractObj.NewContractBtn);
		DriverClass.waitfor();

		DriverClass.elementclick(contractObj.NegotiatedRecord);
		DriverClass.waitfor();

		// NegotiatedRecord

		DriverClass.waitTillElementTobeVisible(driver, contractObj.Nextbtn).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractName)
				.sendKeys(PropertyManager.getInstance().getContractName());
		Report.testLog(true, "Enter Contract name " + PropertyManager.getInstance().getContractName());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		// act.moveToElement(contractObj.CollegeAccount).click().perform();
		// DriverClass.waitTillElementTobeVisible(driver,contractObj.AccountName).sendKeys(PropertyManager.getInstance().getOrderAccount());

		DriverClass.waitfor();

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.Description)
				.sendKeys(PropertyManager.getInstance().getDescription2());
		Report.testLog(true, "Enter Description " + PropertyManager.getInstance().getDescription2());
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType)
				.sendKeys(PropertyManager.getInstance().getContractType2());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, contractObj.ContractType).sendKeys(Keys.ENTER);
		// DriverClass.waitTillElementTobeVisible(driver,
		// contractObj.ContractType).sendKeys(PropertyManager.getInstance().getContractType2());
		DriverClass.waitfor();
		Report.testLog(true, "Enter Contract Type " + PropertyManager.getInstance().getContractType2());
		DriverClass.waitTillElementTobeClickable(driver, contractObj.ContractStartDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Enter Contract Start Date " + PropertyManager.getInstance().getContractDate());
		// DriverClass.waitTillElementTobeVisible(driver,contractObj.EquipmentNotes).sendKeys(PropertyManager.getInstance().getEquipmemntNotes());
		// DriverClass.waitfor();
		// Report.testLog(true, "Enter Equipment Note : " +
		// PropertyManager.getInstance().getEquipmemntNotes());

		DriverClass.waitTillElementTobeVisible(driver, contractObj.SaveContact).click();
		DriverClass.waitfor();
		Assertion_Functions.Add_Contract_Validation();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contractObj.EGClone).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, contractObj.EGCloneSave).click();
		DriverClass.waitfor();
		Report.testLog(true, "Negotiated contract cloning is successful");
	}

	public static void FG_QuoteToPdf_Conversion_FGtemplate() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quoteconversionpdf).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : Quoteconversionpdf");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quotes Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotedd).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGConverttopdfButton).click();
		DriverClass.waitfor();
		Report.testLog(true, "Quote Preview is displayed");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Templatedd).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FinishedGoodstemplate).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Finished Goods template is selected");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Createpdfbutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is created");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SavetoQuotebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is saved to Quote");

	}

	public static void FG_QuoteToPdf_Conversion_TAtemplate() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.opportunity);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Opportunity Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quoteconversionpdf).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Opportunity selected : Quoteconversionpdf");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Quotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quotes Object");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotelink).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Quote");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotedd).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGConverttopdfButton).click();
		DriverClass.waitfor();
		Report.testLog(true, "Quote Preview is displayed");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Templatedd).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.TAtemplate).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "TA template is selected");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Createpdfbutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is created");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.SavetoQuotebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Pdf is saved to Quote");

	}

	public static void PSS_Flow_Winter_BrewOnly() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonWinter).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Winter");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
//	String PoYear = Year.trim();
		System.out.println(Year);
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(new Date);
//	DriverClass.waitfor();
//	Report.testLog(true, "Promo Season is selected as Winter");
		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Nextbutton).click();
//	DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeBrewOnly).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Brew only");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded FSM is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

		/*
		 * Scanner s = new Scanner(new File("filepath")); ArrayList<String> list = new
		 * ArrayList<String>(); while (s.hasNext()){ list.add(s.next()); } s.close();
		 */

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();

		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();	
		

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		Report.testLog(true, "Navigated to the Order");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		Report.testLog(true, "Navigated to Order Details tab");
		DriverClass.waitfor();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
//	act.moveToElement(homeObj.PSSOrderDetails).click().perform();
//	DriverClass.waitfor();
		/*
		 * WebElement Details = driver.findElement(By.xpath("//a[@title='Details']"));
		 * ((JavascriptExecutor)driver).executeScript("Return arguments[0].click();",
		 * Details);
		 */
		/*
		 * Actions act1 = new Actions(driver);
		 * act1.moveToElement(homeObj.PSSOrderDetails).click().perform();
		 * DriverClass.waitfor();
		 */
		
		//(PO.contains("PSS Wint") && PO.contains("21") || PO.contains("22")|| PO.contains("23") &&

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Winter_Espresso() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonWinter).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Winter");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(new Date);
//	DriverClass.waitfor();
//	Report.testLog(true, "Promo Season is selected as Winter");
		Date today = new Date();
		String POIdentifier = today.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Nextbutton).click();
//	DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspresso).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Excluded FSM is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();

		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
		DriverClass.waitfor();
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();
		
			/*
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
			 * ; DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
			 * DriverClass.waitfor();
			 */
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		Report.testLog(true, "Navigated to Order Details tab");
		DriverClass.waitfor();
		DriverClass.waitfor();
//	String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Winter_Frappuccino() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonWinter).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Winter");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(new Date);
//	DriverClass.waitfor();
//	Report.testLog(true, "Promo Season is selected as Winter");
		Date td = new Date();
		String POIdentifier = td.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Nextbutton).click();
//	DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspressoFrappuccino).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso/Frappuccino");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded FSM is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
//	DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();

		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
		DriverClass.waitfor();

		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();
		 
			/*
			 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
			 * ; DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
			 * ; DriverClass.waitfor();
			 * 
			 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
			 * DriverClass.waitfor();
			 */
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		Report.testLog(true, "Navigated to Order Details tab");
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Spring_BrewOnly() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSpring).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Spring");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeBrewOnly).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Brew only");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded FSM is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Spring_Espresso() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSpring).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Spring");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
//	String PoYear = Year.trim();
		System.out.println(Year);
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(new Date);
//	DriverClass.waitfor();
//	Report.testLog(true, "Promo Season is selected as Winter");
		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Nextbutton).click();
//	DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspresso).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}

		Report.testLog(true, "Number of Accounts:" + rows.size());
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Spring_Frappuccino() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSpring).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Spring");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
//	String PoYear = Year.trim();
		System.out.println(Year);
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(new Date);
//	DriverClass.waitfor();
//	Report.testLog(true, "Promo Season is selected as Winter");
		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Nextbutton).click();
//	DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspressoFrappuccino).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso/Frappuccino");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}

		Report.testLog(true, "Number of Accounts:" + rows.size());
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Summer_BrewOnly() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSummer).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Summer");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeBrewOnly).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Brew only");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Summer_Espresso() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSummer).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Summer");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspresso).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		/*
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Summer_Frapppuccino() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonSummer).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Summer");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspressoFrappuccino).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso/Frappuccino");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
		// Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Fall_BrewOnly() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonFall).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Fall");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeBrewOnly).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Brew only");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Fall_Espresso() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonFall).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Fall");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspresso).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded FSM is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Fall_Frapppuccino() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonFall).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Fall");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspressoFrappuccino).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso/Frappuccino");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Holiday_BrewOnly() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonHoliday).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Holiday");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeBrewOnly).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Brew only");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Holiday_Espresso() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonHoliday).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Holiday");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspresso).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void PSS_Flow_Holiday_Frapppuccino() throws InterruptedException, IOException, AWTException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonHoliday).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Promo Season is selected as Holiday");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		Date todaydate = new Date();
		String POIdentifier = todaydate.toString();
		POIdentifier = POIdentifier.substring(0, 10);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.UPI).sendKeys(POIdentifier);
		DriverClass.waitfor();
		Report.testLog(true, "PO Identifier:" + POIdentifier);
		
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OD).sendKeys("SeasonalOrders");
		DriverClass.waitfor();
		Report.testLog(true, "Order Description is entered as SeasonalOrders");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ProgramTypeEspressoFrappuccino).click();
		DriverClass.waitfor();
		Report.testLog(true, "Program type is selected as Espresso/Frappuccino");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PPS).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.FiveOz).click();
		DriverClass.waitfor();
		Report.testLog(true, "Portion Pack Size selected: 5 Oz");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedSegments).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Hotel/Accomodation");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedBanners).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded Banners is selected as N/A");

		DriverClass.waitTillElementTobeVisible(driver, homeObj.ExcludedFSMs).click();
		DriverClass.waitfor();
		Report.testLog(true, "Excluded segment is selected as Aramark");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Default kit is selected");
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.NoRadiobutton).click();
		act.moveToElement(homeObj.NoRadiobutton).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
//	List<String> AccountNames = new ArrayList<String> ();

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.CreateOrderButton).click();
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']"));
		System.out.println("Number of accounts:" + rows.size());
		for (int i = 1; i <= rows.size(); i++) {
			// List<String> AccountNames = new ArrayList<String> ();
			String AccountNames = driver.findElement(By.xpath(
					"(//div[@class='slds-m-around_medium cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element slds-size--1-of-12 td-fixed-width']//div[@title='AccName'])["
							+ i + "]"))
					.getText();
			// AccountNames[i] =
			// driver.findElement(By.xpath("(//div[@class='slds-m-around_medium
			// cGenerateReportPSSOrder']//table//tr[@class='slds-hint-parent']//td[@class='slds-form-element
			// slds-size--1-of-12
			// td-fixed-width']//div[@title='AccName'])["+i+"]")).getText();
			System.out.println(AccountNames);
		}
		Report.testLog(true, "Number of Accounts:" + rows.size());
//	Report.testLog(true, "Account Names:" + AccountNames);
		act.moveToElement(homeObj.CreateOrderButton).click().perform();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		Report.testLog(true, "Navigated to My Orders List View");
		DriverClass.waitfor();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.OrderDateDesc).click(); DriverClass.waitfor();
		 */
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.PSSOrderNumber).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.PSSOrderNumber).click()
		 * ; DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.OrderDateDesc).click();
		 * DriverClass.waitfor();
		 */
		
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.PSSOrderNumber);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.OrderDateDesc);
		 DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
		if (PO.contains(POIdentifier)) {
			Report.testLog(true, "Order is created with proper PO identifier");
		} else {
			Report.testLog(false, "Order is not created with proper PO identifier");
		}

	}

	public static void test() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

//	DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		DriverClass.waitfor();

		String url = "";
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();

		/*
		 * Actions act = new Actions(driver);
		 * 
		 * act.moveToElement(homeObj.PSSOrderDetails); act.click().build().perform();
		 * DriverClass.waitfor();
		 */

	}

	public static void PSSOrders() throws InterruptedException, AWTException, IOException {

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getobjectSearchOrders());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);

		DriverClass.waitTillElementTobeVisible(driver, homeObj.OrdersLV).click();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOrdersLV).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrder).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSOrderDetails).click();
		DriverClass.waitfor();

		String PO = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumber).getText();
//	if(PO.contains(Sd)) {

//	}
	}

	public static void TAPOrderSubmission() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
//act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
//	Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallationTAP)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter RetrievalInstallation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionTAP)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		// DriverClass.elementclick(orderObj.prodsave);
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAPSubmit());

		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
//	 Assertion_Functions.OrderSubmitValidation_Submit_Button();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// validation for submission
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();

		/*
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.EditProduct).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.EditProduct).sendKeys(
		 * Keys.DOWN);
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.EditProduct).sendKeys(
		 * Keys.ENTER); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Venue_Brew_Site).sendKeys(PropertyManager.getInstance().
		 * getVenue_Brew_Site());
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Calibration_Brand).sendKeys(PropertyManager.getInstance().
		 * getCalibration_Brand()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Calibration_Brand).
		 * sendKeys(Keys.ENTER); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Service_Authorization).sendKeys(PropertyManager.getInstance().
		 * getService_Authorization()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Service_Authorization)
		 * .sendKeys(Keys.ENTER); DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Service_Invoice).sendKeys(PropertyManager.getInstance().
		 * getService_Invoice()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,orderObj.Service_Invoice).
		 * sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.SaveEdit).click();
		 * 
		 * String Orderno2 = DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor(); //
		 * Assertion_Functions.OrderSubmitValidation();
		 * 
		 * // validation for submission Report.testLog(true,
		 * "Order number sent for Submission is :" + Orderno2); DriverClass.waitfor();
		 */

	}

	public static void TAPOrderCloning() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
//    act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
//	Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		// DriverClass.elementclick(orderObj.prodsave);
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CloneOrder).click();
		Report.testLog(true, "Clone Order button is clicked");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SearchAccount)
				.sendKeys(PropertyManager.getInstance().getSearchAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Account name " + PropertyManager.getInstance().getSearchAccount());
//DriverClass.elementsendvalues(PropertyManager.getInstance().getSearchAccount(), orderObj.SearchAccount);

		DriverClass.elementclick(orderObj.AccountCheckBox);
		Report.testLog(true, "Account selection for cloning the order");
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */

		/*
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 */

		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.CloneButton);
		DriverClass.waitfor();

		driver.switchTo().alert().accept();
		DriverClass.waitfor();
		Report.testLog(true, "Closing the popup page");

		DriverClass.elementclick(orderObj.CloneCancelButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.NotificationIcon);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigation to cloned order");

		Assertion_Functions.Cloning_Order_Validation();

		DriverClass.elementclick(orderObj.SuccessfulCloning);
		DriverClass.waitfor();

	}

	public static void FGSampleOrderSubmission() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGSampleCheckox);
		Report.testLog(true, "FG SAmple Order is selcted");

		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberFGSample)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTA).click();
		;
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTANo).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventSSN)
				.sendKeys(PropertyManager.getInstance().getQuantity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventSS)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventSC)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventZip)
				.sendKeys(PropertyManager.getInstance().getBillToZip());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventState).click();
		DriverClass.waitfor();

		act.moveToElement(orderObj.AlaskaState).click().perform();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventCountry).click();
		;
		DriverClass.waitfor();

		act.moveToElement(orderObj.CountryUS).click().perform();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompanyName)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ResidentialDeliveryTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ReqDelNo).click();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionFGSample)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy)
				.sendKeys(PropertyManager.getInstance().getManagerUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.ENTER);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy)
				.sendKeys(PropertyManager.getInstance().getManagerUserName());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.ENTER);
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor).sendKeys(PropertyManager.getInstance().getPreparedfor());
//	Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
//	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();

		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductnew());

		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).sendKeys(Keys.ENTER);

		/*
		 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_RIGHT);
		 * robot.keyRelease(KeyEvent.VK_RIGHT);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_9);
		 * robot.keyRelease(KeyEvent.VK_9); DriverClass.waitfor();
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */

		/*
		 * DriverClass.elementclick(orderObj.quantitySearch); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.qtyInput)
		 * .sendKeys(PropertyManager.getInstance().getQuantity());
		 * DriverClass.waitfor(); // Assertion_Functions.OrderCreation_Validation();
		 * DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();

		/*
		 * DriverClass.waitfor(); String Orderno2 =
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.ordernumber).getText(); DriverClass.waitfor();
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor();
		 * 
		 * DriverClass.elementclick(orderObj.Changestatus); DriverClass.waitfor(); //
		 * Assertion_Functions.OrderSubmitValidation();
		 * 
		 * // validation for submission Report.testLog(true,
		 * "Order number sent for Submission is :" + Orderno2); DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
//	 Assertion_Functions.OrderSubmitValidation_Submit_Button();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// validation for submission
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();
	}

	public static void TAPOrderForEventsSubmission() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
//	robot.keyPress(KeyEvent.VK_DOWN);
//	robot.keyRelease(KeyEvent.VK_DOWN);
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTA).click();
		;
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTANo).click();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventSSN)
				.sendKeys(PropertyManager.getInstance().getQuantity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventSS)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventSC)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventZip)
				.sendKeys(PropertyManager.getInstance().getBillToZip());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventState).click();
		DriverClass.waitfor();

		act.moveToElement(orderObj.AlaskaState).click().perform();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventCountry).click();
		;
		DriverClass.waitfor();

		act.moveToElement(orderObj.CountryUS).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompanyName)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ResidentialDeliveryTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ReqDelNo).click();
//	DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter  RetrievalInstallation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

//	act.moveToElement(orderObj.GU).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.DOWN);
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.ENTER);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	act.moveToElement(orderObj.GU).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.DOWN);
//    DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.ENTER);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionTAPEvent)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2).sendKeys(PropertyManager.getInstance().getPreparedfor());
//	Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SDR).click();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
//	DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
//	robot.keyPress(KeyEvent.VK_RIGHT);
//	robot.keyRelease(KeyEvent.VK_RIGHT);
//	DriverClass.waitfor();
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
//	DriverClass.waitfor();
//	robot.keyPress(KeyEvent.VK_2);
//	robot.keyRelease(KeyEvent.VK_2);
//	DriverClass.waitfor();
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
//	robot.keyPress(KeyEvent.VK_ENTER);
//	robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();

		// DriverClass.elementclick(orderObj.prodsave);
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();

		// Assertion_Functions.OrderSubmitValidation();
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();

		// validation for submission
		Report.testLog(true, "Order number sent for Submission is :" + Orderno2);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
//	 Assertion_Functions.OrderSubmitValidation_Submit_Button();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		// validation for submission
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();

	}

	public static void TAQuoteToOrderConversion() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
				.sendKeys(PropertyManager.getInstance().getObjectSearchQuotes());
		DriverClass.waitfor();
		Report.testLog(true, "Searched for" + PropertyManager.getInstance().getObjectSearchQuotes());
		DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.TAQuote).click();
		DriverClass.waitfor();
		Report.testLog(true, "TA Quote is selected");
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGQuotedd).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.FGConverttoOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "TA Quote is converted to order");
	}

	public static void TAROrderSubmission() throws InterruptedException, IOException, AWTException {

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Robot robot = new Robot();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
//			.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date is taken as todays date");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallationTAP)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true,
				"Enter RetrivalInstallation Date " + PropertyManager.getInstance().getRetrievalInstallation());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionTAR)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RRR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ReRR).click();
		DriverClass.waitfor();
		
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.RRR).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.RRR).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.RRR).sendKeys(Keys.ENTER);
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation).click();

		// DriverClass.waitTillElementTobeVisible(driver,orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddTradeAssets);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
		 * .sendKeys(PropertyManager.getInstance().getProductTAP());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Enter Product name " +
		 * PropertyManager.getInstance().getProduct());
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.TARprodcheckox);
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(orderObj.Nextbtn2); DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.TARSavebutton);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderProductsViewAll).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderProductlink2).click();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, orderObj.TARProductDD).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EditTAR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Venue_Brew_Site)
				.sendKeys(PropertyManager.getInstance().getRTM());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ReasonforReturn).click();
		DriverClass.waitfor();
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.ReasonNR).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREditSave).click();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.LatestOrder);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();
	}

	public static void TAROrderForEventsSubmission() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventsCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
//act.moveToElement(orderObj.Espresso).click().perform();
//Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTA).click();;
//	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.ApprovedTANo).click();
		
		
		  if(DriverClass.waitTillElementTobeVisible(driver,orderObj.RfR).isDisplayed())
		  { 
		  DriverClass.waitTillElementTobeVisible(driver,orderObj.RfR).click(); 
		  DriverClass.waitTillElementTobeVisible(driver,orderObj.ReasonNR).click(); 
		  Report.testLog(true,"Reason for return is selected"); 
		  }else {
		  System.out.println("Reason for return is available"); 
		  }
		 

		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventSSN)
				.sendKeys(PropertyManager.getInstance().getQuantity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventSS)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventSC)
				.sendKeys(PropertyManager.getInstance().getCity());
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SampleEventZip)
				.sendKeys(PropertyManager.getInstance().getBillToZip());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventState).click();
		DriverClass.waitfor();

		act.moveToElement(orderObj.AlaskaState).click().perform();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventCountry).click();
		;
		DriverClass.waitfor();

		act.moveToElement(orderObj.CountryUS).click().perform();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompanyName)
				.sendKeys(PropertyManager.getInstance().getStage());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARResidentialDeliveryTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARReqDelNo).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARRetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Enter RetrievalInstallation " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.RequestedBy).sendKeys(Keys.ENTER);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy)
				.sendKeys(PropertyManager.getInstance().getTaskOwner());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.CompletedBy).sendKeys(Keys.ENTER);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionTAREvent)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2).sendKeys(PropertyManager.getInstance().getPreparedfor());
//	Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OD).click();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
//	DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddTradeAssets);
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
		 * .sendKeys(PropertyManager.getInstance().getProductTAP());
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 * Report.testLog(true, "Enter Product name " +
		 * PropertyManager.getInstance().getProduct());
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.TARprodcheckox);
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(orderObj.Nextbtn2); DriverClass.waitfor();
		 */
		DriverClass.elementclick(orderObj.TARSavebutton);
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderProductsViewAll).click();
		DriverClass.waitfor();
		
		/*
		 * if(DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.OrderProductlink2).isDisplayed()) {
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.OrderProductlink2).click(); }else
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OrderProductlink).click();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, orderObj.TARProductDD).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EditTAR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Venue_Brew_Site)
				.sendKeys(PropertyManager.getInstance().getRTM());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.ReasonforReturn).click();
		DriverClass.waitfor();
//	Actions act = new Actions(driver);
		act.moveToElement(orderObj.ReasonNR).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREditSave).click();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.LatestOrder);
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "User Submitted the Order");
		Assertion_Functions.OrderSubmitValidation_Submit_Button();
	}

	public static void FSM_ValidTo_lessthanToday_negative() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: test");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousMonth).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Navigated to Previous month in FSM Valid To field");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PastDate).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Past date is added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();

		Assertion_Functions.FSMErrorValidation();
	}

	public static void FSM_ValidTo_lessthanToday_Terminating_Account()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * setupObj.NCPSalesLogin).click(); Report.testLog(true,
		 * "Logged in as NCP Sales"); DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitfor(); driver.switchTo().defaultContent();
		 * DriverClass.waitfor();
		 */
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: test");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidTo).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousMonth).click();
//	DriverClass.waitfor();
		Report.testLog(true, "Navigated to Previous month in FSM Valid To field");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PastDate).click();

		Report.testLog(true, "Past date is added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();
		Assertion_Functions.FSMErrorValidation();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatustech).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatustech).sendKeys(PropertyManager.getInstance().
		 * getNcpAccountStatus()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatustech).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).sendKeys(Keys.DOWN); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).sendKeys(Keys.ENTER); Report.testLog(true,
		 * "Termination reason is added");
		 */
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		 * DriverClass.waitfor(); Report.testLog(true,
		 * "Account is terminated and saved"); DriverClass.waitfor();
		 */
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatustech).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatusTerminated).click();

		Report.testLog(true, "NCP Account status is selected as Terminated");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Terminationrsntech).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.NCPAccountStatusTerminatedReason).click();

		Report.testLog(true, "Termination reason is selected");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account is terminated and saved");
		DriverClass.waitfor();

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.EditAccount).click(); DriverClass.waitfor();
		 * 
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatusTtech).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatusActive).click();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatusTreason).click(); DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatusNone).click();
		 * 
		 * Actions act = new Actions(driver);
		 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.FSMValidTo).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.FSMValidTo).click(); DriverClass.waitfor(); //
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.NextMonth).click();
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.NextMonth).click();
		 * DriverClass.waitfor(); // Report.testLog(true,
		 * "Navigated to next month in FSM Valid To field");
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.PastDate).click();
		 * 
		 * Report.testLog(true, "Date is added");
		 */

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatustech).sendKeys(PropertyManager.getInstance().
		 * getsapstatus()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.NCPAccountStatustech).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 */

//	NCPAccountStatusTerminatedReason

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).sendKeys(PropertyManager.getInstance().
		 * getStatusOpp()); DriverClass.waitfor();
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.Terminationrsntech).sendKeys(Keys.ENTER); Report.testLog(true,
		 * "Termination reason is removed");
		 */

//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
//	DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
//	DriverClass.waitfor();
	}

	public static void FSM_Change_Task_to_ISAR() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		/*
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * setupObj.NCPSalesLogin).click(); Report.testLog(true,
		 * "Logged in as NCP Sales"); DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitfor(); driver.switchTo().defaultContent();
		 * DriverClass.waitfor();
		 */
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: test");

		/*
		 * DriverClass.waitTillElementTobeClickable(driver,
		 * accountObj.AccountTeamlink).click();
		 * if(DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.ISARTeammember).isDisplayed()) { Report.testLog(true,
		 * "ISAR is added in the Account"); } else { Report.testLog(true,
		 * "ISAR is not added in the Account"); } DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.TestAccount).click(); DriverClass.waitfor();
		 */
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.ISARTeammember).isDisplayed();

		DriverClass.waitfor();
		String AccountOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.AccOwner).getText();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).clear();
//	DriverClass.waitfor();
		Report.testLog(true, "SAP Id cleared");

//	if()
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Previous FSM Account is added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).sendKeys("123456");
//	DriverClass.waitfor();
		Report.testLog(true, "New SAP Id added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Account is saved");

		DriverClass.elementclick(homeObj.Tasksobject);
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Tasksobject).click();
		DriverClass.waitfor();
		String TaskOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskAssignedTo).getText();
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned to:" + TaskOwner);
		if (AccountOwner.equalsIgnoreCase(TaskOwner)) {
			Report.testLog(true, "Task is assigned to: Account Owner");
		} else {
			Report.testLog(true, "Task is assigned to: ISAR");
		}

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).clear();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid)
				.sendKeys(PropertyManager.getInstance().gettestsapid());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMDelete).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();
	}

	public static void FSM_Change_Task_to_AccountOwner() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PlaceholderAccount).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: PLACEHOLDER College of Mount Saint Vincent");
		DriverClass.waitfor();
		String AccountOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.AccOwner).getText();
		System.out.println(AccountOwner);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).clear();
//	DriverClass.waitfor();
		Report.testLog(true, "SAP Id cleared");

//	if()
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Previous FSM Account is added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).sendKeys("123456");
//	DriverClass.waitfor();
		Report.testLog(true, "New SAP Id added");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Account is saved");

		DriverClass.elementclick(homeObj.Tasksobject);
//	DriverClass.waitTillElementTobeVisible(driver, homeObj.Tasksobject).click();
		DriverClass.waitfor();
		String TaskOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskAssignedTo).getText();
		System.out.println(TaskOwner);
		DriverClass.waitfor();
		Report.testLog(true, "Task is assigned to:" + TaskOwner);
		if (AccountOwner.contains(TaskOwner)) {
			Report.testLog(true, "Task is assigned to: Account Owner");
		} else {
			Report.testLog(true, "Task is assigned to: ISAR");
		}

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PlaceholderAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid).clear();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.sapid)
				.sendKeys(PropertyManager.getInstance().getplaceholdersapid());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousFSMDelete).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();
	}

	public static void New_Account_Followup_Task_to_AccountOwner()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Sample Order Account");
		String AccountOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.AccOwner).getText();
//	System.out.println("Account Owner is: "+ AccountOwner);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
//	DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousMonth).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PastDate).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		Report.testLog(true, "Open date is moved back to more than 14 days from the current date");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Tasksobject);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.taskObjectNew).click();
//	DriverClass.waitfor();
		String TaskOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskAssignedTo).getText();
		System.out.println("Task is Assigned to : " + TaskOwner);
		if (AccountOwner.contains(TaskOwner)) {
			System.out.println("Task is assigned to Account Owner");
			Report.testLog(true, "Task is assigned to Account Owner");
		} else {
			System.out.println("Task is not assigned to Account Owner");
			Report.testLog(false, "Task is not assigned to Account Owner");
		}
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();
		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.OpenDateSAPAccount).click(); DriverClass.waitfor();
		 * 
		 * Date today = new Date();
		 * 
		 * System.out.println(today); DateFormat dateFormat = new
		 * SimpleDateFormat("M/d/yyyy");
		 */

//	FormattedDate = dateFormat.parse(today);

//	Calendar calendar = Calendar.getInstance(); 
//	calendar.add(Calendar.DAY_OF_MONTH, -14);

		/*
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.PreviousMonth).click(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.PastDateOpenDate).click(); DriverClass.waitfor();
		 */
// 	DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
//	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountActivityTab).click();
//	DriverClass.waitfor();

		/*
		 * DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy"); //("MM-dd-yyyy")
		 * 
		 * Date date = new Date(); String todate = dateFormat.format(date);
		 */

		/*
		 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); Date date =
		 * newDate(); String date1 = dateFormat.format(date);
		 * 
		 * 
		 * Calendar cal = Calendar.getInstance(); DriverClass.waitfor();
		 * cal.add(Calendar.DATE, -14); // Date todate1 = cal.getTime(); // String
		 * fromdate = dateFormat.format(todate1); DriverClass.waitfor();
		 */

	}

	public static void New_Account_Followup_Task_to_ISAR() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Test");
		String AccountOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.AccOwner).getText();
//	System.out.println("Account Owner is: "+ AccountOwner);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
//	DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.PreviousMonth).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.PastDate).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		Report.testLog(true, "Open date is moved back to more than 14 days from the current date");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Tasksobject);
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.navigate().refresh();
		DriverClass.waitfor();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.taskObjectNew).click();
		DriverClass.waitfor();
		String TaskOwner = DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskAssignedTo).getText();
		System.out.println("Task is Assigned to : " + TaskOwner);
		if (!AccountOwner.contains(TaskOwner)) {
			System.out.println("Task is assigned to ISAR");
			Report.testLog(true, "Task is assigned to ISAR");
		} else {
			System.out.println("Task is assigned to Account Owner");
			Report.testLog(false, "Task is assigned to Account Owner");
		}
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TestAccount).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.OpenDateSAPAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();
	}

	public static void Account_Notes_Verification_in_Orders() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * 
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,setupObj.NCPSalesLogin).click()
		 * ; Report.testLog(true,"Logged in as NCP Sales"); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: College of Mount Saint Vincent");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String AccountNotes = DriverClass.waitTillElementTobeVisible(driver, accountObj.DeliveryNotes).getText();
		System.out.println(AccountNotes);
		Report.testLog(true, "Account Notes :" + AccountNotes);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Finished Goods Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder3).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String AccountDeliveryNotes = DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountDeliveryNotes)
				.getText();
		System.out.println(AccountDeliveryNotes);
		Report.testLog(true, "Account Delivery Notes :" + AccountDeliveryNotes);
		DriverClass.waitfor();

		if (AccountNotes.equalsIgnoreCase(AccountDeliveryNotes)) {
			Report.testLog(true, "Account Notes in Account is same as Account Delivery Notes in Order");
		} else {
			Report.testLog(true, "Account Notes in Account is not same as Account Delivery Notes in Order");
		}

	}

	public static void Account_Notes_Verification_in_TAP_Orders()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: College of Mount Saint Vincent");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String AccountNotes = DriverClass.waitTillElementTobeVisible(driver, accountObj.DeliveryNotes).getText();
		System.out.println(AccountNotes);
		Report.testLog(true, "Account Notes :" + AccountNotes);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Trade Assets Placement Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder3).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String AccountDeliveryNotes = DriverClass.waitTillElementTobeVisible(driver, orderObj.AccountDeliveryNotesTAP)
				.getText();
		System.out.println(AccountDeliveryNotes);
		Report.testLog(true, "Account Delivery Notes :" + AccountDeliveryNotes);
		DriverClass.waitfor();

		if (AccountNotes.equalsIgnoreCase(AccountDeliveryNotes)) {
			Report.testLog(true, "Account Notes in Account is same as Account Delivery Notes in Order");
		} else {
			Report.testLog(true, "Account Notes in Account is not same as Account Delivery Notes in Order");
		}

	}

	public static void PO_Number_Verification_in__FG_Orders() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
	

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: College of Mount Saint Vincent");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumber).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Finished Goods Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}

	}

	public static void PO_Number_Verification_in_TAP_Orders() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: test");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumber).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Trade Assets Placement Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}

	}

	public static void PO_Number_Verification_in_TAP_Orders_for_Events()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Sample Order Account");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumber).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Trade Assets Placement Order for Events");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		Report.testLog(true, "Equipment type selected");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}
	}

	public static void PO_Number_Verification_in_TAR_Orders() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * 
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,setupObj.NCPSalesLogin).click()
		 * ; Report.testLog(true,"Logged in as NCP Sales"); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: College of Mount Saint Vincent");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumber).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TARCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type: Trade Assets Retrieval Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		
		DriverClass.waitTillElementTobeClickable(driver, orderObj.RRR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.ReRR).click();
		DriverClass.waitfor();
		
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder2).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}

	}

	public static void PO_Number_Verification_in_FG_Sample_Order()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * 
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,setupObj.NCPSalesLogin).click()
		 * ; Report.testLog(true,"Logged in as NCP Sales"); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Sample Order Account");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumberS).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.FGSampleCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type:Finished Goods Sample Order");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
//    act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
//	Report.testLog(true, "Equipment type selected");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder11).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}
	}

	public static void PO_Number_Verification_in_TAR_Events_Order()
			throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * 
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,setupObj.NCPSalesLogin).click()
		 * ; Report.testLog(true,"Logged in as NCP Sales"); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Sample Order Account");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */

		// System.out.println(a);

		String BlanketPO = DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketPONumberS).getText();
		System.out.println(BlanketPO);
		Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Cancel).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountOrders).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.AccNewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAREventsCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		Report.testLog(true, "Order Type:Trade Assets Retrieval for Events");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();

//	DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
//    act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
//	Report.testLog(true, "Equipment type selected");

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		
		DriverClass.waitTillElementTobeClickable(driver, orderObj.RRR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.ReRR).click();
		DriverClass.waitfor();
		
		Report.testLog(true, "Enter Phone Number " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeClickable(driver, orderObj.SaveTAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "New Order is created");
		/*
		 * DriverClass.waitTillElementTobeVisible(driver, homeObj.SalesforceON).click();
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * homeObj.SalesforceON).click(); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeClickable(driver, orderObj.AccountLatestOrder).click();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to New Order");

		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
		String PONumber = DriverClass.waitTillElementTobeClickable(driver, orderObj.FGOrderPONumber).getText();
		System.out.println(PONumber);
		Report.testLog(true, "Order PO Number :" + PONumber);
		DriverClass.waitfor();

		if (BlanketPO.equalsIgnoreCase(PONumber)) {
			Report.testLog(true, "Blanket PO number in Account is same as PO Number in Order");
		} else {
			Report.testLog(true, "Blanket PO number in Account is not same as PO Number in Order");
		}
	}

	public static void ASN_Verification_FG_Order() throws InterruptedException, IOException, AWTException {

		// Robot robot = new Robot();

		DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver, setupObj.UsersI).click();
//	DriverClass.elementclick(setupObj.UsersI);
//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.CPI).click();
		Report.testLog(true, "Logged in as CPI Integration");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
		 * .sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		 * Report.testLog(true, "Enter Delivery Attention: " +
		 * PropertyManager.getInstance().getDeliveryAttention());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
		 * .sendKeys(PropertyManager.getInstance().getPreparedfor());
		 * Report.testLog(true, "Enter Prepared for " +
		 * PropertyManager.getInstance().getPreparedfor()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Accountdeliverynotes).click(); DriverClass.waitfor();
		 */

		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderEdit).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB11).isDisplayed();
		System.out.println("Element ASN checkbox is visible");
		boolean SendASN = DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB11).isSelected();
//	System.out.println("status is: " + SendASN);

		if (!(SendASN) == true) {
			System.out.println("Send ASN field is unchecked");
			Report.testLog(true, "Send ASN field is unchecked");
		} else {
			System.out.println("Send ASN field is checked");
			Report.testLog(true, "Send ASN field is checked");
		}

		/*
		 * if(!(SendASN).isSelected()) {
		 * System.out.println("Send ASN field is unchecked"); Report.testLog(true,
		 * "Send ASN field is unchecked"); } else {
		 * System.out.println("Send ASN field is checked"); Report.testLog(true,
		 * "Send ASN field is checked"); }
		 */

	}

	public static void Account_Inactive_Notification_to_ISAR() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
		/*
		 * 
		 * DriverClass.elementclick(setupObj.Users); DriverClass.waitfor();
		 * DriverClass.elementclick(setupObj.Userssub); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * 
		 * try {
		 * 
		 * driver.switchTo().frame(0); }
		 * 
		 * catch (Exception e) { System.out.println("Not able to view Frame"); }
		 * 
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,setupObj.NCPSalesLogin).click()
		 * ; Report.testLog(true,"Logged in as NCP Sales"); DriverClass.waitfor();
		 * DriverClass.waitfor(); DriverClass.waitfor();
		 * driver.switchTo().defaultContent(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: test");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SAPAccountStatusActive).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.SAPAccountStatusInactive).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebtn).click();
		DriverClass.waitfor();

	}

	public static void ASN_Verification_FG_Sample_Order() throws InterruptedException, IOException, AWTException {

		// Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver, setupObj.UsersI).click();
//	DriverClass.elementclick(setupObj.UsersI);
//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.CPI).click();
		Report.testLog(true, "Logged in as CPI Integration");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGSampleCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date :" + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name :" + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber).sendKeys(PropertyManager.getInstance().getPONumber());
//	Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());


		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderEdit).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB2).isDisplayed();
		System.out.println("Element ASN checkbox is visible");
		boolean SendASN = DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB2).isSelected();
//	System.out.println("status is: " + SendASN);

		if (!(SendASN) == true) {
			System.out.println("Send ASN field is unchecked");
			Report.testLog(true, "Send ASN field is unchecked");
		} else {
			System.out.println("Send ASN field is checked");
			Report.testLog(true, "Send ASN field is checked");
		}

	}

	public static void ASN_Verification_TAP_Order() throws InterruptedException, IOException, AWTException {

		// Robot robot = new Robot();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver, setupObj.UsersI).click();
//	DriverClass.elementclick(setupObj.UsersI);
//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.CPI).click();
		Report.testLog(true, "Logged in as CPI Integration");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.TAPCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date :" + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name :" + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber).sendKeys(PropertyManager.getInstance().getPONumber());
//	Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number :" + PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor).click();

		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
		 * .sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		 * Report.testLog(true, "Enter Delivery Attention: " +
		 * PropertyManager.getInstance().getDeliveryAttention());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
		 * .sendKeys(PropertyManager.getInstance().getPreparedfor());
		 * Report.testLog(true, "Enter Prepared for " +
		 * PropertyManager.getInstance().getPreparedfor()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Accountdeliverynotes).click(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderEdit).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB2).isDisplayed();
		System.out.println("Element ASN checkbox is visible");
		boolean SendASN = DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB3).isSelected();
//	System.out.println("status is: " + SendASN);

		if (!(SendASN) == true) {
			System.out.println("Send ASN field is unchecked");
			Report.testLog(true, "Send ASN field is unchecked");
		} else {
			System.out.println("Send ASN field is checked");
			Report.testLog(true, "Send ASN field is checked");
		}

	}

	public static void ASN_Verification_TAP_Order_for_Event() throws InterruptedException, IOException, AWTException {

		// Robot robot = new Robot();

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver, setupObj.UsersI).click();
//	DriverClass.elementclick(setupObj.UsersI);
//	DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.CPI).click();
		Report.testLog(true, "Logged in as CPI Integration");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.TAPEventsCheckbox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date :" + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Enter Account Name :" + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber).sendKeys(PropertyManager.getInstance().getPONumber());
//	Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Enter Phone Number :" + PropertyManager.getInstance().getPhone());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor).click();

		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
		 * .sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		 * Report.testLog(true, "Enter Delivery Attention: " +
		 * PropertyManager.getInstance().getDeliveryAttention());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
		 * .sendKeys(PropertyManager.getInstance().getPreparedfor());
		 * Report.testLog(true, "Enter Prepared for " +
		 * PropertyManager.getInstance().getPreparedfor()); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.Accountdeliverynotes).click(); DriverClass.waitfor();
		 */

		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderDetailstab).click();
		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeClickable(driver, orderObj.OrderEdit).click();
//	DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB2).isDisplayed();
		System.out.println("Element ASN checkbox is visible");
		boolean SendASN = DriverClass.waitTillElementTobeVisible(driver, orderObj.SendASNCB2).isSelected();
//	System.out.println("status is: " + SendASN);

		if (!(SendASN) == true) {
			System.out.println("Send ASN field is unchecked");
			Report.testLog(true, "Send ASN field is unchecked");
		} else {
			System.out.println("Send ASN field is checked");
			Report.testLog(true, "Send ASN field is checked");
		}

	}

	public static void Decimal_Value_Verification_BrewOnly_PreScheduledVenue()
			throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.sapAccount);
		DriverClass.waitfor();
	//	DriverClass.elementclick(accountObj.EditAccount);
		DriverClass.elementclick(accountObj.EditSBUXBrewOnlyVenue);
		//DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.waitfor(); 
	
		DriverClass.waitTillElementTobeVisible(driver,accountObj.BrewOnlyPSV).clear();
	//	DriverClass.waitfor(); 
		DriverClass.waitTillElementTobeVisible(driver,accountObj.BrewOnlyPSV).sendKeys("1.8");
		Report.testLog(true, "Brew Only Prescheduled Venues: 1.8");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
		
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		
		DriverClass.waitfor();
		Assertion_Functions.SBUXBrewOnlyDecimalErrorValidation();
		DriverClass.waitfor();
	}

	public static void Decimal_Value_Verification_Espresso_PreScheduledVenue()
			throws InterruptedException, IOException, AWTException {
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
				.sendKeys(PropertyManager.getInstance().getAccountname());
		Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.sapAccount);
		DriverClass.waitfor();
	//	DriverClass.elementclick(accountObj.EditAccount);
		DriverClass.elementclick(accountObj.EditSBUXEspressoVenue);
		
		
	//	DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.waitfor(); 
		DriverClass.waitTillElementTobeVisible(driver,accountObj.EspressoPSV).clear();
		DriverClass.waitfor(); 
		DriverClass.waitTillElementTobeVisible(driver,accountObj.EspressoPSV).sendKeys("1.8");
		Report.testLog(true, "Espresso Prescheduled venue: 1.8");
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		
		
		/*
		 * if (DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SBUXActivecb).isSelected()) {
		 * 
		 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
		 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
		 * 
		 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
		 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
		 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
		 * // DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.elementclick(accountObj.Savebutton);
		 * 
		 * } else { DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.SBUXActivecb).click(); //
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp()
		 * ); DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
		 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
		 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
		 * // DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
		 * DriverClass.elementclick(accountObj.Savebutton); }
		 */
		DriverClass.waitfor();
		Assertion_Functions.SBUXEspressoDecimalErrorValidation();
		DriverClass.waitfor();
	}


public static void Decimal_Value_Verification_Frappuccino_PreScheduledVenue()
		throws InterruptedException, IOException, AWTException {
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Users);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Userssub);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();

	try {

		driver.switchTo().frame(0);
	}

	catch (Exception e) {
		System.out.println("Not able to view Frame");
	}

	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
	Report.testLog(true, "Logged in as NCP Sales");
	DriverClass.waitfor();
	DriverClass.waitfor();
	driver.switchTo().defaultContent();

	DriverClass.elementclick(homeObj.Accountlink);
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
			.sendKeys(PropertyManager.getInstance().getAccountname());
	Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.sapAccount);
	DriverClass.waitfor();
//	DriverClass.elementclick(accountObj.EditAccount);
	DriverClass.elementclick(accountObj.EditSBUXFrappuccinoVenue);
	
	
//	DriverClass.waitfor();
//	DriverClass.waitfor();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.FrappuccinoPSV).clear();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.FrappuccinoPSV).sendKeys("1.8");
	Report.testLog(true, "Frappuccino Prescheduled venue: 1.8");
	DriverClass.waitfor();
	
	DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.SavebtnReport);
	
	
	/*
	 * if (DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).isSelected()) {
	 * 
	 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
	 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
	 * 
	 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton);
	 * 
	 * } else { DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).click(); //
	 * DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp()
	 * ); DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton); }
	 */
	DriverClass.waitfor();
	Assertion_Functions.SBUXEspressoDecimalErrorValidation();
	DriverClass.waitfor();
}


public static void Decimal_Value_Verification_Refreshers_PreScheduledVenue()
		throws InterruptedException, IOException, AWTException {
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Users);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Userssub);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();

	try {

		driver.switchTo().frame(0);
	}

	catch (Exception e) {
		System.out.println("Not able to view Frame");
	}

	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
	Report.testLog(true, "Logged in as NCP Sales");
	DriverClass.waitfor();
	DriverClass.waitfor();
	driver.switchTo().defaultContent();

	DriverClass.elementclick(homeObj.Accountlink);
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
			.sendKeys(PropertyManager.getInstance().getAccountname());
	Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.sapAccount);
	DriverClass.waitfor();
//	DriverClass.elementclick(accountObj.EditAccount);
	DriverClass.elementclick(accountObj.EditSBUXRefreshersVenue);
	
	
//	DriverClass.waitfor();
//	DriverClass.waitfor();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.RefreshersPSV).clear();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.RefreshersPSV).sendKeys("1.8");
	Report.testLog(true, "Refreshers Prescheduled venue: 1.8");
	DriverClass.waitfor();
	
	DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.SavebtnReport);
	
	
	/*
	 * if (DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).isSelected()) {
	 * 
	 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
	 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
	 * 
	 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton);
	 * 
	 * } else { DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).click(); //
	 * DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp()
	 * ); DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton); }
	 */
	DriverClass.waitfor();
	Assertion_Functions.SBUXEspressoDecimalErrorValidation();
	DriverClass.waitfor();
}


public static void Decimal_Value_Verification_ColdBrew_PreScheduledVenue()
		throws InterruptedException, IOException, AWTException {
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Users);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Userssub);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();

	try {

		driver.switchTo().frame(0);
	}

	catch (Exception e) {
		System.out.println("Not able to view Frame");
	}

	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
	Report.testLog(true, "Logged in as NCP Sales");
	DriverClass.waitfor();
	DriverClass.waitfor();
	driver.switchTo().defaultContent();

	DriverClass.elementclick(homeObj.Accountlink);
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
			.sendKeys(PropertyManager.getInstance().getAccountname());
	Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.sapAccount);
	DriverClass.waitfor();
//	DriverClass.elementclick(accountObj.EditAccount);
	DriverClass.elementclick(accountObj.ColdBrewVenue);
	
	
//	DriverClass.waitfor();
//	DriverClass.waitfor();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.ColdBrewPSV).clear();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.ColdBrewPSV).sendKeys("1.8");
	Report.testLog(true, "Cold Brew Prescheduled venue: 1.8");
	DriverClass.waitfor();
	
	DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.SavebtnReport);
	
	
	/*
	 * if (DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).isSelected()) {
	 * 
	 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
	 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
	 * 
	 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton);
	 * 
	 * } else { DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).click(); //
	 * DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp()
	 * ); DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton); }
	 */
	DriverClass.waitfor();
	Assertion_Functions.SBUXEspressoDecimalErrorValidation();
	DriverClass.waitfor();
}

public static void Decimal_Value_Verification_ColdFoam_PreScheduledVenue()
		throws InterruptedException, IOException, AWTException {
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Users);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Userssub);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();

	try {

		driver.switchTo().frame(0);
	}

	catch (Exception e) {
		System.out.println("Not able to view Frame");
	}

	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
	Report.testLog(true, "Logged in as NCP Sales");
	DriverClass.waitfor();
	DriverClass.waitfor();
	driver.switchTo().defaultContent();

	DriverClass.elementclick(homeObj.Accountlink);
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
			.sendKeys(PropertyManager.getInstance().getAccountname());
	Report.testLog(true, "account:" + PropertyManager.getInstance().getAccountname());
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.sapAccount);
	DriverClass.waitfor();
//	DriverClass.elementclick(accountObj.EditAccount);
	DriverClass.elementclick(accountObj.ColdFoamVenue);
	
	
//	DriverClass.waitfor();
//	DriverClass.waitfor();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.ColdFoamPSV).clear();
	DriverClass.waitfor(); 
	DriverClass.waitTillElementTobeVisible(driver,accountObj.ColdFoamPSV).sendKeys("1.8");
	Report.testLog(true, "Cold Foam Prescheduled venue: 1.8");
	DriverClass.waitfor();
	
	DriverClass.waitTillElementTobeVisible(driver,accountObj.AuthorizationNotes).sendKeys("1");
	DriverClass.waitfor();
	DriverClass.elementclick(accountObj.SavebtnReport);
	
	
	/*
	 * if (DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).isSelected()) {
	 * 
	 * DriverClass.waitTillElementTobeVisible(driver, accountObj.BrewOnlyPPS)
	 * .sendKeys(PropertyManager.getInstance().getStatusOpp());
	 * 
	 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton);
	 * 
	 * } else { DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.SBUXActivecb).click(); //
	 * DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(PropertyManager.getInstance().getStatusOpp()
	 * ); DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).click(); Actions act = new Actions(driver);
	 * act.moveToElement(accountObj.NCPAccountStatusNone).click().perform();
	 * Report.testLog(true, "SBUX Brew only Portion pack size is changed to None");
	 * // DriverClass.waitTillElementTobeVisible(driver,
	 * accountObj.BrewOnlyPPS).sendKeys(Keys.ENTER); DriverClass.waitfor();
	 * DriverClass.elementclick(accountObj.Savebutton); }
	 */
	DriverClass.waitfor();
	Assertion_Functions.SBUXEspressoDecimalErrorValidation();
	DriverClass.waitfor();
}

public static void Restricting_NA_Product_To_TAQuote() throws InterruptedException, IOException, AWTException {
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Users);
	DriverClass.waitfor();
	DriverClass.elementclick(setupObj.Userssub);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitfor();

	try {

		driver.switchTo().frame(0);
	}

	catch (Exception e) {
		System.out.println("Not able to view Frame");
	}

	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
	Report.testLog(true, "Logged in as NCP Sales");
	DriverClass.waitfor();
	DriverClass.waitfor();
	driver.switchTo().defaultContent();

	DriverClass.elementclick(homeObj.Objectsearch);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2)
			.sendKeys(PropertyManager.getInstance().getObjectSearchQuotes());
	DriverClass.waitfor();
	Report.testLog(true, "Searched for" + PropertyManager.getInstance().getObjectSearchQuotes());
	DriverClass.waitTillElementTobeVisible(driver, homeObj.Objectsearch2).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, homeObj.TAQuote).click();
	DriverClass.waitfor();
	Report.testLog(true, "TA Quote is selected");
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.AddProducts).click();
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
	.sendKeys(PropertyManager.getInstance().getNAProduct());
	Report.testLog(true, "Product with NA equipment type is selected");
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
	DriverClass.waitfor();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.prodcheckox).click();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn2).click();
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
	DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");

	DriverClass.waitfor();
	Report.testLog(true, "Quantity is selected as 2");
	
	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
	Actions act = new Actions(driver);
	act.moveToElement(orderObj.OwnershipBtn).click().perform();
	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
	DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
	Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
	DriverClass.waitfor();
	DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
	DriverClass.waitfor();
	
	String NAError = DriverClass.waitTillElementTobeVisible(driver, orderObj.Erroricon).getText();
	DriverClass.waitfor();
	if(DriverClass.waitTillElementTobeVisible(driver, orderObj.Erroricon).isDisplayed()) {
		System.out.println(NAError);
		Report.testLog(true, NAError);
	}
	else {
		System.out.println("No error");
		Report.testLog(true, "No error and the product is added successfully");
	}
}
	
	public static void Blanket_PO_Number_Verification_with_Special_Characters() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
		  
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */
		
		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditBlanketPONumber).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditBlanketPONumberfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditBlanketPONumberfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		Report.testLog(true, "Blanket PO Number : SAP@12");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		
		/*
		 * String BlanketPO = DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BlanketPONumber).getText(); System.out.println(BlanketPO);
		 * Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		 * DriverClass.waitfor();
		 */
	
		
		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
	
	public static void DoingBusinessAs_Verification_with_Special_Characters() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
	
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */
		
		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditDBA).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditDBAfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditDBAfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		Report.testLog(true, "Doing Business As : SAP@12");
		
		/*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		
	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
		
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
	//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		
		/*
		 * String BlanketPO = DriverClass.waitTillElementTobeVisible(driver,
		 * accountObj.BlanketPONumber).getText(); System.out.println(BlanketPO);
		 * Report.testLog(true, "Blanket PO Number :" + BlanketPO);
		 * DriverClass.waitfor();
		 */
		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
	

	public static void ReasonCreditRequired_Verification_with_Special_Characters() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
	
		 
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		/*
		 * WebElement a =
		 * driver.findElement(By.xpath("//input[@type='text' and @aria-required='true']"
		 * )); String ab = a.getText(); System.out.println(ab);
		 */
		
		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANR).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditRCANRfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Reason Credit Application Not Required : SAP@12");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}

	public static void PSS_PO_Number_Negative_Validation() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.ncpISAR_DanielsonDianeLogin);
		Report.testLog(true, "Logged in as NCP ISAR Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Objectsearch);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCPPSS);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "navigated to PSS Application");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PSSType).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.SeasonalPromotion).click();

		Report.testLog(true, "Seasonal Promotion is selected as Program type");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeason).click();

		DriverClass.waitTillElementTobeVisible(driver, homeObj.PromoSeasonFall).click();

		Report.testLog(true, "Promo Season is selected as Fall");
		String Year = DriverClass.waitTillElementTobeVisible(driver, homeObj.YearPSS).getText();
		System.out.println(Year);

		/*
		 * Date todaydate = new Date(); 
		 * String POIdentifier = todaydate.toString();
		 * POIdentifier = POIdentifier.substring(0, 10);
		 * DriverClass.waitTillElementTobeVisible(driver,homeObj.UPI).sendKeys(POIdentifier); 
		 * DriverClass.waitfor();
		 */
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver,homeObj.UPI).sendKeys("12345678910"); 
		Report.testLog(true, "PO Identifier: 12345678910");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.ShipDate).click();
		DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		Report.testLog(true, "Date is selected");
		Actions act = new Actions(driver);
		act.moveToElement(homeObj.PreviewNext).click().perform();
		DriverClass.waitfor();
		String PONumberError = DriverClass.waitTillElementTobeVisible(driver, homeObj.PONumberError).getText();
		System.out.println(PONumberError);
		DriverClass.waitfor();
		Assertion_Functions.PONumberErrorValidation();
		DriverClass.waitfor();
			
	}
	
	public static void OrderSubmission_withoutProduct() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.NCPSalesLogin);
		Report.testLog(true, "Logged in as NCP Sales Successfully");

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		driver.switchTo().defaultContent();
		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Status).sendKeys(Keys.ENTER);
		
		
		  robot.keyPress(KeyEvent.VK_ENTER); 
		  robot.keyRelease(KeyEvent.VK_ENTER);
		 
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionFG)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitfor();

		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PreparedforFG)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		

		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();
		
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
	
		Report.testLog(true, "Status is changed to Ready to Submit");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		Assertion_Functions.OrderSubmitValidation_Without_Product_Error();
		DriverClass.waitfor();
			
	}

	
	

	public static void OrderSubmission_Submit_Without_Product() throws InterruptedException, IOException, AWTException {
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		if(DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).isDisplayed()) {
			System.out.println("Users button is displayed");
		}else {
			System.out.println("Users button is not displayed");
		}
		
		
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		
		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();
		Robot robot = new Robot();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status).sendKeys(Keys.ENTER);
		
		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Enter Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		/*
		 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_ENTER);
		 * robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		Report.testLog(true, "Enter Account Name " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumberTAP)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "Enter PO Number " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttentionFG)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitfor();

		Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PreparedforFG)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		

		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();
		
		DriverClass.elementclick(orderObj.Changestatus);
		DriverClass.waitfor();
		DriverClass.waitfor();
	
		Report.testLog(true, "Status is changed");

		DriverClass.elementclick(orderObj.OrderSubmitButton);
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		Assertion_Functions.OrderSubmitValidation_Without_Product_Error();
		DriverClass.waitfor();
	}
	
	public static void FSM_ValidFrom_negative() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: Sample Order Account");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidFromAccount).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.FSMValidFromAccount).click();
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
		
		DriverClass.waitTillElementTobeVisible(driver, setupObj.taskDate).click();
		DriverClass.waitfor();
		Report.testLog(true, "FSM Valid From is given as todays date");
	
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Savebutton).click();
		DriverClass.waitfor();

		Assertion_Functions.FSMValidFromErrorValidation();
	}
	

    public static void NewLead_Disqualified_Reason_Negative() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();

			DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLink);
			Report.testLog(true, "Navigated to Leads Object");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLV);
			Report.testLog(true, "Navigated to Leads List view");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.MyLeads);
			Report.testLog(true, "Navigated to My Leads");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.NCL);
			Report.testLog(true, "Navigated to New Customer Lead");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.EditStatus);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys("Disqualified");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.ContactSave);
			DriverClass.waitfor();
			Report.testLog(true, "Status is changed to Disqualified");
			Assertion_Functions.DisqualifiedError();
			DriverClass.waitfor();
	}
    
    public static void New_Customer_Lead_Intake_Disqualified_Reason_Negative() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();

		DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.LeadsLV);
		Report.testLog(true, "Navigated to Leads List view");
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.MyLeads);
		Report.testLog(true, "Navigated to My Leads");
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.NCLI);
		Report.testLog(true, "Navigated to New Customer Lead intake");
		DriverClass.waitfor();
		
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.EditStatus);
	/*
	 * if(DriverClass.waitTillElementTobeVisible(driver,
	 * homeObj.EditStatus).isDisplayed()) {
	 * System.out.println("status is editable"); }else {
	 * System.out.println("status is not editable"); }
	 */
	//	DriverClass.waitTillElementTobeVisible(driver, homeObj.EditStatus).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDDNCLI).sendKeys("Disqualified");
		DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDDNCLI).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.ContactSave);
		DriverClass.waitfor();
		Report.testLog(true, "Status is changed to Disqualified");
		Assertion_Functions.DisqualifiedError();
		DriverClass.waitfor();
}
    
    public static void Existing_Customer_Lead_Intake_Disqualified_Reason_Negative() throws AWTException, IOException, InterruptedException {
  		// Robot robot = new Robot();

  		DriverClass.waitfor();
//  	DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
  		DriverClass.elementclick(setupObj.Users);
  		DriverClass.waitfor();
  		DriverClass.elementclick(setupObj.Userssub);
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.waitfor();

  		try {

  			driver.switchTo().frame(0);
  		}

  		catch (Exception e) {
  			System.out.println("Not able to view Frame");
  		}

  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
  		Report.testLog(true, "Logged in as NCP Sales");
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		driver.switchTo().defaultContent();
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.LeadsLink);
  		Report.testLog(true, "Navigated to Leads Object");
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.LeadsLV);
  		Report.testLog(true, "Navigated to Leads List view");
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.MyLeads);
  		Report.testLog(true, "Navigated to My Leads");
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.ECLI);
  		Report.testLog(true, "Navigated to Existing Customer Lead intake");
  		DriverClass.waitfor();
  		
  		for (String handle : driver.getWindowHandles()) {
  			driver.switchTo().window(handle);
  		}
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.EditStatus);
  	/*
  	 * if(DriverClass.waitTillElementTobeVisible(driver,
  	 * homeObj.EditStatus).isDisplayed()) {
  	 * System.out.println("status is editable"); }else {
  	 * System.out.println("status is not editable"); }
  	 */
  	//	DriverClass.waitTillElementTobeVisible(driver, homeObj.EditStatus).click();
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys("Disqualified");
  		DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys(Keys.ENTER);
  		DriverClass.waitfor();
  		DriverClass.elementclick(homeObj.ContactSave);
  		DriverClass.waitfor();
  		Report.testLog(true, "Status is changed to Disqualified");
  		Assertion_Functions.DisqualifiedError();
  		DriverClass.waitfor();
    }
    
    public static void Tax_Exempt_Editable_Prospect_Account() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
    	DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
	
		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptEditIcon).click();
		DriverClass.waitfor();
		
		  Actions action = new Actions(driver);
		  action.moveToElement(accountObj.EditRCANRfield);
		  action.perform();
		  DriverClass.waitfor();
		  
		    DriverClass.elementclick(accountObj.TaxExemptNo);
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptNo).sendKeys("Yes");
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptNo).sendKeys(Keys.ENTER);
			Report.testLog(true, "Tax exempt is changed to Yes");
			
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SavebtnReport).click();
			DriverClass.waitfor();
			Report.testLog(true, "Tax exempt field is editable");
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptEditIcon).click();
			DriverClass.waitfor();
		  
			DriverClass.elementclick(accountObj.TaxExemptYes);
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptYes).sendKeys("No");
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaxExemptYes).sendKeys(Keys.ENTER);
		  
		  
		  
			/*
			 * if(DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptNo).isDisplayed()) {
			 * DriverClass.elementclick(accountObj.TaxExemptNo);
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptNo).sendKeys("Yes"); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptNo).sendKeys(Keys.ENTER); } else
			 * if(DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptYes).isDisplayed()) {
			 * DriverClass.elementclick(accountObj.TaxExemptYes);
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptYes).sendKeys("No"); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptYes).sendKeys(Keys.ENTER); } else {
			 * DriverClass.elementclick(accountObj.TaxExemptNone);
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptNone).sendKeys("No"); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.TaxExemptNone).sendKeys(Keys.ENTER); }
			 */
		
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SavebtnReport).click();
		DriverClass.waitfor();
    }
    
    public static void OnboardingNotes_Verification_with_Special_Characters() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
	
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");
//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccount).click();
//	DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// accountObj.DeliveryNotes).click();
//    DriverClass.waitfor();

		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditDBA).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditDBAfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditDBAfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		Report.testLog(true, "Doing Business As : SAP@12");
		
		/*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		
	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
		
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
	//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		
		
		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
	
    
    public static void FG_SAPPrice_Change() throws InterruptedException, IOException, AWTException {
    	DriverClass.waitfor();
    	DriverClass.waitfor();
    	DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		
		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGCheckox);
		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date: " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Name: " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "PO Number: " + PropertyManager.getInstance().getPONumber());

	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention).sendKeys(PropertyManager.getInstance().getDeliveryAttention());
	//	Report.testLog(true, "Enter Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor).sendKeys(PropertyManager.getInstance().getPreparedfor());
	//	Report.testLog(true, "Enter Prepared for " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		
		 DriverClass.elementclick(orderObj.AddProducts); 
		 DriverClass.waitfor();
		/* DriverClass.elementclick(orderObj.FGProduct); DriverClass.waitfor();
		 * Report.testLog(true, "1 Gallon Pitcher is added");
		 */
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Product name: " + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).sendKeys("22");
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
//		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodDD);
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.elementclick(orderObj.DDEdit);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).click();
	//	DriverClass.waitfor();
		
		act.doubleClick(orderObj.SAPSalesPrice).perform();
		DriverClass.waitfor();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(orderObj.SAPSalesPrice); DriverClass.waitfor();
		 * DriverClass.waitTillElementTobeVisible(driver,
		 * orderObj.SAPSalesPrice).clear(); DriverClass.waitfor();
		 * DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).sendKeys("9");
		DriverClass.waitfor();
		Report.testLog(true, "Product Sales Price is changed to 2");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PrQ).click();
	//	DriverClass.elementclick(orderObj.PrQ);
		DriverClass.waitfor();
		
		
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Assertion_Functions.SAPSalesPriceError();
		DriverClass.waitfor();
	}
	
    public static void FGSampleOrder_SAPPrice_Error() throws InterruptedException, IOException, AWTException {
    	DriverClass.waitfor();
    	DriverClass.waitfor();
    	DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		Report.testLog(true, "Navigated to Order Object");
		Report.testLog(true, "Click on create new order");
		DriverClass.elementclick(orderObj.NewOrderButton);
		DriverClass.elementclick(orderObj.FGSampleCheckox);
		Report.testLog(true, "FG SAmple Order is selcted");

		DriverClass.elementclick(orderObj.Nextbtn);
		DriverClass.waitfor();

		// DriverClass.elementsendvalues(PropertyManager.getInstance().getOrderDate(),orderObj.Orderdate);
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getStatus(),orderObj.Status);

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date: " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Name: " + PropertyManager.getInstance().getSampleAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "PO Number: " + PropertyManager.getInstance().getPONumber());

		/*
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention)
		 * .sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		 * Report.testLog(true, "Delivery Attention: " +
		 * PropertyManager.getInstance().getDeliveryAttention());
		 * DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor)
		 * .sendKeys(PropertyManager.getInstance().getPreparedfor());
		 * Report.testLog(true, "Prepared for: " +
		 * PropertyManager.getInstance().getPreparedfor()); DriverClass.waitfor();
		 */
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountdeliverynotes).click();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.waitfor();

//		Report.testLog(true, "Enter Product name " + PropertyManager.getInstance().getProduct());

		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_RIGHT);
		robot.keyRelease(KeyEvent.VK_RIGHT);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductnew());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodDD);
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.elementclick(orderObj.DDEdit);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).click();
	//	DriverClass.waitfor();
		
		act.doubleClick(orderObj.SAPSalesPrice).perform();
		DriverClass.waitfor();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		DriverClass.waitfor();
	
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).sendKeys("9");
		DriverClass.waitfor();
		Report.testLog(true, "Product Sales Price is changed to 9");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PrQ).click();
	//	DriverClass.elementclick(orderObj.PrQ);
		DriverClass.waitfor();
		
		
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Assertion_Functions.SAPSalesPriceError();
		DriverClass.waitfor();
    }
    
    public static void TAPOrder_SAPPrice_Error() throws InterruptedException, IOException, AWTException {
    	DriverClass.waitfor();
		DriverClass.waitfor();
    	DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPCheckox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		DriverClass.waitfor();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.EquipmentType).sendKeys(PropertyManager.getInstance().getStatus());
		// act.moveToElement(orderObj.Espresso).click().perform();

		// DriverClass.waitTillElementTobeVisible(driver,contactObj.AccountNameContact).sendKeys(Keys.ENTER);
		// Report.testLog(true, "Equipment type selected");
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getOrderAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);

		Report.testLog(true, "Account Name: " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "PO Number: " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Retrieval Installation: " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phonenum)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Phone Number: " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Prepared for: " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAP());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Product name: " + PropertyManager.getInstance().getProduct());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
//		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();
		DriverClass.waitfor();
		
		DriverClass.elementclick(orderObj.prodDD);
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.elementclick(orderObj.DDEdit);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).click();
	//	DriverClass.waitfor();
		
		act.doubleClick(orderObj.SAPSalesPrice).perform();
		DriverClass.waitfor();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		DriverClass.waitfor();
	
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).sendKeys("9");
		DriverClass.waitfor();
		Report.testLog(true, "Product Sales Price is changed to 9");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PrQ).click();
	//	DriverClass.elementclick(orderObj.PrQ);
		DriverClass.waitfor();
		
		
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Assertion_Functions.SAPSalesPriceError();
		DriverClass.waitfor();
    }
		
    public static void TAPOrderForEvents_SAPPrice_Error() throws InterruptedException, IOException, AWTException {
    	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		/*
		 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
		 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
		 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
		 */
		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.OrderLink);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.NewOrderButton).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.TAPEventsCheckbox).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Nextbtn).click();
		DriverClass.waitfor();
		// Robot robot = new Robot();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Status)
				.sendKeys(PropertyManager.getInstance().getStatus());
		Actions act = new Actions(driver);
		act.moveToElement(orderObj.draft).click().perform();
		Report.testLog(true, "Click on New Status");
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.Status).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.EquipmentType)
				.sendKeys(PropertyManager.getInstance().getStatus());
		act.moveToElement(orderObj.Espresso).click().perform();
		Report.testLog(true, "Equipment type selected");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Orderdate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Order Date: " + PropertyManager.getInstance().getOrderDate());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname)
				.sendKeys(PropertyManager.getInstance().getSampleAccount());
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Accountname).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Name: " + PropertyManager.getInstance().getOrderAccount());
		// DriverClass.waitTillElementTobeVisible(driver,orderObj.).sendKeys(PropertyManager.getInstance().getOrdersapnumber());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PONumber)
				.sendKeys(PropertyManager.getInstance().getPONumber());
		Report.testLog(true, "PO Number: " + PropertyManager.getInstance().getPONumber());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.RetrievalInstallation)
				.sendKeys(PropertyManager.getInstance().getRetrievalInstallation());
		Report.testLog(true, "Retrival Installation: " + PropertyManager.getInstance().getRetrievalInstallation());

		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, orderObj.Phone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Phone Number: " + PropertyManager.getInstance().getPhone());

		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryAttention2)
				.sendKeys(PropertyManager.getInstance().getDeliveryAttention());
		Report.testLog(true, "Delivery Attention: " + PropertyManager.getInstance().getDeliveryAttention());
		DriverClass.waitTillElementTobeVisible(driver, orderObj.Preparedfor2)
				.sendKeys(PropertyManager.getInstance().getPreparedfor());
		Report.testLog(true, "Prepared for: " + PropertyManager.getInstance().getPreparedfor());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.DeliveryNotes2).click();
		DriverClass.waitfor();
		Assertion_Functions.OrderCreation_Validation();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Savebtn);
		DriverClass.waitfor();
		DriverClass.waitfor();
		String Orderno = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		Report.testLog(true, "Order " + Orderno + " is created Successfully");
		DriverClass.elementclick(orderObj.AddProducts);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod)
				.sendKeys(PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.searchprod).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		Report.testLog(true, "Product name: " + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.prodcheckox);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(orderObj.Nextbtn2);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.quantitySearch).click();
		DriverClass.waitTillElementTobeClickable(driver, orderObj.qtyInput).sendKeys("2");

		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipBtn).click();
		act.moveToElement(orderObj.OwnershipBtn).click().perform();

		DriverClass.waitfor();
		// DriverClass.waitTillElementTobeVisible(driver,
		// orderObj.OwnershipSelect).sendKeys(PropertyManager.getInstance().getOwnershipStatus());
		// DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.DOWN);
		DriverClass.waitTillElementTobeVisible(driver, orderObj.OwnershipSelect).sendKeys(Keys.ENTER);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Ownership status is: " + PropertyManager.getInstance().getOwnershipStatus());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, orderObj.prodsave).click();

		// DriverClass.elementclick(orderObj.prodsave);
//		Report.testLog(true, "Product added is :" + PropertyManager.getInstance().getProductTAPSubmit());
		DriverClass.waitfor();

		// Assertion_Functions.OrderSubmitValidation();
		String Orderno2 = DriverClass.waitTillElementTobeVisible(driver, orderObj.ordernumber).getText();
		DriverClass.waitfor();

		DriverClass.elementclick(orderObj.prodDD);
		DriverClass.waitfor();
	//	DriverClass.waitfor();
		DriverClass.elementclick(orderObj.DDEdit);
		DriverClass.waitfor();
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).click();
	//	DriverClass.waitfor();
		
		act.doubleClick(orderObj.SAPSalesPrice).perform();
		DriverClass.waitfor();
		act.sendKeys(Keys.BACK_SPACE).build().perform();
		DriverClass.waitfor();
	
		DriverClass.waitTillElementTobeVisible(driver, orderObj.SAPSalesPrice).sendKeys("9");
		DriverClass.waitfor();
		Report.testLog(true, "Product Sales Price is changed to 9");
		DriverClass.waitTillElementTobeVisible(driver, orderObj.PrQ).click();
	//	DriverClass.elementclick(orderObj.PrQ);
		DriverClass.waitfor();
		
		
		DriverClass.elementclick(orderObj.prodsave);
		DriverClass.waitfor();
		Assertion_Functions.SAPSalesPriceError();
		DriverClass.waitfor();
    }
    
    public static void UnitNumber_Verification_with_Special_Characters_Existing_ProspectAccount() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
	
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.AccountLinkDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.AllAcountSelection);
		DriverClass.waitfor();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform(); 
		DriverClass.waitfor();
		
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");

		
		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditUnitNumber).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditUNfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditUNfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		Report.testLog(true, "Unit Number : SAP@12");
		
		/*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		
	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
		
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
	//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		

		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
    public static void AccountName_Verification_with_Special_Characters_Existing_ProspectAccount() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
	
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.AccountLinkDropdown);
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.AllAcountSelection);
		DriverClass.waitfor();
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform(); 
		DriverClass.waitfor();
		
		Report.testLog(true, "Navigated to Account Object");
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Accountname).click();
		DriverClass.waitfor();
		Report.testLog(true, "Account Selected: ac11");

		
		
		// System.out.println(a);
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditAccountName).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.EditANfield).clear();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeClickable(driver, accountObj.EditANfield).sendKeys("SAP@12");
		DriverClass.waitfor();
		Report.testLog(true, "Account Name : SAP@12");
		
		/*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		
	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
		
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
	//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SavebtnReport);
		

		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
    
    public static void AccountName_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
  		// Robot robot = new Robot();
  		
  		  DriverClass.waitfor();
  		  DriverClass.waitfor(); 
  		  DriverClass.waitfor();
  		
  			DriverClass.elementclick(setupObj.Users);
  			DriverClass.waitfor();
  			DriverClass.elementclick(setupObj.Userssub);
  			DriverClass.waitfor();
  			DriverClass.waitfor();
  		
  			Robot robot = new Robot();
  			/*
  			 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
  			 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
  			 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
  			 */
  			try {

  				driver.switchTo().frame(0);
  			}

  			catch (Exception e) {
  				System.out.println("Not able to view Frame");
  			}

  			DriverClass.waitfor();
  			DriverClass.waitfor();
  			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
  			Report.testLog(true, "Logged in as NCP Sales");
  			DriverClass.waitfor();
  			DriverClass.waitfor();
  			driver.switchTo().defaultContent();
  		 

  		DriverClass.elementclick(homeObj.Accountlink);
  		DriverClass.waitfor();
  		DriverClass.waitfor();
  		
  		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
  		Report.testLog(true, "Navigated to Account Section");

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName).sendKeys("L@test");
  		Report.testLog(true, "Acocunt Name Entered : L@test");
  		DriverClass.waitfor();

  		robot.keyPress(KeyEvent.VK_DOWN);
  		robot.keyRelease(KeyEvent.VK_DOWN);
  		robot.keyPress(KeyEvent.VK_ENTER);
  		robot.keyRelease(KeyEvent.VK_ENTER);
  		DriverClass.waitfor();
  		
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
  				.sendKeys(PropertyManager.getInstance().getOrderDate());
  		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
  				.sendKeys(PropertyManager.getInstance().getPhone());
  		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
  				.sendKeys(PropertyManager.getInstance().getCity());
  		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
  				.sendKeys(PropertyManager.getInstance().getState());
  		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
  		DriverClass.waitfor();
  		robot.keyPress(KeyEvent.VK_ENTER);
  		robot.keyRelease(KeyEvent.VK_ENTER);
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
  		DriverClass.waitfor();
  		DriverClass.waitfor();

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
  				.sendKeys(PropertyManager.getInstance().getChannel());
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
  		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
  		DriverClass.waitfor();

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
  				.sendKeys(PropertyManager.getInstance().getRoute());
  		robot.keyPress(KeyEvent.VK_ENTER);
  		robot.keyRelease(KeyEvent.VK_ENTER);
  		Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
  				.sendKeys(PropertyManager.getInstance().getSegment());
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
  		// robot.keyPress(KeyEvent.VK_ENTER);
  		// robot.keyRelease(KeyEvent.VK_ENTER);
  		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
  		DriverClass.waitfor();
  		DriverClass.elementclick(accountObj.SubSegmentDep);
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
  		DriverClass.waitfor();
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
  		DriverClass.waitfor();
  	
  		DriverClass.elementclick(accountObj.Subsegmentapply);
  		DriverClass.waitfor();
  	
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
  				.sendKeys(PropertyManager.getInstance().getRegion());
  		robot.keyPress(KeyEvent.VK_ENTER);
  		robot.keyRelease(KeyEvent.VK_ENTER);
  		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
  		DriverClass.waitfor();

  		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
  				.sendKeys(PropertyManager.getInstance().getBanner());
  		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
  		DriverClass.waitfor();
  		DriverClass.elementclick(accountObj.ApplyChannel);
  		
  		/*
  		 * Actions action = new Actions(driver);
  		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
  		 */
  		
  		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
  		
  	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
  		
  	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
  	//	DriverClass.waitfor();
  		DriverClass.waitfor();
  		DriverClass.elementclick(accountObj.save);
  		

  		DriverClass.waitfor();
  		Assertion_Functions.SpecialCharactersErrorValidation();
  		DriverClass.waitfor();
  		
  	
  }
    
    public static void UnitNumber_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
		// Robot robot = new Robot();
		
		  DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
		
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
		
			Robot robot = new Robot();
			/*
			 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
			 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
			 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
			 */
			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
		 

		DriverClass.elementclick(homeObj.Accountlink);
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.UnitNumbernew).sendKeys("123#");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
	
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
	
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
				.sendKeys(PropertyManager.getInstance().getBanner());
		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ApplyChannel);
		
		/*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
		
	//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
		
	//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
	//	DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.save);
		

		DriverClass.waitfor();
		Assertion_Functions.SpecialCharactersErrorValidation();
		DriverClass.waitfor();
		
	
}
    
	public static void LeadsCreation_Without_Region() throws InterruptedException, IOException, AWTException {
		 DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
		
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
		
			Robot robot = new Robot();
			/*
			 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
			 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
			 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
			 */
			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
		 
		DriverClass.waitfor();
		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.elementclick(leadsObj.NewButton);
		Report.testLog(true, "Click on create new Lead option.");
	//	DriverClass.elementclick(leadsObj.NextButton);
		DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getAccountName(), leadsObj.Accountname);
		Report.testLog(true, "Account name :" + PropertyManager.getInstance().getAccountName());
		DriverClass.waitfor();
		// DriverClass.elementsendvalues(PropertyManager.getInstance().getSalutation(),
		// leadsObj.Salutation);
		// Report.testLog(true, "Salutation entered:" +
		// PropertyManager.getInstance().getSalutation());
		// DriverClass.waitfor();
		DriverClass.elementsendvalues(PropertyManager.getInstance().getFisrtname(), leadsObj.Firstname);
		Report.testLog(true, "Firstname entered: " + PropertyManager.getInstance().getFisrtname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getMiddlename(), leadsObj.Middlename);
		Report.testLog(true, "Middlename entered : " + PropertyManager.getInstance().getMiddlename());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getLastname(), leadsObj.Lastname);
		Report.testLog(true, "Lastname entered : " + PropertyManager.getInstance().getLastname());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getSuffix(), leadsObj.Suffix);
		Report.testLog(true, "Suffix Entered : " + PropertyManager.getInstance().getSuffix());
		DriverClass.waitfor();
		
		  Actions action = new Actions(driver);
		
		 
	//	  Robot robot = new Robot();
	//	  robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//	  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		DriverClass.elementsendvalues(PropertyManager.getInstance().getCity(), leadsObj.city);
		Report.testLog(true, "City entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitfor();
		// action.sendKeys(Keys.PAGE_DOWN).build().perform();
		// DriverClass.waitfor();
		
		 WebElement scroll = driver.findElement(By.xpath("//input[@name='Phone']"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(scroll);
		  actions.perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.state).click();
		DriverClass.waitfor();
		Actions ac = new Actions(driver);
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
	
		
		 
		
		DriverClass.elementsendvalues(PropertyManager.getInstance().getPhone(), leadsObj.phone);
		Report.testLog(true, "phone entered : " + PropertyManager.getInstance().getPhone());
	
		 WebElement scroll2 = driver.findElement(By.xpath("//div//input[@name='Square_Feet__c']"));
		  actions.moveToElement(scroll2);
		  actions.perform();
		
	//	action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.viewdep);
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.channeltwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Channel entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		/*
		 * DriverClass.elementclick(leadsObj.regiontwo); DriverClass.waitfor();
		 * ac.sendKeys(Keys.ARROW_DOWN).build().perform(); DriverClass.waitfor();
		 * ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		 * ac.sendKeys(Keys.ENTER).build().perform(); Report.testLog(true,
		 * "Region entered : " + PropertyManager.getInstance().getRegion());
		 */
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();
		
		/*
		 * WebElement scroll3 = driver.findElement(By.
		 * xpath("//button[@class='slds-button' and contains(text(),'View all dependencies')])[2]"
		 * )); actions.moveToElement(scroll3); actions.perform();
		 */
		
		DriverClass.elementclick(leadsObj.viewdepsegment);
		DriverClass.elementclick(leadsObj.segmenttwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Segment Entered :" + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.subsegmenttwo);
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ENTER).build().perform();
		Report.testLog(true, "Sub-Segment Entered :" + PropertyManager.getInstance().getSubsegment());
		DriverClass.waitfor();
		DriverClass.elementclick(leadsObj.applybtn);
		DriverClass.waitfor();

	//	 robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	//	 robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	/*
	 * WebElement scroll4 = driver.findElement(By.
	 * xpath("//div[@class='slds-form-element__control']//lightning-base-combobox[@class='slds-combobox_container']//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//div//button[@type='button' and @aria-label='Banner, --None--']"
	 * )); actions.moveToElement(scroll4); actions.perform();
	 */
	//	 WebElement scroll2 = driver.findElement(By.xpath("//div//input[@name='Square_Feet__c']"));
		  actions.moveToElement(scroll2);
		  actions.perform();
	//	  DriverClass.waitfor();
	//	Actions action = new Actions(driver);
	//	action.sendKeys(Keys.PAGE_DOWN).build().perform();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.Banner).click();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
		
		
		 WebElement scroll5 = driver.findElement(By.xpath("//div[@class='slds-form-element__control']//lightning-base-combobox[@class='slds-combobox_container']//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']//div//button[@type='button' and @aria-label='Route To Market, --None--']"));
		  actions.moveToElement(scroll5);
		  actions.perform();
		
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.RoutetoMarket).click();
		DriverClass.waitfor();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		DriverClass.waitfor();
		ac.sendKeys(Keys.ARROW_DOWN).build().perform();
		ac.sendKeys(Keys.ENTER).build().perform();
		DriverClass.waitfor();
	
		DriverClass.elementsendvalues(PropertyManager.getInstance().getStudentno(), leadsObj.studentno);
		Report.testLog(true, "studentno Entered :" + PropertyManager.getInstance().getStudentno());
		DriverClass.elementsendvalues(PropertyManager.getInstance().getEmployeeno(), leadsObj.employeeno);
		Report.testLog(true, "employeeno Entered :" + PropertyManager.getInstance().getEmployeeno());

		DriverClass.elementclick(leadsObj.savebtn);

		// Validation point for leads creation
		DriverClass.waitfor();
		Assertion_Functions.LeadsCreationErrorValidation();

	}
    
	 public static void NewLead_Disqualification() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();

			DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLink);
			Report.testLog(true, "Navigated to Leads Object");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLV);
			Report.testLog(true, "Navigated to Leads List view");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.MyLeads);
			Report.testLog(true, "Navigated to My Leads");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.NCLD);
			Report.testLog(true, "Navigated to a New Customer Lead");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.EditStatus);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys("Disqualified");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			
			DriverClass.elementclick(homeObj.DisqualifiedReason);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, homeObj.DisqualifiedReason).sendKeys("Duplicate");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.DisqualifiedReason).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.ContactSave);
			DriverClass.waitfor();
			Report.testLog(true, "Status is changed to Disqualified");
		//	Assertion_Functions.DisqualifiedError();
			DriverClass.waitfor();
			if(DriverClass.waitTillElementTobeVisible(driver, homeObj.DisqualifiedTab).isDisplayed()) {
				System.out.println("Lead is Disqualified");
				Report.testLog(true, "Lead is Disqualified");
			}else {
				System.out.println("Lead is not Disqualified");
				Report.testLog(true, "Lead is not Disqualified");
			}
			
			DriverClass.elementclick(homeObj.EditStatus);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys("New");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.StatusDD).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			
			DriverClass.elementclick(homeObj.DisqualifiedReason);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, homeObj.DisqualifiedReason).sendKeys("--None--");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.DisqualifiedReason).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.ContactSave);
			
	}
	 
	 
	 public static void Leads_ListViews() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();

			DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLink);
			Report.testLog(true, "Navigated to Leads Object");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLV);
			Report.testLog(true, "Navigated to Leads List view");
			DriverClass.waitfor();
    
			if(DriverClass.waitTillElementTobeVisible(driver, homeObj.MyOldLeads).isDisplayed()) {
				System.out.println("My Old Leads are displayed");
				Report.testLog(true, "My Old Leads are displayed");
				if(DriverClass.waitTillElementTobeVisible(driver, homeObj.MyHotLeads).isDisplayed()) {
					System.out.println("My Hot Leads are displayed");
					Report.testLog(true, "My Hot Leads are displayed");
					if(DriverClass.waitTillElementTobeVisible(driver, homeObj.MyFreshLeads).isDisplayed()) {
						System.out.println("My Fresh Leads are displayed");
						Report.testLog(true, "My Fresh Leads are displayed");
						if(DriverClass.waitTillElementTobeVisible(driver, homeObj.MyProductCampaignLeads).isDisplayed()) {
							System.out.println("My Product Campaign Leads are displayed");
							Report.testLog(true, "My Product Campaign Leads are displayed");
						}else {
							Report.testLog(true, "My Product Campaign Leads are not displayed");
						}
					}else {
						Report.testLog(true, "My Fresh Leads are not displayed");
					}
				}else {
					Report.testLog(true, "My Hot Leads are not displayed");
				}
			}else {
				Report.testLog(true, "My Old Leads are not displayed");
			}
			
	}
	 
	 public static void SAPID_Verification_in_RelatedAccountList_on_RegionalAccounts() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();
		    DriverClass.waitfor();
			DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, setupObj.Users).click();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.Accountlink);
			Report.testLog(true, "Navigated to Accounts Object");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.LeadsLV);
			Report.testLog(true, "Navigated to Accounts List view");
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.AllAcountSelection);
			DriverClass.waitfor();
			
			/*
			 * Actions ac = new Actions(driver); DriverClass.waitfor();
			 * ac.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
			
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			 * robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			 * 
			 * Actions ac = new Actions(driver); WebElement RA = driver.findElement(By.
			 * xpath("//a[@title='Albertsons Companies Inc' and @target='_blank']"));
			 * ac.moveToElement(RA); ac.perform();
			 */
			
			DriverClass.waitTillElementTobeVisible(driver, homeObj.RegionalAccount).click();
			DriverClass.waitfor();
			Report.testLog(true, "Navigated to a Regional Account");
			DriverClass.waitTillElementTobeVisible(driver, homeObj.RARA).click();
			DriverClass.waitfor();
			Report.testLog(true, "Navigated to a Regional Account(Regional Account)"); 
			
			if(DriverClass.waitTillElementTobeVisible(driver, homeObj.SAPIDColumn).isDisplayed()) {
				System.out.println("SAP ID column is displayed");
				Report.testLog(true, "SAP ID column is displayed");
			}else {
				System.out.println("SAP ID column is not displayed");
				Report.testLog(true, "SAP ID column is not displayed");
			}
			
}

	 
	 public static void NewTask_Broadliner_Update_Request() throws AWTException, IOException, InterruptedException {
		            DriverClass.waitfor();
					DriverClass.waitfor();
					DriverClass.elementclick(setupObj.Users);
					DriverClass.waitfor();
					DriverClass.elementclick(setupObj.Userssub);
					DriverClass.waitfor();
					DriverClass.waitfor();
					DriverClass.waitfor();

					try {

						driver.switchTo().frame(0);
					}

					catch (Exception e) {
						System.out.println("Not able to view Frame");
					}

					DriverClass.waitfor();
					DriverClass.waitfor();
					DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
					Report.testLog(true, "Logged in as NCP Sales");
					DriverClass.waitfor();
					DriverClass.waitfor();
					DriverClass.waitfor();
					driver.switchTo().defaultContent();
					DriverClass.waitfor();
			DriverClass.elementclick(homeObj.Accountlink);
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
			Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
			DriverClass.waitfor();
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ActivityTab).click();
			Report.testLog(true, "Navigated to Activity tab");
			DriverClass.waitfor();
			DriverClass.waitfor();
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			DriverClass.waitfor();
			if(DriverClass.waitTillElementTobeVisible(driver, accountObj.More).isDisplayed()) {
				Report.testLog(true, "More is displayed");
			}
			DriverClass.elementclick(accountObj.More);
	//		DriverClass.waitTillElementTobeVisible(driver, accountObj.More).click();
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.NewTask);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.NewTask).click();
			Report.testLog(true, "Navigated to Broadliner Update Request task");
			if(DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskType).isDisplayed()) {
				Report.testLog(true, "Task Type is Broadliner Update Request task");
			}else {
				Report.testLog(true, "Task Type is not Broadliner Update Request task");
			}
			DriverClass.elementclick(accountObj.TaskSubType);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskSubType).click();
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.TaskSubTypeSelection);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskSubTypeSelection).click();
			DriverClass.waitfor();
			
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskSubject).sendKeys("New");
			DriverClass.waitfor();
			Report.testLog(true, "Task Subject is given as New");
			DriverClass.elementclick(accountObj.DueDate);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.DueDate).click();
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.taskDate);
		//	DriverClass.waitTillElementTobeClickable(driver, setupObj.taskDate).click();
			DriverClass.waitfor();
			Report.testLog(true, "Due date is selected as todays date");
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskRelatedAccounts).sendKeys("RA-447281");
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskRelatedAccounts).sendKeys(Keys.DOWN);
			DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskRelatedAccounts).sendKeys(Keys.ENTER);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.TaskRelatedAccounts).click();
			DriverClass.waitfor();
		//	DriverClass.elementclick(accountObj.NewRelatedAccountbtn);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.NewRelatedAccountbtn).click();
			DriverClass.waitfor();
			/*
			 * DriverClass.elementclick(accountObj.NextBtnRelatedAccounts);
			 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.PrimaryAccountSearch2)
			 * .sendKeys(PropertyManager.getInstance().getOrderAccount());
			 * Report.testLog(true, "Primary Account name:" +
			 * PropertyManager.getInstance().getOrderAccount()); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.RelatedAccountSearch2)
			 * .sendKeys(PropertyManager.getInstance().getSampleAccount());
			 * Report.testLog(true, "Related Account name:" +
			 * PropertyManager.getInstance().getSampleAccount()); DriverClass.waitfor();
			 * DriverClass.waitfor(); DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.RelatedAccountSearch).sendKeys(Keys.DOWN);
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.RelatedAccountSearch).sendKeys(Keys.ENTER); DriverClass.waitfor();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.BroadlinerCustNumberNew).sendKeys("68800"); DriverClass.waitfor();
			 * 
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.DistributorActive).click();
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.DistributorActive).sendKeys(Keys.DOWN);
			 * DriverClass.waitTillElementTobeVisible(driver,
			 * accountObj.DistributorActive).sendKeys(Keys.ENTER); Report.testLog(true,
			 * "Set Distributor Active as Yes"); DriverClass.waitfor();
			 * DriverClass.elementclick(accountObj.SavebtnReport); DriverClass.waitfor();
			 * DriverClass.waitfor();
			 */
			DriverClass.waitTillElementTobeVisible(driver, accountObj.UpdateRemovalRequest).sendKeys("name");
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.DueDate);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.Activitysave);
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.Activitysave).click();
			DriverClass.waitfor();
			DriverClass.waitfor();
}
	 
	 public static void Chatter_Publisher_Verification() throws AWTException, IOException, InterruptedException {
            DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.AaronLogin).click();
			Report.testLog(true, "Logged in as Aaron Bissey");
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
	DriverClass.elementclick(homeObj.opportunity);
	DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ContractOpportunity).click();
	Report.testLog(true, "Opportunity Selected: Espresso Bar");
	DriverClass.waitfor();
	if(DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterPost).isDisplayed()) {
		Report.testLog(true, "Chatter is displayed for posting comments and questions");
		System.out.println("Chatter is displayed");
		DriverClass.waitfor();
	//	DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterSU).click();
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterSU).sendKeys("Chatter enabled");
		DriverClass.waitfor();
//		DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterShare).click();
		if(DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterQuestion).isDisplayed()) {
	//		Report.testLog(true, "Chatter Question  is displayed");
			System.out.println("Chatter Question is displayed");
			DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterQuestion).click();
//			DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterQuestionUpdate).sendKeys("Is Chatter enabled?");
			DriverClass.waitfor();
//			DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterAsk).click();
		}else {
			Report.testLog(true, "Chatter Question is not displayed");
			System.out.println("Chatter question is not displayed");
		}
	}else {
		Report.testLog(true, "Chatter Post is not displayed");
		System.out.println("Chatter Post is not displayed");
	}
	 
	 }
	 public static void DoingBusinessAs_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();
			
			  DriverClass.waitfor();
			  DriverClass.waitfor(); 
			  DriverClass.waitfor();
			
				DriverClass.elementclick(setupObj.Users);
				DriverClass.waitfor();
				DriverClass.elementclick(setupObj.Userssub);
				DriverClass.waitfor();
				DriverClass.waitfor();
			
				Robot robot = new Robot();
				/*
				 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
				 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
				 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
				 */
				try {

					driver.switchTo().frame(0);
				}

				catch (Exception e) {
					System.out.println("Not able to view Frame");
				}

				DriverClass.waitfor();
				DriverClass.waitfor();
				DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
				Report.testLog(true, "Logged in as NCP Sales");
				DriverClass.waitfor();
				DriverClass.waitfor();
				driver.switchTo().defaultContent();
			 

			DriverClass.elementclick(homeObj.Accountlink);
			DriverClass.waitfor();
			DriverClass.waitfor();
			
			DriverClass.elementclick(accountObj.NewAccountCreatebtn);
			Report.testLog(true, "Navigated to Account Section");

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
					.sendKeys(PropertyManager.getInstance().getPropectAccountname());
			Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
			DriverClass.waitfor();

			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DoingBusinessAsnew).sendKeys("123#");
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
					.sendKeys(PropertyManager.getInstance().getOrderDate());
			Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
					.sendKeys(PropertyManager.getInstance().getPhone());
			Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
					.sendKeys(PropertyManager.getInstance().getCity());
			Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
					.sendKeys(PropertyManager.getInstance().getState());
			Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
			DriverClass.waitfor();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
			DriverClass.waitfor();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
					.sendKeys(PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
			Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
					.sendKeys(PropertyManager.getInstance().getRoute());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
					.sendKeys(PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.SubSegmentDep);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
		
			DriverClass.elementclick(accountObj.Subsegmentapply);
			DriverClass.waitfor();
		
			DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
					.sendKeys(PropertyManager.getInstance().getRegion());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
					.sendKeys(PropertyManager.getInstance().getBanner());
			Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.ApplyChannel);
			
			/*
			 * Actions action = new Actions(driver);
			 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
			
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
			
		//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
			
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
		//	DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.save);
			

			DriverClass.waitfor();
			Assertion_Functions.SpecialCharactersErrorValidation();
			DriverClass.waitfor();
			
		
	}
	 
	 public static void OpportunityRecordType_Verification_OpportunityRelatedList_SAPAccounts() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();
		 DriverClass.waitfor();
		  DriverClass.waitfor(); 
		  DriverClass.waitfor();
		
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
		
	//		Robot robot = new Robot();
			
			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
			DriverClass.waitfor();
			DriverClass.waitfor();
			driver.switchTo().defaultContent();
		 
			
			  DriverClass.waitfor();
			  DriverClass.waitfor(); 
			  DriverClass.waitfor();
		
			 

			DriverClass.elementclick(homeObj.Accountlink);
			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.AccountLinkDropdown);
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.AllAcountSelection);
			DriverClass.waitfor();
			
			/*
			 * Actions action = new Actions(driver);
			 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
			
			Report.testLog(true, "Navigated to Account Object");
			
			DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount)
            .sendKeys(PropertyManager.getInstance().getOrderAccount());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
			 DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
	            Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
	            DriverClass.waitTillElementTobeVisible(driver, accountObj.OpportunityRelatedList).click();
	            DriverClass.waitfor();
	            if(DriverClass.waitTillElementTobeVisible(driver, accountObj.OpportunityRecordType).isDisplayed()) {
	            	Report.testLog(true, "Opportunity Record Type is displayed");
	            
	            }else {
	            	Report.testLog(true, "Opportunity Record Type is not displayed");
	            	
	            }
	           
	            
	            
	 }
	 
	 public static void Chatter_Feed_ContractOpportunty_Verification() throws AWTException, IOException, InterruptedException {
         DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
		//	DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.AaronLogin).click();
			Report.testLog(true, "Logged in as Aaron Bissey");
			DriverClass.waitfor();
			DriverClass.waitfor();
		//	DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
	DriverClass.elementclick(homeObj.opportunity);
	DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ContractOpportunity).click();
	Report.testLog(true, "Opportunity Selected: Espresso Bar");
	DriverClass.waitfor();
//	DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.Chatterdown).sendKeys(Keys.DOWN);
	if(DriverClass.waitTillElementTobeVisible(driver, OpportunityObj.ChatterFeedsort).isDisplayed()) {
		Report.testLog(true, "Chatter Feed is displayed");
		
	}
	else {
		Report.testLog(true, "Chatter feed is not displayed");
	}
	 }
	 
	 
	 /**
	 * @throws AWTException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void EvergreenContractRequiredfield_Verification_in_SAP_Accounts() throws AWTException, IOException, InterruptedException {
         DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Users);
			DriverClass.waitfor();
			DriverClass.elementclick(setupObj.Userssub);
			DriverClass.waitfor();
			DriverClass.waitfor();
		//	DriverClass.waitfor();

			try {

				driver.switchTo().frame(0);
			}

			catch (Exception e) {
				System.out.println("Not able to view Frame");
			}

			DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, setupObj.AaronLogin).click();
			Report.testLog(true, "Logged in as Aaron Bissey");
			DriverClass.waitfor();
			DriverClass.waitfor();
		//	DriverClass.waitfor();
			driver.switchTo().defaultContent();
			DriverClass.waitfor();
			DriverClass.elementclick(homeObj.Accountlink);
			
			 
			DriverClass.waitfor();
			Report.testLog(true, "Navigated to Account Object");
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSampleSAP).click();
			DriverClass.waitfor();
			Report.testLog(true, "Account Selected: Sample Order Account");
	            DriverClass.waitfor();
	            Actions action = new Actions(driver);
				  action.sendKeys(Keys.PAGE_DOWN).build().perform();
				  DriverClass.waitfor();
			if(DriverClass.waitTillElementTobeVisible(driver, accountObj.EvergreenContractOpportunity).isDisplayed()) {
				Report.testLog(true, "Evergreen Contract Required field is displayed");
			
			}
			else {
				Report.testLog(true, "Evergreen Contract Required field is not displayed");
			}
			 }
			
	
	public static void SAPID_Field_Verification_ExistingCustomerLeadIntake() throws InterruptedException, IOException {

		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.LeadsLink);
		Report.testLog(true, "Navigated to Leads Object");
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, leadsObj.Leadname).click();
		Report.testLog(true, "Existing cutomer Lead should be Selected");
		DriverClass.waitfor();
		if(DriverClass.waitTillElementTobeVisible(driver, leadsObj.SAPIDfiled).isDisplayed()) {
			Report.testLog(true, "SAP ID field is displayed");
		
		}
		else {
			Report.testLog(true, "SAP ID field is not displayed");
		}
		
	}
	
	public static void OnBoarding_Notes_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);

		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
				.sendKeys(PropertyManager.getInstance().getBanner());
		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ApplyChannel);
		   DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.OnBoardingNotes).sendKeys("123#");
           DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		Report.testLog(true, "Acocunt Created : " + PropertyManager.getInstance().getPropectAccountname());
		// Assertion_Functions.ProspectAccountCreationValidation();
		Assertion_Functions.SpecialCharactersErrorValidation_NotesON();
        
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		
	}
	
	public static void Delivery_Notes_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);

		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region3)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
				.sendKeys(PropertyManager.getInstance().getBanner());
		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ApplyChannel);
		   DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.DeliveryNotes1).sendKeys("123#");
           DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		Report.testLog(true, "Acocunt Created : " + PropertyManager.getInstance().getPropectAccountname());
		// Assertion_Functions.ProspectAccountCreationValidation();
		Assertion_Functions.SpecialCharactersErrorValidation_NotesDN();
        
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		
	}
	
	public static void Authorization_Notes_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
		Robot robot = new Robot();
		DriverClass.elementclick(setupObj.Users);
		DriverClass.waitfor();
		DriverClass.elementclick(setupObj.Userssub);
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();

		try {

			driver.switchTo().frame(0);
		}

		catch (Exception e) {
			System.out.println("Not able to view Frame");
		}

		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		Report.testLog(true, "Logged in as NCP Sales");
		DriverClass.waitfor();
		DriverClass.waitfor();
		driver.switchTo().defaultContent();

		DriverClass.elementclick(homeObj.Accountlink);

		DriverClass.elementclick(accountObj.NewAccountCreatebtn);
		Report.testLog(true, "Navigated to Account Section");

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
				.sendKeys(PropertyManager.getInstance().getPropectAccountname());
		Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
		DriverClass.waitfor();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
				.sendKeys(PropertyManager.getInstance().getOrderDate());
		Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
				.sendKeys(PropertyManager.getInstance().getPhone());
		Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
				.sendKeys(PropertyManager.getInstance().getCity());
		Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
				.sendKeys(PropertyManager.getInstance().getState());
		Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
		DriverClass.waitfor();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
		DriverClass.waitfor();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
				.sendKeys(PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
		Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
				.sendKeys(PropertyManager.getInstance().getRoute());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
				.sendKeys(PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.SubSegmentDep);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
		DriverClass.waitfor();
		DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		
		DriverClass.elementclick(accountObj.Subsegmentapply);
		DriverClass.waitfor();
		
		DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
				.sendKeys(PropertyManager.getInstance().getRegion());
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
		DriverClass.waitfor();

		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
				.sendKeys(PropertyManager.getInstance().getBanner());
		Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
		DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
		DriverClass.waitfor();
		DriverClass.elementclick(accountObj.ApplyChannel);
		   DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("123#");
           DriverClass.waitfor();
           DriverClass.waitTillElementTobeVisible(driver, accountObj.OnBoardingNotes).sendKeys("1");

		/*
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		DriverClass.elementclick(accountObj.save);
		Report.testLog(true, "Acocunt Created : " + PropertyManager.getInstance().getPropectAccountname());
		// Assertion_Functions.ProspectAccountCreationValidation();
		Assertion_Functions.SpecialCharactersErrorValidation_NotesAN();
        
		DriverClass.waitfor();
		DriverClass.waitfor();
		DriverClass.waitfor();
		
		
	}
	
	 public static void BlanketPONumber_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();
			
			  DriverClass.waitfor();
			  DriverClass.waitfor(); 
			  DriverClass.waitfor();
			
				DriverClass.elementclick(setupObj.Users);
				DriverClass.waitfor();
				DriverClass.elementclick(setupObj.Userssub);
				DriverClass.waitfor();
				DriverClass.waitfor();
			
				Robot robot = new Robot();
				/*
				 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
				 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
				 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
				 */
				try {

					driver.switchTo().frame(0);
				}

				catch (Exception e) {
					System.out.println("Not able to view Frame");
				}

				DriverClass.waitfor();
				DriverClass.waitfor();
				DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
				Report.testLog(true, "Logged in as NCP Sales");
				DriverClass.waitfor();
				DriverClass.waitfor();
				driver.switchTo().defaultContent();
			 

			DriverClass.elementclick(homeObj.Accountlink);
			DriverClass.waitfor();
			DriverClass.waitfor();
			
			DriverClass.elementclick(accountObj.NewAccountCreatebtn);
			Report.testLog(true, "Navigated to Account Section");

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
					.sendKeys(PropertyManager.getInstance().getPropectAccountname());
			Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
			DriverClass.waitfor();

			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
					.sendKeys(PropertyManager.getInstance().getOrderDate());
			Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
					.sendKeys(PropertyManager.getInstance().getPhone());
			Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
					.sendKeys(PropertyManager.getInstance().getCity());
			Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
					.sendKeys(PropertyManager.getInstance().getState());
			Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
			DriverClass.waitfor();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
			DriverClass.waitfor();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
					.sendKeys(PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
			Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
					.sendKeys(PropertyManager.getInstance().getRoute());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
					.sendKeys(PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.SubSegmentDep);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
		
			DriverClass.elementclick(accountObj.Subsegmentapply);
			DriverClass.waitfor();
		
			DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
					.sendKeys(PropertyManager.getInstance().getRegion());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
					.sendKeys(PropertyManager.getInstance().getBanner());
			Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.ApplyChannel);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BlanketpoNumber).sendKeys("123#");
			DriverClass.waitfor();
			/*
			 * Actions action = new Actions(driver);
			 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
			
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
			
		//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
			
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
		//	DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.save);
			

			DriverClass.waitfor();
			
			Assertion_Functions.SpecialCharactersErrorValidation();
			DriverClass.waitfor();
			
		
	}
	 

	 public static void ReasonCreditApplicationRequired_Verification_with_Special_Characters_New_ProspectAccount() throws AWTException, IOException, InterruptedException {
			// Robot robot = new Robot();
			
			  DriverClass.waitfor();
			  DriverClass.waitfor(); 
			  DriverClass.waitfor();
			
				DriverClass.elementclick(setupObj.Users);
				DriverClass.waitfor();
				DriverClass.elementclick(setupObj.Userssub);
				DriverClass.waitfor();
				DriverClass.waitfor();
			
				Robot robot = new Robot();
				/*
				 * robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB);
				 * DriverClass.waitfor(); robot.keyPress(KeyEvent.VK_TAB);
				 * robot.keyRelease(KeyEvent.VK_TAB); DriverClass.waitfor();
				 */
				try {

					driver.switchTo().frame(0);
				}

				catch (Exception e) {
					System.out.println("Not able to view Frame");
				}

				DriverClass.waitfor();
				DriverClass.waitfor();
				DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
				Report.testLog(true, "Logged in as NCP Sales");
				DriverClass.waitfor();
				DriverClass.waitfor();
				driver.switchTo().defaultContent();
			 

			DriverClass.elementclick(homeObj.Accountlink);
			DriverClass.waitfor();
			DriverClass.waitfor();
			
			DriverClass.elementclick(accountObj.NewAccountCreatebtn);
			Report.testLog(true, "Navigated to Account Section");

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountName)
					.sendKeys(PropertyManager.getInstance().getPropectAccountname());
			Report.testLog(true, "Acocunt Name Entered : " + PropertyManager.getInstance().getPropectAccountname());
			DriverClass.waitfor();

			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountDate)
					.sendKeys(PropertyManager.getInstance().getOrderDate());
			Report.testLog(true, "Acocunt Date Entered : " + PropertyManager.getInstance().getOrderDate());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountPhone)
					.sendKeys(PropertyManager.getInstance().getPhone());
			Report.testLog(true, "Acocunt Phone Entered : " + PropertyManager.getInstance().getPhone());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.City)
					.sendKeys(PropertyManager.getInstance().getCity());
			Report.testLog(true, "Acocunt City Entered : " + PropertyManager.getInstance().getCity());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.State)
					.sendKeys(PropertyManager.getInstance().getState());
			Report.testLog(true, "Acocunt State Entered : " + PropertyManager.getInstance().getState());
			DriverClass.waitfor();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforChannel).click();
			DriverClass.waitfor();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep)
					.sendKeys(PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ChannelDep).sendKeys(Keys.ENTER);
			Report.testLog(true, "Account Channel Entered : " + PropertyManager.getInstance().getChannel());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ApplyChannel).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.Routetomarket2)
					.sendKeys(PropertyManager.getInstance().getRoute());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Acocunt Routetomarket Entered : " + PropertyManager.getInstance().getRoute());

			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforSegment).click();
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).click();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep)
					.sendKeys(PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SegmentDep).sendKeys(Keys.ENTER);
			// robot.keyPress(KeyEvent.VK_ENTER);
			// robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Segment Entered : " + PropertyManager.getInstance().getSegment());
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.SubSegmentDep);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.DOWN);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.SubSegmentDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
		
			DriverClass.elementclick(accountObj.Subsegmentapply);
			DriverClass.waitfor();
		
			DriverClass.waitTillElementTobeVisible(driver, accountObj.Region2)
					.sendKeys(PropertyManager.getInstance().getRegion());
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Report.testLog(true, "Account Region Entered : " + PropertyManager.getInstance().getRegion());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.DependenciesforBanner).click();
			DriverClass.waitfor();

			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep)
					.sendKeys(PropertyManager.getInstance().getBanner());
			Report.testLog(true, "Account Banner Entered : " + PropertyManager.getInstance().getBanner());
			DriverClass.waitTillElementTobeVisible(driver, accountObj.BannerDep).sendKeys(Keys.ENTER);
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.ApplyChannel);
			DriverClass.waitfor();
			DriverClass.waitTillElementTobeVisible(driver, accountObj.ReasonCreditApplicationRequired).sendKeys("123#");
			DriverClass.waitfor();
			/*
			 * Actions action = new Actions(driver);
			 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
			 */
			
			DriverClass.waitTillElementTobeVisible(driver, accountObj.AuthorizationNotes).sendKeys("1");
			
		//	DriverClass.elementclick(accountObj.DeliveryNotesSAp);
			
		//	DriverClass.waitTillElementTobeVisible(driver, accountObj.EditRCANRfield).click();
		//	DriverClass.waitfor();
			DriverClass.waitfor();
			DriverClass.elementclick(accountObj.save);
			

			DriverClass.waitfor();
			Assertion_Functions.SpecialCharactersErrorValidation();
			DriverClass.waitfor();
			
		
	}
	 
	 public static void ISAR_FSM_Valid_From_Date_Edit() throws AWTException, IOException, InterruptedException {
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.elementclick(setupObj.Users);
        DriverClass.waitfor();
        DriverClass.elementclick(setupObj.Userssub);
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        try {
            driver.switchTo().frame(0);
        }
        catch (Exception e) {
            System.out.println("Not able to view Frame");
        }
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitTillElementTobeVisible(driver, setupObj.ncpISAR_Evans).click();
        Report.testLog(true, "Logged in as ISAR User");
        DriverClass.waitfor();
        DriverClass.waitfor();
        //driver.switchTo().defaultContent();

        DriverClass.elementclick(homeObj.Accountlink);
        DriverClass.waitfor();


        DriverClass.elementclick(accountObj.AccountsListView);
        DriverClass.waitfor();
        DriverClass.elementclick(accountObj.AllAccounts);
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeVisible(driver,accountObj.searchBar).sendKeys("PLACEHOLDER  College of Mount Saint Vincent");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeVisible(driver, accountObj.PlaceholderCollegeSAPAccount).click();
        Report.testLog(true, "Navigated into selected SAP Account");

        DriverClass.waitfor();
        DriverClass.waitfor();

        DriverClass.elementclick(accountObj.FSMField);
        DriverClass.waitfor();
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeVisible(driver,accountObj.EditFSMField).sendKeys("I");
        Report.testLog(true, "FSM Field is now selected as Independent");
        action.sendKeys(Keys.ENTER).build().perform();
        DriverClass.waitfor();


        DriverClass.elementclick(accountObj.EditFSMValidFrom);
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.elementclick(setupObj.taskDate);
        DriverClass.waitfor();
        Report.testLog(true, "FSM Valid From Date is selected as today's date");

        DriverClass.elementclick(accountObj.SaveEdit);
        Report.testLog(true, "FSM field values are now saved");
        DriverClass.waitfor();
        DriverClass.waitfor();

        DriverClass.elementclick(accountObj.FSMField);
        DriverClass.waitfor();
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeVisible(driver,accountObj.EditFSMFieldIndependent).sendKeys("--");
        Report.testLog(true, "FSM Field is now reset back to None");
        DriverClass.waitfor();
        action.sendKeys(Keys.ENTER).build().perform();
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeClickable(driver,accountObj.EditFSMValidFrom).clear();
        Report.testLog(true, "FSM Valid From Date is now deleted");
        DriverClass.waitfor();

        DriverClass.elementclick(accountObj.SaveEdit);
        Report.testLog(true, "FSM field values are now re-set");
        DriverClass.waitfor();
        DriverClass.waitfor();
 }

	 
	
	 public static void Field_Addition_To_Custom_Basket_Report() throws AWTException, IOException, InterruptedException {
         DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.elementclick(setupObj.Users);
        DriverClass.waitfor();
        DriverClass.elementclick(setupObj.Userssub);
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        
        
       try {
            driver.switchTo().frame(0);
        }
        catch (Exception e) {
            System.out.println("Not able to view Frame");
        } 

        DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
        Report.testLog(true, "Logged in as NCP Sales");
        DriverClass.waitfor();
        DriverClass.waitfor();
        driver.switchTo().defaultContent();

        DriverClass.elementclick(reportObj.Reportlink);
        Report.testLog(true, "User is navigated to Reports page");
        DriverClass.waitfor();

        DriverClass.elementclick(reportObj.AllReports);
        Report.testLog(true, "User is navigated to All Reports page");
        DriverClass.waitfor();

        DriverClass.waitTillElementTobeVisible(driver,reportObj.SearchAllReports).sendKeys("Basket Product Report(Mkting)");
        Report.testLog(true, "User searched for the desired report");
        DriverClass.waitfor();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        DriverClass.waitfor();

        DriverClass.elementclick(reportObj.clickReport);
        Report.testLog(true, "User clicks on the searched report");
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        DriverClass.waitfor();
        //DriverClass.elementclick(reportObj.ProductAvailableField);
        //DriverClass.waitfor();
        
        driver.switchTo().frame(reportObj.frame);
     
        if(reportObj.ProductAvailableField.isDisplayed())
        	Report.testLog(true, "Product Name: Product Available? field is found in the selected report");
        DriverClass.waitfor();
        
        if(reportObj.ProductActiveField.isDisplayed())
        	Report.testLog(true, "Product Name: Active field is found in the selected report");
        DriverClass.waitfor();

	 	}
	 public static void SAPAccount_removingalldata_in_PSSInformationSection_UserabletoSave() throws AWTException, IOException, InterruptedException {
		 Robot robot = new Robot();
		 DriverClass.elementclick(setupObj.Users);
		 DriverClass.waitfor();
		 DriverClass.elementclick(setupObj.Userssub);
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 try {
		 driver.switchTo().frame(0);
		 }
		 catch (Exception e) {
		 System.out.println("Not able to view Frame");
		 }
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
		 Report.testLog(true, "Logged in as NCP Sales");
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 driver.switchTo().defaultContent();
		 DriverClass.elementclick(homeObj.Accountlink);
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.AccountLinkDropdown);
		 DriverClass.waitfor();
		 DriverClass.elementclick(homeObj.AllAcountSelection);
		 DriverClass.waitfor();
		 /*
		 * Actions action = new Actions(driver);
		 * action.sendKeys(Keys.PAGE_DOWN).build().perform(); DriverClass.waitfor();
		 */
		 Report.testLog(true, "Navigated to Account Object");
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(PropertyManager.getInstance().getOrderAccount());
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.searchAccount).sendKeys(Keys.ENTER);
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.AccountnameSAP).click();
		 Report.testLog(true, "Account Name Selected: College of Mount Saint Vincent");
		 DriverClass.elementclick(accountObj.editAccount);
		 DriverClass.waitfor();
		 //DriverClass.waitTillElementTobeVisible(driver, accountObj.PreScheduledApprover).click() ;
		 //DriverClass.waitfor();
		 //DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.SbuxPrescheduledActive);
		 DriverClass.waitfor();
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.Sbuxbrewvenues).clear();
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.SbuxbrewWinter);
		 DriverClass.waitfor();
		 //DriverClass.elementclick(accountObj.Sbuxbrewonlyportionpacksize);
		 DriverClass.waitTillElementTobeVisible(driver,accountObj.Sbuxbrewonlyportionpacksize).sendKeys("--");
		 DriverClass.waitfor();
		 Actions action = new Actions(driver);
		 action.sendKeys(Keys.ENTER).build().perform();
		 DriverClass.waitfor();
		 // DriverClass.waitTillElementTobeVisible(driver, accountObj.Sbuxbrewonlyportionpacksizenone).sendKeys("--None--");
		 //  DriverClass.waitTillElementTobeVisible(driver, accountObj.Sbuxbrewonlyportionpacksizenone).click();
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.SbuxEspressovenues).clear();
		 DriverClass.waitfor();
		 //DriverClass.elementclick(accountObj.SbuxEspressoportionpacksize);
		 DriverClass.waitTillElementTobeVisible(driver,accountObj.SbuxEspressoportionpacksize).sendKeys("--");
		 action.sendKeys(Keys.ENTER).build().perform();
		 DriverClass.waitfor();
		 /*
		 * DriverClass.waitfor(); Actions action = new Actions(driver);
		 * action.sendKeys(Keys.ENTER).build().perform(); DriverClass.waitfor();
		 */
		 //DriverClass.waitTillElementTobeVisible(driver, accountObj.SbuxEspressoportionpacksizenone).sendKeys("None");
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.FrappuccinoPrescheduleActive);
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.FrappuccinoPrescheduleVenues).clear();
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.RefreshersPrescheduledActive);
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.RefreshersPrescheduledVenues).clear();
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.ColdbrewPrescheduledActive);
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.ColdbrewPrescheduledVenues).clear();
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.ColdfoamPrescheduledActive);
		 DriverClass.waitfor();
		 DriverClass.waitTillElementTobeVisible(driver, accountObj.ColdfoamPrescheduledVenues).clear();
		 DriverClass.waitfor();
		 // DriverClass.waitfor();
		 // DriverClass.waitTillElementTobeVisible(driver, accountObj.SbuxbrewWinter).clear();
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.SbuxEspressofall);
		 Report.testLog(true, "Remove all the Data from the text/Number Fields and Uncheck the all the check box fields that is present under  \"Pre-Scheduled Shipment Information\" Section");
		 DriverClass.waitfor();
		 DriverClass.elementclick(accountObj.Save);
		 Report.testLog(true, "Account should be saved successfully");
		 DriverClass.waitfor();
		 }

	 public static void NCP_NonISAR_FSM_Valid_From_Date_Edit() throws AWTException, IOException, InterruptedException {
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.elementclick(setupObj.Users);
	        DriverClass.waitfor();
	        DriverClass.elementclick(setupObj.Userssub);
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        try {
	            driver.switchTo().frame(0);
	        }
	        catch (Exception e) {
	            System.out.println("Not able to view Frame");
	        }
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.waitTillElementTobeVisible(driver, setupObj.NCPSalesLogin).click();
			Report.testLog(true, "Logged in as NCP Sales");
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        //driver.switchTo().defaultContent();

	        DriverClass.elementclick(homeObj.Accountlink);
	        DriverClass.waitfor();


	        DriverClass.elementclick(accountObj.AccountsListView);
	        DriverClass.waitfor();
	        DriverClass.elementclick(accountObj.AllAccounts);
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.waitTillElementTobeVisible(driver,accountObj.searchBar).sendKeys("College of Mount Saint Vincent");
	        Actions action = new Actions(driver);
	        action.sendKeys(Keys.ENTER).build().perform();
	        DriverClass.waitfor();

	        DriverClass.waitTillElementTobeVisible(driver, accountObj.CollegeMountSaintVincentSAPAccount).click();
	        Report.testLog(true, "Navigated into selected SAP Account");

	        DriverClass.waitfor();
	        DriverClass.waitfor();

	        DriverClass.elementclick(accountObj.FSMField);
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        
	        DriverClass.elementclick(accountObj.EditFSMValidFrom);
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.elementclick(setupObj.taskDate);
	        DriverClass.waitfor();
	        Report.testLog(true, "FSM Valid From Date is selected as today's date");

	        DriverClass.elementclick(accountObj.SaveEdit);
	        Report.testLog(true, "User clicks on Save button");
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        
	        if(accountObj.FSMValidFromError.isDisplayed())
	        	Report.testLog(true, "Error Message is displayed : Only ISARs can change the FSM Valid From Date field on a SAP Account. FSM Valid From Date can be changed on a SAP Account only when the FSM is Independent");
	        else
	        	Report.testLog(false, "Error message not displayed");
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	 }  

	 public static void ISAR_FSM_Field_Edit() throws AWTException, IOException, InterruptedException {
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.elementclick(setupObj.Users);
	        DriverClass.waitfor();
	        DriverClass.elementclick(setupObj.Userssub);
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        try {
	            driver.switchTo().frame(0);
	        }
	        catch (Exception e) {
	            System.out.println("Not able to view Frame");
	        }
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        DriverClass.waitTillElementTobeVisible(driver, setupObj.ncpISAR_Evans).click();
	        Report.testLog(true, "Logged in as ISAR User");
	        DriverClass.waitfor();
	        DriverClass.waitfor();
	        //driver.switchTo().defaultContent();

	        DriverClass.elementclick(homeObj.Accountlink);
	        DriverClass.waitfor();


	        DriverClass.elementclick(accountObj.AccountsListView);
	        DriverClass.waitfor();
	        DriverClass.elementclick(accountObj.AllAccounts);
	        DriverClass.waitfor();

	        DriverClass.waitTillElementTobeVisible(driver,accountObj.searchBar).sendKeys("PLACEHOLDER  College of Mount Saint Vincent");
	        Actions action = new Actions(driver);
	        action.sendKeys(Keys.ENTER).build().perform();
	        DriverClass.waitfor();

	        DriverClass.waitTillElementTobeVisible(driver, accountObj.PlaceholderCollegeSAPAccount).click();
	        Report.testLog(true, "Navigated into selected SAP Account");

	        DriverClass.waitfor();
	        DriverClass.waitfor();

	        DriverClass.elementclick(accountObj.FSMField);
	        DriverClass.waitfor();
	        DriverClass.waitfor();

	        DriverClass.waitTillElementTobeVisible(driver,accountObj.EditFSMField).sendKeys("I");
	        Report.testLog(true, "FSM Field is now selected as Independent");
	        action.sendKeys(Keys.ENTER).build().perform();
	        DriverClass.waitfor();
	        
	        DriverClass.elementclick(accountObj.SaveEdit);
	        Report.testLog(true, "FSM Field value is now updated to Independent");
	        DriverClass.waitfor();
	        DriverClass.waitfor();

	        DriverClass.elementclick(accountObj.FSMField);
	        DriverClass.waitfor();
	        DriverClass.waitfor();

	        DriverClass.waitTillElementTobeVisible(driver,accountObj.EditFSMFieldIndependent).sendKeys("--");
	        Report.testLog(true, "FSM Field is now reset back to None");
	        DriverClass.waitfor();
	        action.sendKeys(Keys.ENTER).build().perform();
	        DriverClass.waitfor();
	        
	        DriverClass.elementclick(accountObj.SaveEdit);
	        Report.testLog(true, "FSM Field value is now updated to back to None");
	        DriverClass.waitfor();
	 }
}	

zzzwdkjgqds s c m cqdddnbsmb




    
