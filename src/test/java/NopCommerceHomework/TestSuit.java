package NopCommerceHomework;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest{

  HomePage homePage = new HomePage();
  RegistrationPage registrationPage = new RegistrationPage();
  LogInPage loginPage = new LogInPage();
  ReferAProductToFriend referAProductToFriend = new ReferAProductToFriend();
  ShoppingCart shopping = new ShoppingCart();

  @Test

  public void usershouldBeAbleToRegisterSuccessfully(){

homePage.clickOnRegister();
registrationPage.toVerifyUserIsOnRegisterPage();
registrationPage.clickOnRegister();
registrationPage.toConfirmRegistrationSuccessfull();

  }

  @Test
  public void registeredUserShouldBeAbleToReferAProductToFriend(){

    homePage.clickOnLogin();
    loginPage.checkLoginPageDisplayed();
    loginPage.clickLogin();
    loginPage.checkUserLoggedIn();
    referAProductToFriend.referProduct();
    referAProductToFriend.referSuccess();
    homePage.clickOnLogout();

  }


  @Test
  public void userShouldNotBeAbleToReferProductToFriendIfNotRegistered(){

  referAProductToFriend.cannotReferProduct();
  referAProductToFriend.referFailed();
  }


  @Test
  public void userShouldBeAbleToByProductSuccessfullyWhenLoggedIn(){

    homePage.clickOnLogin();
    loginPage.clickLogin();
    shopping.addProductToCart();
    shopping.addShoesToCart();
    shopping.shoppingCheckout();
    shopping.paymentMethod();
    shopping.paymentInformaiton();
    shopping.orderPlaceCheck();
    shopping.continueToHomePage();
  }

  @Test
  public void userShouldBeAbleToPurchaseProductAsGuest() throws InterruptedException {


    shopping.guestCheckOut();
    shopping.paymentMethod();
    shopping.paymentInformaiton();
    shopping.orderPlaceCheck();
    shopping.continueToHomePage();


  }




}
