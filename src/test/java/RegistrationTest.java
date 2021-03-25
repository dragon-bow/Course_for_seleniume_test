import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.stream.Collectors;

public class RegistrationTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://localhost/litecart/en/";
    private Select selectCountry;
    private final String NEW_CUSTOMER_BUTTON = ".content td a[href*='create']";
    private final String TAX_ID_INPUT = "[name ='tax_id']";
    private final String COMPANY_INPUT = "[name ='company']";
    private final String FIRST_INPUT = "[name ='firstname']";
    private final String LASTNAME_INPUT = "[name ='lastname']";
    private final String ADDRESS_INPUT = "[name ='address1']";
    private final String POSTCODE_INPUT = "[name ='postcode']";
    private final String CITY_INPUT = "[name ='city']";
    private final String SELECTOR_CONTRY = "[name ='country_code'] ";
    private final String EMAIL_INPUT = "[name ='email']";
    private final String PHONE_INPUT = "[name ='phone']";
    private final String PASSWORD_INPUT = "[name ='password']";
    private final String CONFIRMED_PASSWORD_BUTTON = "[name ='confirmed_password']";
    private final String CREATE_ACCOUNT_BUTTON = "[name ='create_account']";
    private final String LOGOUT_BUTTON = " li a[href*='logout']";
    private final String EMAIL_ADRESS_FOR_AUTH = "#box-account-login [name='email']";
    private final String PASSWORD_FOR_AUTH = "#box-account-login [name='password']";
    private final String LOGIN_BUTTON = ".button-set [name='login']";


    public String email;
    public String phoneNumber = "+99999";
    public String firstName = "Nikki";
    public String lastName = "Zimn";
    public String password = "1234";
    public String adress = "Moscow Pol street 123";
    public String company = "Webinar";
    public String city = "SomeCity";

    @Before
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        String random = new Random().ints(5, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        email = random + "@yandex.ru";
    }

    @Test
    public void test() throws InterruptedException {
        driver.navigate().to(BASE_URL);
        driver.findElement(By.cssSelector(NEW_CUSTOMER_BUTTON)).click();
        Thread.sleep(500);
        driver.findElement(By.cssSelector(TAX_ID_INPUT)).sendKeys("1");
        driver.findElement(By.cssSelector(COMPANY_INPUT)).sendKeys(company);
        driver.findElement(By.cssSelector(FIRST_INPUT)).sendKeys(firstName);
        driver.findElement(By.cssSelector(LASTNAME_INPUT)).sendKeys(lastName);
        driver.findElement(By.cssSelector(ADDRESS_INPUT)).sendKeys(adress);
        driver.findElement(By.cssSelector(POSTCODE_INPUT)).sendKeys("12722");
        driver.findElement(By.cssSelector(CITY_INPUT)).sendKeys(city);
        driver.findElement(By.cssSelector(".select2-selection__arrow b")).click();
        driver.findElement(By.cssSelector(".select2-results__option[id*='US']")).click();
        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        wait.until((WebDriver d) ->d.findElement(By.cssSelector("select[name='zone_code'] option[value='AA']")));
        driver.findElement(By.cssSelector("select[name='zone_code'] option[value='AA']")).click();
        driver.findElement(By.cssSelector("select[name='zone_code']")).click();
        driver.findElement(By.cssSelector(EMAIL_INPUT)).sendKeys(email);
        driver.findElement(By.cssSelector(PHONE_INPUT)).sendKeys(phoneNumber);
        driver.findElement(By.cssSelector(PASSWORD_INPUT)).sendKeys(password);
        driver.findElement(By.cssSelector(CONFIRMED_PASSWORD_BUTTON)).sendKeys(password);
        driver.findElement(By.cssSelector(CREATE_ACCOUNT_BUTTON)).click();
        driver.findElement(By.cssSelector(LOGOUT_BUTTON)).click();
        driver.findElement(By.cssSelector(EMAIL_ADRESS_FOR_AUTH)).sendKeys(email);
        driver.findElement(By.cssSelector(PASSWORD_FOR_AUTH)).sendKeys(password);
        driver.findElement(By.cssSelector(LOGIN_BUTTON)).click();
        driver.findElement(By.cssSelector(LOGOUT_BUTTON)).click();

    }

    @After
    public void after() {
        driver.close();
        driver = null;
    }

}
