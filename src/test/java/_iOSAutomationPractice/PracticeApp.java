package _iOSAutomationPractice;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PracticeApp {
   private DesiredCapabilities capabilities = new DesiredCapabilities();
   private File app = new File("/Users/royalfiish/IdeaProjects/UdemyAppium/src/test/java/_iOSAutomationPractice/UICatalog.app");
   private IOSDriver driver;
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;

   @Before
   public void setUp() throws MalformedURLException {
//      serverArguments = new ServerArguments();
//      serverArguments.setArgument("--address", "127.0.0.1");
//
////      serverArguments.setArgument("--no-reset", true);
//
//      serverArguments.setArgument("--local-timezone", true);
//      serverArguments.setArgument("--device-ready-timeout", "10");
//      appiumServer = new AppiumServer(serverArguments);
//      appiumServer.startServer();

      capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3");
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 4s");
      capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
      driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

   }

   @After
   public void cleanUp() {
//      appiumServer.stopServer();

   }

   @Test
   public void Test() {
      TouchAction touchAction = new TouchAction(driver);
      touchAction.tap(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]"))).perform();
      touchAction.tap(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]"))).perform();
      touchAction.tap(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]"))).perform();
      touchAction.tap(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIASwitch[1]"))).perform();

   }
}
