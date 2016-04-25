import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


/**
 * Created by aprybysh on 4/22/16.
 */
public class FilloutForm {


    //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    WebDriver driver = new ChromeDriver();
   // WebDriver driver = new HtmlUnitDriver();

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

        for (int i = 0; i < 5; i++ ){
            WebElement d  = driver.findElement(By.id("txtHoursRow0Day"+i));
           // d.clear();
            d.sendKeys("08:00");
            WebElement l =  driver.findElement(By.id("txtHoursRow1Day"+i));
          //  l.clear();
            l.sendKeys("00:30");
        }

        driver.findElement(By.id("chkCopyToNextWeek")).click();
        driver.findElement(By.id("chkMealBreak")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.quit();
    }

}
