package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseWebDriver {


    public WebDriver driver;

    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ura\\Downloads\\chromedriver.exe");
    }



    @BeforeMethod(alwaysRun = true)
    public void start()
    {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.get(Variables.url);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

    }
    @AfterMethod(alwaysRun = true)
    public void finish()
    {
        driver.quit();
    }
}
