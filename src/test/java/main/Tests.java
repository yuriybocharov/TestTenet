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
        String title = driver.getTitle ();
        Assert.assertTrue (title.equals ("ТВ каналы онлайн — смотреть каналы ТВ онлайн в качестве прямой эфир онлайн"));
        driver.findElement (By.cssSelector (TenetPage.entrance)).click ();
        driver.findElement (By.cssSelector (TenetPage.login)).sendKeys (Variables.login);
        driver.findElement (By.cssSelector (TenetPage.password)).sendKeys (Variables.password);
        driver.findElement (By.cssSelector (TenetPage.next)).click ();

        List list = new ArrayList ();
        WebElement element = driver.findElement (By.id ("inner_chanlist"));
        List<WebElement> elements = element.findElements (By.cssSelector ("a"));
        int b = 0;
        int c = 0;
        for (WebElement a : elements) {

            try {
                scrollToElement (a);
                a.click ();
                b++;
                System.out.println (" " + a.getText ());
                System.out.println ();

            }catch (NoSuchElementException ignore) {
                System.out.println ("channel error");

                list.add (a);
                c++;
                b--;
            } catch (ElementNotVisibleException ignore) {
            }}
        System.out.println (b + " channel");

        System.out.println (c + "channel error");
        for (Object e : list) {
            System.out.println (e);
        }
    }



    @Test
    public void tv1() throws InterruptedException{
        String title = driver.getTitle ();
        Assert.assertTrue (title.equals ("ТВ каналы онлайн — смотреть каналы ТВ онлайн в качестве прямой эфир онлайн"));
        driver.findElement (By.cssSelector (TenetPage.entrance)).click ();
        driver.findElement (By.cssSelector (TenetPage.login)).sendKeys (Variables.login);
        driver.findElement (By.cssSelector (TenetPage.password)).sendKeys (Variables.password);
        driver.findElement (By.cssSelector (TenetPage.next)).click ();

        List list = new ArrayList ();
        WebElement element = driver.findElement (By.id ("inner_chanlist"));
        List<WebElement> elements = element.findElements (By.cssSelector ("a"));
        int b = 0;
        int c = 0;
        for (WebElement a : elements) {

            try {
                scrollToElement (a);
                a.click ();
                b++;
                String d = a.findElement (By.className ("channel-number")).getText () + " " + a.findElement (By.className ("name-chennal")).getText ();

                System.out.println (d);

            }catch (NoSuchElementException ignore) {
                System.out.println ("channel error");

                list.add (a);
                c++;
                b--;
            } catch (ElementNotVisibleException ignore) {
            }}
        System.out.println (b + " channel");

        System.out.println (c + "channel error");
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