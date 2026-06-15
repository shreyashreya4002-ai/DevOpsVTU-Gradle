package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WebpageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        Thread.sleep(2000);

        driver.get("https://shreyashreya4002-ai.github.io/DevopsVTU-MVN/");
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        String expectedTitle = "My Simple Website";

        // Validate title
        Assert.assertEquals(actualTitle, expectedTitle);

        // Check whether title contains "Website"
        assertTrue(actualTitle.contains("Website"),
                "Title contains 'Website'");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(1000);

        if (driver != null) {
            driver.quit();
        }
    }
}