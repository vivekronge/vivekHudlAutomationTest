import java.util.List;

import org.apache.xalan.templates.ElemElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@title='Search']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//a[@class='search-row']")
	private List<WebElement> searchElements;
	
	@FindBy(xpath = "//h2[@class='uni-headline--1']")
	private WebElement headTextOfPage;
	
	@FindBy(xpath = "//a[@data-qa-id='webnav-globalnav-home']")
	private WebElement homePage;
	
	@FindBy(xpath="//div[@class='hui-globaluseritem__display-name']")
	private WebElement profileIcon;
	
	@FindBy(xpath = "//a[@data-qa-id='webnav-primarynav-highlights']")
	private WebElement highLights;
	
	@FindBy(xpath = "//*[text()='Log Out']")
	private WebElement logOut;
	
	public LandingPage(WebDriver wd) {
		
		this.driver=wd;
		PageFactory.initElements(driver,this);
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	public void setTextForSearchBox(String searchText) throws InterruptedException {
		searchBox.sendKeys(searchText);
		Thread.sleep(2000);
	}
	
	public void selectValueFromSearchResult() {
		searchElements.get(1).click();
	}
	
	public String getHeadTextOfThePage() {
		
		String headText = headTextOfPage.getText();
		return headText;
	}
	
	public void backToHomePage() throws InterruptedException {
		homePage.click();
		Thread.sleep(5000);
	}
	
	public void clickOnHighlights() throws InterruptedException {
		highLights.click();
		Thread.sleep(2000);
	}
	
	public void logOut() throws InterruptedException {
		profileIcon.click();
		Thread.sleep(2000);
		logOut.click();
		driver.quit();
		
	}
	
	public void validatingSearchFunctionalityOfHudl(String searchText) throws InterruptedException {
		this.setTextForSearchBox(searchText);
		this.selectValueFromSearchResult();
		
	}
}
