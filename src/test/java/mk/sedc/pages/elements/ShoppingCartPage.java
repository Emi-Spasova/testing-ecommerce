package mk.sedc.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "http://automationpractice.com/index.php?controller=order";
    private By minus = By.xpath("//*[@class=\"icon-minus\"]");
    private By trash = By.xpath("//*[@class=\"icon-trash\"]");
    private By checkOut = By.xpath("//*[text()=\"Proceed to checkout\"]");



    public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void navigateToPage(){
        driver.get(url);
    }

    public void subtractItem(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(minus)).click();
    }
    public void deleteItem(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(trash)).click();
    }
    public void proceedToCheckOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
    }


}
