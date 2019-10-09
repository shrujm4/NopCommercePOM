package NopCommerceHomework;

import org.openqa.selenium.By;
import org.testng.Assert;

public class
RegistrationPage extends Utils {

  LoadProp prop = new LoadProp();

private By _pageTitle = By.className("page-title");
private By _genderButton = By.xpath("//input[@id=\"gender-female\"]");
private By _firstNameField = By.id("FirstName");
private By _lastNameField = By.id("LastName");
private By _dayField = By.name("DateOfBirthDay");
private By _monthField = By.name("DateOfBirthMonth");
private By _yearField = By.name("DateOfBirthYear");
private By _companyNameField = By.name("Company");
private By _passwordField = By.name("Password");
private By _confirmPassField = By.name("ConfirmPassword");
private By _registerButton = By.id("register-button");
private By _emailField = By.name("Email");
private By _successMessage = By.xpath("//div[@class=\"result\"]");

public void toVerifyUserIsOnRegisterPage(){

  Assert.assertTrue(getTextFromElement(_pageTitle).contains("Register"));

}

public void toConfirmRegistrationSuccessfull(){

  Assert.assertEquals(getTextFromElement(_successMessage),"Your registration completed");


}

public void clickOnRegister(){

  clickElement(_genderButton);
  enterText(_firstNameField,prop.getProperty("firstname"));
  enterText(_lastNameField, prop.getProperty("lastname"));
  selectByVisibleText(_dayField,prop.getProperty("day"));
  selectByValue(_monthField, prop.getProperty("month"));
  selectByIndex(_yearField,Integer.parseInt(prop.getProperty("i")));
  waitForElementVisible(_yearField,5);
  enterText(_emailField,prop.getProperty("email")+ randomNumber()+"@gmail.com");
  System.out.println(prop.getProperty("email")+ randomNumber()+"@gmail.com");
  enterText(_companyNameField, prop.getProperty("company"));
  enterText(_passwordField, prop.getProperty("password"));
  enterText(_confirmPassField, prop.getProperty("cpassword"));
  clickElement(_registerButton);


}



}
