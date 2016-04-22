import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLSelectElement;

/**
 * Created by aprybysh on 4/22/16.
 */
public class FilloutForm {


    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new FirefoxDriver();

    public String  page = "http://www.myhcl.com";
    public String  login = "aliaksandr.prybysh";
    public String password = "aleksandr1985$";


    @Test
    public void getPage (){
        driver.get(page);
        getUserId();
    }

    @Test

    public void getUserId (){
        driver.findElement(By.id("txtUserID")).sendKeys(login);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("ddlDomain")).click();
       // new Select(driver.findElement(By.id("ddlDomain"))).selectByVisibleText("GEO");

        WebElement mySelectElm = driver.findElement(By.id("ddlDomain"));
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("GEO");





    }

}
