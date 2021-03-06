import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstClass {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @Before
    public void start() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 4);
    }


    @Test
    public void myTest() {
        webDriver.navigate().to("http://www.google.com");;
        webDriver.findElement(By.name("q")).sendKeys("webdriver");
        webDriver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }


    @After
    public void stop() {
        webDriver.close();
        webDriver = null;
    }
}
