package mk.sedc.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By typeEmail = By.xpath("//*[@id=\"email_create\"]");
    private By clickCreate = By.id("SubmitCreate");
    private By gender = By.className("radio-inline");
    private By firstName = By.id("customer_firstname");
    private By lastName = By.id("customer_lastname");
    private By email = By.id("email");
    private By password = By.id("passwd");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");
    private By specialOffers = By.id("uniform-optin");
    private By addressFName = By.id("firstname");
    private By addressLName = By.id("lastname");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By state = By.id("id_state");
    private By chooseState = By.xpath(" //*[@id='id_state']/option");
    private By postalCode = By.id("postcode");
    private By phoneNumber = By.id("phone_mobile");
    private By aliasAddres = By.id("alias");
    private By clickRegister = By.id("submitAccount");

    private WebElement element;



    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void writeEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(typeEmail)).sendKeys(email);
    }
    public void nextStep() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickCreate)).click();
    }
    public void chooseGender(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(gender)).click();
    }
    public void typeFirstName(String fName) {
       wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
    }
    public void typeLastName(String lName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys(lName);
    }
    public void typePassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);
    }
    public void chooseDay(int day){
        WebElement element = driver.findElement(days);
        Select select = new Select(element);
        select.selectByIndex(day);
    }
    public void chooseMonth(int month){
        WebElement element = driver.findElement(months);
        Select select = new Select(element);
        select.selectByIndex(month);
    }
    public void chooseYear(String year){
        WebElement element = driver.findElement(years);
        Select select = new Select(element);
        select.selectByValue(year);
    }
    public void specialOffers() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(specialOffers)).click();
    }
    public void clearAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.address)).clear();
    }
    public void typeAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.address)).sendKeys(address);
    }
    public void typeCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.city)).sendKeys(city);
    }
    public void chooseState(String State){
        WebElement element = driver.findElement(state);
        Select select = new Select(element);
        select.selectByVisibleText(State);
    }
    public void typePostalCode(String posCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode)).sendKeys(posCode);
    }
    public void typePhoneNumber(String number) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber)).sendKeys(number);
    }
    public void clearAliasAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aliasAddres)).clear();
    }
    public void typeAliasAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(aliasAddres)).sendKeys(address);
    }
    public void register() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickRegister)).click();
    }
    }
