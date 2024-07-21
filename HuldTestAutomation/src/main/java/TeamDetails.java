import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamDetails {
	
	WebDriver driver;
	
	
	@FindBy(xpath = "//h2[@class='uni-headline--1']")
	private WebElement teamName;
	
	@FindBy(xpath = "//span[@data-index='1']")
	private WebElement highlights;
	
	@FindBy(xpath="//span[@data-index='0']")
	private WebElement timeLineTab;
	
	@FindBy(xpath = "//span[@data-index='2']")
	private WebElement gamesTab;
	
	@FindBy(xpath = "//span[@data-index='3']")
	private WebElement teamTab;

	@FindBy(xpath = "//span[@data-index='4']")
	private WebElement schedule;
	
	@FindBy(xpath = "//button[@class='uni-dismiss uni-overlay__close']")
	private WebElement closePopUp;
	
	public TeamDetails(WebDriver wd) {
		this.driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTeamName() {
		
		return teamName.getText();
	}
	
	public void clickTimeTable() {
		timeLineTab.click();
	}
	
	public void clickOnHighlights() {
		highlights.click();
	}
	
	public void closePopUpWindow() throws InterruptedException {
		Thread.sleep(2000);
		closePopUp.click();
	}
	
	public void clickOnGameTab() {
		gamesTab.click();
	}
	
	public void clickOnTeamTab() {
		teamTab.click();
	}
	
	
	public void clickOnSchedule() {
		schedule.click();
	}
	public void checkAllSectionsOftheTeam() throws InterruptedException {
		this.closePopUpWindow();
		this.clickTimeTable();
		this.clickOnHighlights();
		this.clickOnGameTab();
		this.clickOnTeamTab();
		this.clickOnSchedule();
	}
}
