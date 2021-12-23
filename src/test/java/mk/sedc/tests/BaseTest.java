package mk.sedc.tests;

import mk.sedc.pages.elements.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public class BaseTest {

    public static final int TIME_OUT = 15;
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public static final String URL = "http://automationpractice.com/index.php";
    public JavascriptExecutor js;
    public SoftAssert sa = new SoftAssert();

    public HomePage homePage;
    public RegistrationPage registrationPage;
    public ProductsPage productsPage;
    public ShoppingCartPage shoppingCartPage;
    public CheckOutPagesPage checkOutPagesPage;


    @Parameters({"browserName"})

    @BeforeClass
    public void set_up(@Optional("CHROME") String browserN) {
        String browser = browserN;

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edgde.driver", "src/test/resources/drivers/edgedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("Browser not supported");
        }

        wait = new WebDriverWait(driver, TIME_OUT);
        js = (JavascriptExecutor) driver;

        homePage = new HomePage(driver, wait);
        registrationPage = new RegistrationPage(driver, wait);
        productsPage = new ProductsPage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkOutPagesPage = new CheckOutPagesPage(driver, wait);


        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterClass
    public void tear_down() {
        driver.quit();
    }


    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(int pix) {
        js.executeScript("window.scrollBy(0, " + pix + ")");
    }
}
