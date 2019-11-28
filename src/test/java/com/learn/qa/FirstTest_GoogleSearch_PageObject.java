package com.learn.qa;

import com.learn.pages.GoogleSearchPage;
import com.learn.pages.GoogleSearchPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest_GoogleSearch_PageObject {

    static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        googleSearch(driver);
    }

    public static void googleSearch(WebDriver driver) throws InterruptedException {
        driver.get("https://google.com");
        GoogleSearchPageObjects obj =  new GoogleSearchPageObjects(driver);
        obj.setTextInSearchBox("Paid era");
        Thread.sleep(4000);
        obj.clickSearchButton();
        driver.close();
        driver.quit();
    }

}
