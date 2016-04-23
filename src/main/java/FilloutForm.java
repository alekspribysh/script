import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.security.Key;


/**
 * Created by aprybysh on 4/22/16.
 */
public class FilloutForm {


    //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    WebDriver driver = new ChromeDriver();

    //WebDriver driver = new FirefoxDriver();

    public String  page = "http://www.myhcl.com";
    public String  login = "aliaksandr.prybysh";
    public String password = "aleksandr1985%";


    @Test
    public void getPage (){
        driver.get(page);
        getUserId();
        fillOutTimeshet();
    }

    @Test

    public void getUserId (){
        driver.findElement(By.id("txtUserID")).sendKeys(login);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("ddlDomain")).click();
        new Select(driver.findElement(By.id("ddlDomain"))).selectByVisibleText("GEO");
        driver.findElement(By.id("ddlDomain")).sendKeys(Keys.ENTER);
       // driver.findElement(By.id("btnSubmit")).click();
        WebElement e = driver.findElement(By.xpath("//*[@class ='dropDown dd2']"));
        e.click();
        driver.findElement(By.xpath("//*[@href='https://wf4.myhcl.com/TSMS/']")).click();
        driver.findElement(By.xpath("//*[@value = 'Skip & Close']")).click();
        driver.findElement(By.className("sitelink3")).click();
        try {
            driver.findElement(By.id("btnCheckIn")).click();
        }
        catch ( Exception n){

            System.out.println("Beee");

        }


    }

    @Test

    public void fillOutTimeshet(){

        driver.findElement(By.id("chkCopyToNextWeek")).click();
        driver.findElement(By.id("chkMealBreak")).click();
        driver.findElement(By.id("LinkNext")).click();
        WebElement d0  = driver.findElement(By.id("txtHoursRow0Day0"));
        d0.clear();
        d0.sendKeys("08:00");
        WebElement d1  = driver.findElement(By.id("txtHoursRow0Day1"));
        d1.clear();
        d1.sendKeys("08:00");
        WebElement d2  = driver.findElement(By.id("txtHoursRow0Day2"));
        d2.clear();
        d2.sendKeys("08:00");
        WebElement d3  = driver.findElement(By.id("txtHoursRow0Day3"));
        d3.clear();
        d3.sendKeys("08:00");
        WebElement d4  = driver.findElement(By.id("txtHoursRow0Day4"));
        d4.clear();
        d4.sendKeys("08:00");
        WebElement l0 =  driver.findElement(By.id("txtHoursRow1Day0"));
        l0.clear();
        l0.sendKeys("00:30");
        WebElement l1 =  driver.findElement(By.id("txtHoursRow1Day1"));
        l1.clear();
        l1.sendKeys("00:30");
        WebElement l2 =  driver.findElement(By.id("txtHoursRow1Day2"));
        l2.clear();
        l2.sendKeys("00:30");
        WebElement l3 =  driver.findElement(By.id("txtHoursRow1Day3"));
        l3.clear();
        l3.sendKeys("00:30");
        WebElement l4 =  driver.findElement(By.id("txtHoursRow1Day4"));
        l4.clear();
        l4.sendKeys("00:30");
        driver.findElement(By.id("chkCopyToNextWeek")).click();
        driver.findElement(By.id("chkMealBreak")).click();
        driver.findElement(By.id("btnSave")).click();
    }

}
