package NopCommerceHomework;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Utils {

  BrowserSelector browserSelector = new BrowserSelector();
 LoadProp prop = new LoadProp();

  @BeforeMethod

  public void setUpBrowser(){

    browserSelector.setUpBrowser();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(prop.getProperty("url"));
  }

  @AfterMethod

  //creating a method to take screenshot if the test fails
  public void screenShot(ITestResult result){
    //here we are comparing if the test fails, only then it will enter the if condition loop
    if (ITestResult.FAILURE == result.getStatus()) {
      try {
        // Create reference of TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Calling the method to take the screenshot
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Copy files to specific location here it will save all screenshot in our project home directory and
        // result.getName() will return name of test case so that screenshot name will be same
        FileUtils.copyFile(source, new File("src\\test\\Resources\\ScreenShots\\" + result.getName() + randomNumber() + ".png"));

        System.out.println("ScreenShot Taken");
      } catch (Exception e) {

        System.out.println("Exception while taking screenshot" + e.getMessage());
      }

    }

    driver.quit();
  }
 /* public void closeBrowser(){

    driver.quit();
  } */
}
