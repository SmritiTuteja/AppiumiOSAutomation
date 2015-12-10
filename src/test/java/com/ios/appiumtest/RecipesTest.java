package com.ios.appiumtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.URL;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

/**
 * Created by smrititu on 11/12/15.
 */
public class RecipesTest {

    private AppiumDriver<IOSElement> driver;
    public WebDriverWait wait;
    public String newRecipe = "TestAddRecipe";

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/build/Recipes.app");
        driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addRecipe() throws InterruptedException {

        //wait for app to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Recipes")));

        //adding recipe (using accessibility id)
        driver.findElementByAccessibilityId("Add").click();

        driver.findElementById("Recipe Name").sendKeys(newRecipe);

        //explicit wait
        Thread.sleep(3000);

        //save recipe (using xpath)
        driver.findElementByXPath("//UIAApplication[1]/UIAWindow[2]/UIANavigationBar[1]/UIAButton[3]").click();

        //navigate to home page
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Recipes")));
        driver.findElementById("Recipes").click();

        //edit recipe
        editRecipe();

    }

    @Test
    public void editRecipe() throws InterruptedException {

        //open recipe
        driver.findElementByAccessibilityId(newRecipe).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(newRecipe)));

        //edit recipe
        driver.findElementById("Edit").click();

        //adding description
        driver.findElementById("Overview").sendKeys("Testing add recipe");

        //adding ingredients
        driver.findElementByAccessibilityId("Add Ingredient").click();
        driver.findElementById("Name").click();
        driver.findElementById("Name").sendKeys("ingredients test");
        driver.findElementById("Amount").sendKeys("2");

        //save recipe
        driver.findElementByAccessibilityId("Save").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("Done")));
        driver.findElementById("Done").click();
    }


}
