package mk.sedc.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By tops = By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/span");
    private By dresses = By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[2]/span");
    private By sortBy = By.id("selectProductSort");
    private By openProduct = By.xpath("//*[@class=\"product_list grid row\"]/li");
    private By size = By.xpath("//*[@id=\"group_1\"]");
    private By color1 = By.id("color_13");
    private By color2 = By.id("color_14");
    private By picture = By.xpath("//*[text()=\"View larger\"]");
    private By nextPicture = By.xpath("//*[@title=\"Next\"]");
    private By closePicture = By.xpath("//*[@title=\"Close\"]");
    private By plus = By.xpath("//*[@class=\"icon-plus\"]");
    private By submit = By.id("add_to_cart");
    private By continueBtn = By.xpath("//*[contains(@class,'continue')]");
    private By openDresses = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]");
    private By categoryDresses = By.xpath("//*[@id=\"subcategories\"]/ul/li/div/a");
    private By toCart = By.xpath("//*[text()=\"Add to cart\"]");
    private By moreForProduct = By.xpath("//*[text()=\"More\"]");
    private By checkOut = By.xpath("//*[@title=\"Proceed to checkout\"]");




    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void expandTops(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(tops)).click();
    }
    public void expandDresses(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dresses)).click();
    }
    public void sortProductsBy(int index){
        WebElement element = driver.findElement(sortBy);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void moreForProduct(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(openProduct)).click();
    }
    public void chooseSize(int index){
        WebElement element = driver.findElement(size);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    public void seeColors(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(color2)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(color1)).click();
    }
    public void viewLarger(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(picture)).click();
    }
    public void nextPucture(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPicture)).click();
    }
    public void closePucture(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePicture)).click();
    }
    public void addQuantity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(plus)).click();
    }
    public void addToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }
    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueBtn)).click();
    }
    public void navigateToDresses(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(openDresses)).click();
    }
    public void chooseDressCategory(int index){
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDresses)).click();
    }
    public void addToCartDirectly(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(toCart)).click();
    }
    public void openMore(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreForProduct)).click();
    }
    public void proceedToCheckOut(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
    }
}
