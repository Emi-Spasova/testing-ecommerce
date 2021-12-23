package mk.sedc.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPagesPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By firstName = By.xpath("//*[@class=\"address_firstname address_lastname\"]");
    private By address = By.xpath("//*[@class=\"address_address1 address_address2\"]");
    private By cityAndState = By.xpath("//*[@class=\"address_city address_state_name address_postcode\"]");
    private By country = By.xpath("//*[@class=\"address_country_name\"]");
    private By phone = By.xpath("//*[@class=\"address_phone\"]");
    private By update = By.xpath("//*[@class=\"address_update\"]/a");
    private By newAddress = By.id("submitAddress");
    private By shipping = By.xpath("//*[@name=\"processAddress\"]");
    private By terms = By.id("uniform-cgv");
    private By payment = By.xpath("//*[@name=\"processCarrier\"]");
    private By payBy = By.id("HOOK_PAYMENT");
    private By paymentModule = By.xpath("//*[@class=\"payment_module\"]");
    private By bankWire = By.id("module-bankwire-payment");
    private By check = By.id("module-cheque-payment");
    private By confirmOrder = By.xpath("//*[text()=\"I confirm my order\"]");
    private By complete = By.xpath("//*[@class=\"alert alert-success\"]");


    public CheckOutPagesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String returnName(int index) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(firstName)).get(index).getText();
    }

    public String returnAddress(int index) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(address)).get(index).getText();
    }

    public String returnCityAndState(int index) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cityAndState)).get(index).getText();
    }

    public String returnCountry(int index) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(country)).get(index).getText();
    }

    public String returnPhone(int index) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(phone)).get(index).getText();
    }

    public void updateAddress(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(update)).click();
    }

    public void saveNewAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newAddress)).click();
    }

    public void proceedToShipping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shipping)).click();
    }

    public void agreeToTerms() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(terms)).click();
    }

    public void proceedToPayment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payment)).click();
    }

    public void choosePaymentMethod(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentModule)).get(index).click();
    }

    public Object checkPaymentMethod() {
        int index = Integer.parseInt(null);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentModule)).get(index).click();
        if (index == 1) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(bankWire));
        } else return wait.until(ExpectedConditions.visibilityOfElementLocated(check));
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrder)).click();
    }

    public String returnResultat() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(complete)).getText();
    }

}
