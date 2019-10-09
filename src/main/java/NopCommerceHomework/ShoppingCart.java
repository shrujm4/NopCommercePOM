package NopCommerceHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import javax.swing.*;

public class ShoppingCart extends Utils {

  LoadProp prop = new LoadProp();
  BrowserSelector browserSelector = new BrowserSelector();

  //Actions actions = new Actions(driver);
  //WebElement shoppingCart = driver.findElement(By.className("cart-label"));





  private By _addFirstProductButton = By.xpath("(//input[@value=\"Add to cart\"])[3]");
  private By _ApperalImage = By.xpath("//img[@alt=\"Picture for category Apparel\"]");
  //private By _ApperalImage = By.linkText("/apparel");
  private By _shoesCatagoryImage = By.xpath("//img[@alt=\"Picture for category Shoes\"]");
  private By _shoesAddToCartOptionsButton = By.xpath("(//input[@type=\"button\"])[2]");
  private By _shoeSizeSelect = By.xpath("//select[@name=\"product_attribute_9\"]");
  private By _addToCartButton = By.xpath("//input[@id=\"add-to-cart-button-25\"]");
  private By _clickOnAddToBarLink = By.xpath("//a[text()=\"shopping cart\"]");
  private By _checkTermscheckbox = By.id("termsofservice");
  private By _checkOutButton = By.id("checkout");
  private By _continue_1Button = By.xpath("//*[@id=\"billing-buttons-container\"]/input");
  private By _selectNextDayAirRadioButton = By.xpath("//input[@id=\"shippingoption_1\"]");
  private By _continue_2Button = By.xpath("//input[@onclick=\"ShippingMethod.save()\"]");
  private By _paymentMethodSelect = By.id("paymentmethod_1");
  private By _continue_3Button = By.xpath("//input[@onclick=\"PaymentMethod.save()\"]");
  private By _cardTypeSelect = By.className("dropdownlists");
  private By _cardNameField = By.id("CardholderName");
  private By _cardNumberField = By.id("CardNumber");
  private By _expiryMonthSelect = By.xpath("//*[@id=\"ExpireMonth\"]");
  private By _expiryYearSelect = By.id("ExpireYear");
  private By _CVVField = By.id("CardCode");
  private By _continue_4Button = By.xpath("//input[@onclick=\"PaymentInfo.save()\"]");
  private By _confirmButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input");
  private By _orderConfirmation = By.xpath("//strong[text()=\"Your order has been successfully processed!\"]");
  private By _infoBarLink = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
  private By _shoppingCartButton = By.className("cart-label");
  private By _countryInputSelect = By.className("country-input");
  private By _postcodeField = By.className("zip-input");
  private By _checkOutAsGuestButton = By.xpath("//input[@value=\"Checkout as Guest\"]");
  private By _checkoutFirstNameField = By.id("BillingNewAddress_FirstName");
  private By _checkoutLastNameField = By.id("BillingNewAddress_LastName");
  private By _emailAddressField = By.id("BillingNewAddress_Email");
  private By _countryGuestSelect = By.id("BillingNewAddress_CountryId");
  private By _cityField = By.id("BillingNewAddress_City");
  private By _address1Field = By.id("BillingNewAddress_Address1");
  private By _postCode2Field = By.id("BillingNewAddress_ZipPostalCode");
  private By _phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
  private By _continue_5Button = By.xpath("//input[@class=\"button-1 order-completed-continue-button\"]");


  public void addProductToCart(){

    clickElement(_addFirstProductButton);
    waitForElementToBeInvisible(_infoBarLink,6);


  }

  public void addShoesToCart(){


    clickElement(_ApperalImage);
    clickElement(_shoesCatagoryImage);
    clickElement(_shoesAddToCartOptionsButton);
    selectByValue(_shoeSizeSelect, prop.getProperty("shoesize"));
    clickElement(_addToCartButton);

  }

  public void shoppingCheckout(){
    clickElement(_clickOnAddToBarLink);
    clickElement(_checkTermscheckbox);
    clickElement(_checkOutButton);
    clickElement(_continue_1Button);
    waitForElementToBeInvisible(_continue_1Button, 5);
    clickElement(_selectNextDayAirRadioButton);
    waitAndClick(_continue_2Button, 5);

  }

  public void paymentMethod(){

    clickElement(_paymentMethodSelect);
    waitAndClick(_continue_3Button,5);
  }

  public void paymentInformaiton(){

    selectByValue(_cardTypeSelect,prop.getProperty("card"));
    enterText(_cardNameField,prop.getProperty("Cardname"));
    enterText(_cardNumberField,prop.getProperty("CardNumber"));
    selectByValue(_expiryMonthSelect,"6");
    selectByVisibleText(_expiryYearSelect, prop.getProperty("expiryYear"));
    enterText(_CVVField,prop.getProperty("CVV"));
    waitAndClick(_continue_4Button,5);
    waitAndClick(_confirmButton,5);

  }

public void orderPlaceCheck(){

  Assert.assertEquals(getTextFromElement(_orderConfirmation), "Your order has been successfully processed!");
}

public void guestCheckOut () throws InterruptedException {

    clickElement(_addFirstProductButton);
    clickElement(_clickOnAddToBarLink);
    Thread.sleep(1000);
    //clickElement(_shoppingCartButton);

    selectByValue(_countryInputSelect,prop.getProperty("country"));
    enterText(_postcodeField,prop.getProperty("postcode"));
    clickElement(_checkTermscheckbox);
    clickElement(_checkOutButton);
    waitForElementToBeDisplayed(_checkOutAsGuestButton,4);
    clickElement(_checkOutAsGuestButton);
    enterText(_checkoutFirstNameField,prop.getProperty("firstname"));
    enterText(_checkoutLastNameField,prop.getProperty("lastname"));
    enterText(_emailAddressField,prop.getProperty("refer"));
    selectByValue(_countryGuestSelect,prop.getProperty("country"));
    enterText(_cityField,prop.getProperty("city"));
    enterText(_address1Field, prop.getProperty("add1"));
    enterText(_postCode2Field,prop.getProperty("postcode"));
    enterText(_phoneNumberField,prop.getProperty("mobile"));
    clickElement(_continue_1Button);
    waitForElementToBeInvisible(_continue_1Button, 5);
    clickElement(_selectNextDayAirRadioButton);
    waitAndClick(_continue_2Button, 5);
    }

    public void continueToHomePage(){

    waitAndClick(_continue_5Button,3);
    }


}
