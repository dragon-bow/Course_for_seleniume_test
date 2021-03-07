import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StikersTest {

    private WebDriver webDriver;
    private WebDriverWait wait;


    @Before
    public void before() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 10);
    }


    @Test
    public void myTest() {
        webDriver.navigate().to("http://localhost/litecart/");

        List<WebElement> list = webDriver.findElements(By.cssSelector(".product.column"));
        for (WebElement element : list) {
            int i = element.findElements(By.cssSelector(".sticker")).size();
            Assert.assertEquals(i, 1);

        }

    }


    @After
    public void stop() {
        webDriver.close();
        webDriver = null;
    }
}
