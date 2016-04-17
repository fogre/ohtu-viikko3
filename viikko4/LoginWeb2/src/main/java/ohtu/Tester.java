package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );


        // epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaarasalasana");
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println(driver.getPageSource());

        // epäonnistunut kirjautuminen: ei-olemassaoleva käyttäjätunnus
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("login"));
        element.click();
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        System.out.println(driver.getPageSource());

        // uuden käyttäjätunnuksen luominen
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        System.out.println(driver.getPageSource());
        element = driver.findElement(By.name("username"));
        element.sendKeys("uusitunnus");
        element = driver.findElement(By.name("password"));
        element.sendKeys("uusI11");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("uusI11");
        element = driver.findElement(By.name("add"));
        element.submit();
        System.out.println(driver.getPageSource());
        
        // uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        System.out.println(driver.getPageSource());
        
    }
}
