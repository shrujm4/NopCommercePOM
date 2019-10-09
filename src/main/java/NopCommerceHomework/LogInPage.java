package NopCommerceHomework;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LogInPage extends Utils{

  LoadProp prop = new LoadProp();

  private By _loginEmailField = By.className("email");
  private By _loginPasswordField = By.className("password");
  private By _logInButton = By.xpath("//input[@value=\"Log in\"]");
  private By _title = By.className("page-title");
  private By _account = By.className("ico-account");



  public void clickLogin(){

    enterText(_loginEmailField, prop.getProperty("loginTXT"));
    enterText(_loginPasswordField,prop.getProperty("passTXT"));
    clickElement(_logInButton);

  }

  public void checkLoginPageDisplayed(){

    Assert.assertEquals(getTextFromElement(_title),"Welcome, Please Sign In!");

  }

  public void checkUserLoggedIn (){


    Assert.assertTrue(getTextFromElement( _account).contains("My account"));

  }

}
