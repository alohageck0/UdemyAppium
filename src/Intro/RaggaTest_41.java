package Intro;

import com.github.genium_framework.appium.support.server.AppiumServer;
import com.github.genium_framework.server.ServerArguments;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RaggaTest_41 {
   private ServerArguments serverArguments = new ServerArguments();
   private AppiumServer appiumServer;
//

   @Before
   public void startUp() {
      serverArguments = new ServerArguments();
      serverArguments.setArgument("--address", "127.0.0.1");

      serverArguments.setArgument("--no-reset", true);

      serverArguments.setArgument("--local-timezone", true);
      serverArguments.setArgument("--device-ready-timeout", "100");
      appiumServer = new AppiumServer(serverArguments);
      appiumServer.startServer();
   }

   @After
   public void cleanUp() {
      appiumServer.stopServer();
   }

   @Test
   public void test() throws MalformedURLException, InterruptedException {
      File appDir = new File("src");
      File app = new File(appDir, "base.apk");


      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 200);
      cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//      cap.setCapability("appPackage", "com.raaga.android");
//      cap.setCapability("appActivity", ".SplashScreen");
      cap.setCapability(MobileCapabilityType.NO_RESET, true);

      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

      driver.swipe(5, 500, 250, 500, 1000);

   }
}
