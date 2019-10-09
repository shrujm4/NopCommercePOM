package NopCommerceHomework;

import org.openqa.selenium.By;

public class HomePage extends Utils {

LoadProp prop = new LoadProp();

private By _registerLink = By.xpath("//a[@class=\"ico-register\"]");
private By _loginLink = By.className("ico-login");
private By _logoutLink = By.className("ico-logout");



public void clickOnRegister(){

  clickElement(_registerLink);


}

public void clickOnLogin(){

  clickElement(_loginLink);

}

public void clickOnLogout(){

  clickElement(_logoutLink);
}


}
