package main;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Locatable;

import org.openqa.selenium.interactions.internal.Coordinates;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.*;
import tools.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests {

    public void scrollToElement(WebElement element) {
        try {
            Coordinates coordinate = ((Locatable) element).getCoordinates ();
            coordinate.onPage ();
            coordinate.inViewPort ();
        } catch (NoSuchElementException ignore) {
        } catch (ElementNotVisibleException ignore) {
        }
    }

    @Test
    public void tv() throws InterruptedException{
        WebElement element = driver.findElement (By.cssSelector (TenetPage.entrance));
        element.click ();
        WebElement element1 = driver.findElement (By.cssSelector (TenetPage.login));
        element1.sendKeys (Variables.login);

        WebElement element2 = driver.findElement (By.cssSelector (TenetPage.password));
        element2.sendKeys (Variables.password);

        WebElement element3 = driver.findElement (By.cssSelector (TenetPage.next));
        element3.click ();

//        WebElement element4 = driver.findElement (By.cssSelector (TenetPage.channel53));
//        scrollToElement (element4);
//        System.out.println (driver.findElement (By.cssSelector (TenetPage.channel53)).getText ());
//        driver.findElement (By.cssSelector (TenetPage.channel53)).click ();
//        driver.findElement (By.cssSelector (TenetPage.tvProgram)).click ();
//        scrollToElement (driver.findElement(By.cssSelector (TenetPage.tvProgramDay)));
//        System.out.println (driver.findElement(By.cssSelector (TenetPage.tvProgramDay)).getText ());





    }


    @Test
    public void tenet() throws InterruptedException {

        String title = driver.getTitle ();
        Assert.assertTrue (title.equals ("ТВ каналы онлайн — смотреть каналы ТВ онлайн в качестве прямой эфир онлайн"));
        driver.findElement (By.cssSelector (TenetPage.entrance)).click ();
        driver.findElement (By.cssSelector (TenetPage.login)).sendKeys (Variables.login);
        driver.findElement (By.cssSelector (TenetPage.password)).sendKeys (Variables.password);
        driver.findElement (By.cssSelector (TenetPage.next)).click ();
        driver.findElement (By.cssSelector (TenetPage.categories)).click ();
        driver.findElement (By.cssSelector (TenetPage.channelCategories)).click ();

        int b = 0;
        int c = 0;
        List list = new ArrayList ();
        ChannelPage channelPage = new ChannelPage ();
        for (String a : channelPage.addList ()){
        try {
                scrollToElement (driver.findElement (By.cssSelector (a)));
                //Thread.sleep (1000);
                driver.findElement (By.cssSelector (a)).click ();
               // Thread.sleep (1000);
                b++;
                System.out.println (" " + driver.findElement (By.cssSelector (a)).getText ());
                System.out.println ();
            
        } catch (NoSuchElementException ignore) {
            System.out.println ("channel error");

            list.add (a);
            c++;
        } catch (ElementNotVisibleException ignore) {

        }}

        System.out.println (b + " channel");

        System.out.println (c);
        for (Object e : list) {
            System.out.println (e);

        }


    }


    @Test
    public void incomingmail() throws InterruptedException {


    }


    public WebDriver driver;

    {
        System.setProperty ("webdriver.chrome.driver", "C:\\Users\\Ura\\Downloads\\chromedriver.exe");
    }


    @BeforeMethod(alwaysRun = true)
    public void start() {
        driver = new ChromeDriver ();
        driver.manage ().window ().maximize ();
        driver.get (Variables.url);
        driver.manage ().deleteAllCookies ();
        driver.manage ().timeouts ().implicitlyWait (8, TimeUnit.SECONDS);

    }

    @AfterMethod(alwaysRun = true)
    public void finish() {
        driver.close ();
    }
}