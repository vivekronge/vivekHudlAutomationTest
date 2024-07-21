import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class testFeaturesOfHudl {
	WebDriver driver;
	LoginPage login;
	LandingPage landing;
	TeamDetails team;
	
	
	@BeforeMethod(description = "Setting up the environment for execution")
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.hudl.com/");
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"Hudl • Tools to help every team, coach and athlete improve");
	}

	@Test(priority = 1,description = "Checking Search functionality post login")
	public void testLoginAndSearchFeature() throws InterruptedException {
		
		//Login in with the User credentials and Validating the page.
		login = new LoginPage(driver);
		login.loginToTheHudl("vivekronge@gmail.com", "Master@2580");
		Assert.assertEquals(login.getLoginTitle(), "Log In","Validating the page title while Login In");
		
		//Making a search with Player Name and Checking the details.
		landing = new LandingPage(driver);
		landing.validatingSearchFunctionalityOfHudl("Cristiano Ronaldo");
		Assert.assertEquals(landing.getPageTitle(), "Cristiano Ronaldo - Hudl","Validating the searched page");
		landing.backToHomePage();
		
		//Making a search with Game name and Validating the page.
		landing.validatingSearchFunctionalityOfHudl("Vollyball");
		System.out.println(landing.getPageTitle());
		Assert.assertEquals(landing.getPageTitle(), "Girls varsity vollyball | High School Sports | Home | Hudl");
		
		//Back to the landing page and log out the user.
		landing.backToHomePage();
		landing.logOut();
	}
	
	 
	@Test(priority = 2,description = "Checking Team Details")
	public void testHighlightsAndTicketsAndPassesFeature() throws InterruptedException {
		
		//Login in with the User credentials and Validating the page.
		login = new LoginPage(driver);
		login.loginToTheHudl("vivekronge@gmail.com", "Master@2580");
		Assert.assertEquals(login.getLoginTitle(), "Log In","Validating the page title while Login In");
		
		//Click on the Highlights tab from landing page.
		landing = new LandingPage(driver);
		landing.clickOnHighlights();
		
		//Validating the team name here
		team = new TeamDetails(driver);
		String teamName =team.getTeamName();
		Assert.assertEquals(teamName, "Hudl Australia - Newcastle Jets FC");
		
		//Validating all tabs for team and logging out.
		team.checkAllSectionsOftheTeam();
		landing.backToHomePage();
		landing.logOut();
		
		
	}
	
}
