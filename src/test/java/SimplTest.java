import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimplTest {
    private static final Logger logger = LoggerFactory.getLogger(SimplTest.class);

    @Test
    public void mySimpleTest() {
        logger.info("Initializing ChromeDriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3_000 ));;
        //Gett
        logger.info("Opening URL:https://www.google.com");
        driver.get("https://www.google.com");

        logger.info("Accept cookies n stuff");
        driver.findElement(By.id("L2AGLb")).click();

        logger.info("Serching for acodemy.lv");
        driver.findElement(By.name("q")).sendKeys("acodemy.lv");

        logger.info("Performing search");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        logger.info("Validate search result count");


        //Close browser?
        logger.info("Closing ChromeDriver");
        driver.close();
        driver.quit();

    }
}
