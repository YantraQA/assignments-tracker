package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;


public class CommonPageObjects extends Interact {
	private static final Logger logger=LogManager.getLogger(CommonPageObjects.class);

	//Design of PageObjectModels- see in comments
	Scenario scn;

	//Locators
	private By search_textbox= By.id("twotabsearchtextbox");
	private By search_button= By.xpath("//input[@value='Go']");
	private By hamburger_menu_link =  By.id("nav-hamburger-menu");
	private By nav_link_logo =  By.xpath("//a[@class='nav-logo-link']");
	private By nav_link_cart =  By.id("nav-cart");
	private By nav_link_prime =  By.id("nav-link-prime");
	private By nav_link_orders =  By.id("nav-orders");
	private By nav_link_acount =  By.id("nav-link-accountList");
	//homePageElemnet
	private String hamburger_menu_category_link_xpath =  "//div[@id='hmenu-content']//div[text()='%s']";
	private String hamburger_menu_sub_category_link_xpath =  "//div[@id='hmenu-content']//a[text()='%s']";

	//constructor
	public CommonPageObjects(WebDriver driver, Scenario s)
	{
		setDriver(driver);
		this.scn=s;
	}
	//methods1- performing operation on your elements
	public void SetSearchTextBox(String text)
	{
		setElement(search_textbox,text);
		logger.info("Value entered in search box:" +text);
		takeScreenShotAndAttachInReport(scn);

	}
	public void ClickOnSearchButton()
	{
		/*try{
			clickElement(search_button);
			logger.info("Clicked on search button");
		}catch(Exception  e)
		{
			logger.error("Exception occured while string yo click on search button.Exception:"+e.getMessage());
		}*/
		clickElement(search_button);	
		logger.info("Clicked on Search Button");
	}

	public void ClickOnHamburgerMenuButton() {
		clickElement(hamburger_menu_link);
		scn.write("Clicked on Hamburger Menu Link");
		logger.info("Clicked on Hamburger Menu Button");
	}

	public void ClickOnHamburgerMenuProductCategoryLink(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_category_link_xpath,linkText));
		clickElement(byElement);
		scn.write("Clicked on Hamburger Menu Category link: " + linkText);
		logger.info("Clicked on Hamburger Menu Category link: " + linkText);
	}

	public void ClickOnHamburgerMenuProductSubCategoryLink(String linkText) {
		By byElement = By.xpath(String.format(hamburger_menu_sub_category_link_xpath,linkText));
		clickElement(byElement);
		scn.write("Clicked on Hamburger Menu SubCategory link: " + linkText);
		logger.info("Clicked on Hamburger Menu SubCategory link: " + linkText);
	}

	//validating hamBurgerMenu is displayed or not
	public void validateHamBurgerMenuIsDisplayed() {
		boolean b = validateElementIsDisplayed(hamburger_menu_link);
		Assert.assertEquals(true, b);
	}
	//Validating Amazon logo
	public void validateAmazonLogo() {
		boolean b = validateElementIsDisplayed(nav_link_logo);
		Assert.assertEquals(true, b);
	}
	public void validatePageTitleMatch(String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		Boolean b = wait.until(ExpectedConditions.titleContains(expectedTitle));
		Assert.assertEquals(true, b);
		scn.write("Page title matched: " + expectedTitle );
	}

	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=false;

		switch(text.toLowerCase().trim()) {
		case "hamburger menu":
			b = validateElementIsDisplayed(hamburger_menu_link);
			break;
		case "amazon prime logo":
			b = validateElementIsDisplayed(nav_link_logo);
			break;
		case "accounts and list link":
			b = validateElementIsDisplayed(nav_link_acount);
			break;
		case "return and orders":
			b = validateElementIsDisplayed(nav_link_orders);
			break;
		case "your prime link":
			b = validateElementIsDisplayed(nav_link_prime);
			break;
		case "cart link":
			b = validateElementIsDisplayed(nav_link_cart);
			break;
		case "search text box":
			b = validateElementIsDisplayed(search_textbox);
			break;
		default:
			logger.fatal("Header Link Description is not present in the case. Please add link description first.");
			scn.write("Header Link Description is not present in the case. Please add link description first.");
			throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			scn.write("Header Link is displayed: " + text);
			Assert.assertEquals(true, b);
		}else {
			scn.write("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}

	}



}
