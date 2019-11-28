package com.learn.qa;

import com.learn.pages.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest_GoogleSearch_Page {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        googleSearch(driver);
    }

    public static void googleSearch(WebDriver driver) throws InterruptedException {
        driver.get("https://google.com");
        WebElement element = GoogleSearchPage.textbox_search(driver);
        element.sendKeys("Selenium page model");

        // Below will press enter key (Return is enter)
        Thread.sleep(5000);
        element = GoogleSearchPage.button_search(driver);
        element.sendKeys(Keys.RETURN);

        driver.close();
        driver.quit();
    }

}
