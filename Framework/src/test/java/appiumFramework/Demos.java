package appiumFramework;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.io.IOException;

public class Demos extends capabilities {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException {

		Runtime.getRuntime().exec("taskkill /f /im node.exe");
Thread.sleep(3000);
		
		
		
	}

	@Test(enabled = false, testName = "Login")
	public void testCase1() {
		// working with first screen functionality: name, radio button drop down select
		// India and click on lets shop
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Let's Shop\")").click();

	}

	@Test(enabled = false)
	public void testCase2() {
		// working with first screen functionality: name, radio button drop down select
		// India and click on lets shop
		// driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String actualText = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Please enter your name");
	}

	@Test(testName = "no of elements", enabled = false)
	public void testCase3() throws InterruptedException {
		// working with first screen functionality: name, radio button drop down select
		// India and click on lets shop
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Thread.sleep(2000);
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))");
		int noofproducts = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(noofproducts);

		for (int i = 0; i < noofproducts; i++) {
			String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if (name.equals("Air Jordan 9 Retro")) {

				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				;
				break;
			}
		}

	driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	Thread.sleep(2000);
	String productName = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/productName")).getText();
	Assert.assertEquals(productName, "Air Jordan 9 Retro");
	
	
	}

	
	@Test
	public void testCase4() throws InterruptedException, IOException {
		Service = startServer();
		driver = capability(appactivity, apppackage, devicename, platform);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		// working with first screen functionality: name, radio button drop down select
		// India and click on lets shop
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		driver.findElement(MobileBy.xpath("//*[@text='Female']")).click();
		driver.findElement(MobileBy.id("android:id/text1")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));");
		driver.findElementByAndroidUIAutomator("text(\"Australia\")").click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(2000);
int count = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).size();

for (int i=0; i<count; i++)
{
	driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
	//or id index will always starts from 0 so we can use as below:
		//driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productAddCart")).get(0).click(); 
		Thread.sleep(1000);
}
		
driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();




	Thread.sleep(2000);
	String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
	amount1 = amount1.substring(1);
	Double total = Double.parseDouble(amount1);
	System.out.println(amount1);
	
	String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
	amount2= amount2.substring(1);
	total = total + Double.parseDouble(amount2);
	System.out.println(amount2);
	
	System.out.println(total);
	
	String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	totalAmount = 	totalAmount.substring(1);
	Double actualAmount = Double.parseDouble(totalAmount);
	System.out.println(actualAmount);
	
	Assert.assertEquals(actualAmount, total);
	
	WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
	TouchAction t = new TouchAction(driver);
	t.tap(tapOptions().withElement(element(checkbox))).perform();
	
	WebElement termAndCond = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	t.longPress(longPressOptions().withElement(element(termAndCond)).withDuration(ofSeconds(3))).release().perform();
	
	driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(8000);
	
	//switched to webapp
	Set<String> contextNames = driver.getContextHandles();
	for (String contextName : contextNames) {
	    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
	}
	
	//switched between native app to webapp
	//moving context to webapp and testing google page
	driver.context("WEBVIEW_com.androidsample.generalstore");
	driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
	driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);	
	Thread.sleep(3000);
	driver.longPressKey(new KeyEvent(AndroidKey.BACK));
	driver.context("NATIVE_APP");
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void afterTest() throws IOException {
	
		Runtime.getRuntime().exec("taskkill /F /IM qemu-system-i386.exe");
		Service.stop();
	}

}
