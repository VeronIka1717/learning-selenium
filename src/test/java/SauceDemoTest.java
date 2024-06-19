import lv.acodemy.page_pageobject.LoginPage;
import lv.acodemy.page_pageobject.ProductsPage;
import lv.acodemy.utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest {
    private static final Logger log= LoggerFactory.getLogger(SauceDemoTest.class);
    Config config=Config.readConfig();
    WebDriver driver;
   LoginPage loginPage;
   ProductsPage productsPage;


    @BeforeMethod
    public void beforeTest(){
        //Initiolize driver;
        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        driver.get("https://www.saucedemo.com");
    }
    @Test
    public void testSauceDemoSuccessLogin(){

        //1)URL?->good practice-get url from configuration file
        //2)Page  Object->
        log.info("Authorize using credentials");
        loginPage.authorize(config.getCredentials().getLogin(),config.getCredentials().getPassword());

        log.info("Asserting Products page title");
        Assert.assertEquals( productsPage.getProductPageTitle().getText(),"Products");
    }
    @AfterMethod
    public void afterTest(){
        //Close drive
        driver.close();
        driver.quit();
    }
}
