package NopCommerceHomework;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ReferAProductToFriend  extends Utils{

  LoadProp prop = new LoadProp();



  private By _addToWishListButton = By.xpath("(//input[@class=\"button-2 add-to-wishlist-button\"])[3]");
  private By _clickOnBar = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
  private By _referToFriendButton = By.xpath("//input[3]");//("(//input[@type=\"button\"])[1]");
  private By _friendEmailField = By.id("FriendEmail");
  private By _emailFriendButton = By.xpath("//div[3]/input");//("//*[@id=\"FriendEmail\"]");
  private By _personalMessage = By.className("personal-message");
  private By _sendEmail = By.name("send-email");
  private By _addToWish1Button = By.xpath("(//input[@class=\"button-2 add-to-wishlist-button\"])[1]");
  private By _emailField = By.xpath("//input[@class=\"your-email\"]");
  private By _errorMessage = By.xpath("//li[text()=\"Only registered customers can use email a friend feature\"]");
  private By _personalErrorMessage = By.xpath("//textarea[@id=\"PersonalMessage\"]");
  private By _compareResult = By.className("page-body");

public void referProduct(){

  clickElement(_addToWishListButton);
  clickElement(_clickOnBar);
  waitAndClick(_referToFriendButton, 3);
  enterText(_friendEmailField, prop.getProperty("refer"));
  enterText(_personalMessage, prop.getProperty( "MSS"));
  clickElement(_sendEmail);
  }

  public void referSuccess(){

    Assert.assertEquals(getTextFromElement(_compareResult),"Your message has been sent.");

  }


public void cannotReferProduct(){

  clickElement(_addToWish1Button);
  clickElement(_emailFriendButton);
  enterText(_friendEmailField, prop.getProperty("refer"));
  enterText(_emailField,prop.getProperty("loginTXT"));
  enterText(_personalErrorMessage,prop.getProperty("MSS"));
  clickElement(_sendEmail);
}
public void referFailed(){

  Assert.assertEquals(getTextFromElement(_errorMessage),"Only registered customers can use email a friend feature");

}



}


