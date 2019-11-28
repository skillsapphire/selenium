import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

    public static void main(String[] args){

        /*WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement input = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        input.sendKeys("Selenium qa");*/
        runFirefox();

    }

    public static void runChrome(){
        String basePath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",basePath+"/drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://skillsapphire.com");
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        driver.close();
    }
    public static void runFirefox(){
        String basePath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver",basePath+"/drivers/geckodriver/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://paidera.com/?r=351116");
        driver.close();
        driver.quit();
    }
}
