import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationTest {

    private WebDriver webDriver;
    private WebDriverWait wait;
    private final String USERNAME_BOTTON = "//*[@name='username']";
    private final String PASSWORD_BOTTON = "//*[@name='password']";
    private final String LOGGIN_BOTTON = ".footer button";
    private final String MENU_BLOCK = "#box-apps-menu-wrapper";
    private final String LOGGIN_PASSWORD = "admin";


    @Before
    public void beforeTest() {
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, 4);
    }


    @Test
    public void authorizationTest() {
        webDriver.navigate().to("http://localhost/litecart/admin");
        webDriver.findElement(By.xpath(USERNAME_BOTTON)).sendKeys(LOGGIN_PASSWORD);
        webDriver.findElement(By.xpath(PASSWORD_BOTTON)).sendKeys(LOGGIN_PASSWORD);
        webDriver.findElement(By.cssSelector(LOGGIN_BOTTON)).click();
        webDriver.findElement(By.cssSelector(MENU_BLOCK)).isDisplayed();

    }

    @After
    public void afterTest() {
        webDriver.close();
        webDriver = null;
    }
}
