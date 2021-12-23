package mk.sedc.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By signIn = By.className("login");
    private By women = By.xpath("//*[text()=\"Women\"]");
    private By searchBox = By.xpath("//*[@id='contact-link']");
    private By searchSomething = By.xpath("//*[@name='search_query']");
    private By searchBtn = By.xpath("//*[@name=\"submit_search\"]");



    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signIn)).click();
    }
    public void openWomen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(women)).click();
    }
    public void search(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).click();
    }
    public void setSearchSomething(String item){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSomething)).sendKeys(item);
    }
    public void clickSearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBtn)).click();
    }
}
