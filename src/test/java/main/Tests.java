package main;



import javafx.scene.shape.MoveTo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.*;
import tools.*;
import org.testng.annotations.Test;

import java.io.IOException;
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
        Thread.sleep (1000);
        WebElement element2 = driver.findElement (By.cssSelector (TenetPage.password));
        element2.sendKeys (Variables.password);
        Thread.sleep (1000);
        WebElement element3 = driver.findElement (By.cssSelector (TenetPage.next));
        element3.click ();
        Thread.sleep (2000);
        WebElement element4 = driver.findElement (By.cssSelector (TenetPage.channel53));
        scrollToElement (element4);
        System.out.println (driver.findElement (By.cssSelector (TenetPage.channel53)).getText ());
        driver.findElement (By.cssSelector (TenetPage.channel53)).click ();



    }


    @Test
    public void tenet() throws InterruptedException {
        WebElement element = driver.findElement (By.cssSelector (TenetPage.entrance));
        element.click ();
        WebElement element1 = driver.findElement (By.cssSelector (TenetPage.login));
        element1.sendKeys (Variables.login);
        Thread.sleep (1000);
        WebElement element2 = driver.findElement (By.cssSelector (TenetPage.password));
        element2.sendKeys (Variables.password);
        Thread.sleep (1000);
        driver.findElement (By.cssSelector (TenetPage.next)).click ();
        Thread.sleep (2000);
        driver.findElement (By.cssSelector (TenetPage.categories)).click ();
        driver.findElement (By.cssSelector (TenetPage.channelCategories)).click ();

        int b = 0;
        ChannelPage channelPage = new ChannelPage ();
        try {
            for (String a : channelPage.addList ()){
                WebElement element5 = driver.findElement (By.cssSelector (a));
                scrollToElement (element5);
                //Thread.sleep (1000);
                element5.click ();
                Thread.sleep (1000);
                b++;
                System.out.println (" " +element5.getText ());
                System.out.println ();
            }
        } catch (NoSuchElementException ignore) {
            System.out.println ("channel error");
        } catch (ElementNotVisibleException ignore) {

        }

        System.out.println (b + " channel");



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