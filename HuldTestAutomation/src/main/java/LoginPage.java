import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath ="//a[@data-qa-id='login-select']")
	private WebElement login;
	
	@FindBy(xpath = "//a[@data-qa-id='login-hudl']")
	private WebElement hudlLogin;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement loginEmailId;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement loginPassword;
	
	
	@FindBy(xpath = "//button[@id='logIn']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver wd) {
		this.driver=wd;	
		PageFactory.initElements(driver,this);
	} 
		
	public void clickOnLogin() {
		login.click();
	}
	
	public void clickOnHudl() {
		hudlLogin.click();
	}
	
	public void setLoginEmailId(String emailId) {
		loginEmailId.sendKeys(emailId);
	}
	
	public void setLoginPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public String getLoginTitle() {
		
		return driver.getTitle();
		
	}
	
public void loginToTheHudl(String emailId,String password) {
	this.clickOnLogin();
	this.clickOnHudl();
	this.setLoginEmailId(emailId);
	this.setLoginPassword(password);
	this.clickOnLoginButton();
}	

}
