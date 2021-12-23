package mk.sedc.tests;

import mk.sedc.utiles.data.RegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkFlowTest extends BaseTest {


    @Test
    public void addProductsInCart() {
        homePage.openWomen();
        productsPage.expandTops();
        productsPage.expandDresses();
        scroll(800);
        // categoryPage.sortProductsBy(2);
        productsPage.moreForProduct(2);
        scroll(250);
        productsPage.chooseSize(2);
        productsPage.seeColors();
        productsPage.viewLarger();
        productsPage.nextPucture();
        productsPage.nextPucture();
        productsPage.closePucture();
        productsPage.addQuantity();
        productsPage.addToCart();
        productsPage.continueShopping();
        scroll(-250);
        productsPage.navigateToDresses();
        scroll(500);
        productsPage.chooseDressCategory(2);
        scroll(1000);
        productsPage.moreForProduct(3);
        productsPage.addToCartDirectly();
        productsPage.continueShopping();
        scroll(-1000);
        homePage.setSearchSomething("blouse");
        homePage.clickSearch();
        scroll(500);
        productsPage.moreForProduct(1);
        productsPage.openMore();
        scroll(500);
        productsPage.chooseSize(1);
        productsPage.viewLarger();
        productsPage.closePucture();
        productsPage.addToCart();
        productsPage.proceedToCheckOut();
    }

    @Test(dependsOnMethods = {"addProductsInCart"})
    public void arrangeCart() {
        scroll(400);
        shoppingCartPage.subtractItem(1);
        shoppingCartPage.deleteItem(2);
        shoppingCartPage.proceedToCheckOut();
    }

    @Test(dependsOnMethods = {"arrangeCart"})
    public void register() {
        scroll(500);
        registrationPage.writeEmail(RegistrationData.email);
        registrationPage.nextStep();
        registrationPage.chooseGender(1);
        registrationPage.typeFirstName(RegistrationData.firstName);
        registrationPage.typeLastName(RegistrationData.lastName);
        registrationPage.typePassword(RegistrationData.password);
        scroll(500);
        registrationPage.chooseDay(RegistrationData.dayOfBirth);
        registrationPage.chooseMonth(RegistrationData.monthOfBirth);
        registrationPage.chooseYear(String.valueOf(RegistrationData.yearOfBirth));
        registrationPage.specialOffers();
        registrationPage.typeAddress(RegistrationData.address);
        registrationPage.typeCity(RegistrationData.city);
        scroll(300);
        registrationPage.chooseState(RegistrationData.state);
        registrationPage.typePostalCode(String.valueOf(RegistrationData.zipCode));
        registrationPage.typePhoneNumber(String.valueOf(RegistrationData.number));
        registrationPage.clearAliasAddress();
        registrationPage.typeAliasAddress(RegistrationData.address);
        registrationPage.register();
    }

    @Test(dependsOnMethods = {"register"})
    public void checkOut() {
        scroll(650);
        String name = RegistrationData.firstName + " " + RegistrationData.lastName;
        Assert.assertEquals(checkOutPagesPage.returnName(1), name);
        Assert.assertEquals(checkOutPagesPage.returnAddress(1), RegistrationData.address);
        String cityAndState = RegistrationData.city + ", " + RegistrationData.state + " " + RegistrationData.zipCode;
        Assert.assertEquals(checkOutPagesPage.returnCityAndState(1), cityAndState);
        Assert.assertEquals(checkOutPagesPage.returnCountry(1), "United States");
        checkOutPagesPage.updateAddress(1);
        scroll(250);
        registrationPage.clearAddress();
        registrationPage.typeAddress("Nevena Georgiefva Dunja 4");
        checkOutPagesPage.saveNewAddress();
        scroll(500);
        checkOutPagesPage.proceedToShipping();
        scroll(500);
        checkOutPagesPage.agreeToTerms();
        checkOutPagesPage.proceedToPayment();
        scroll(500);
        checkOutPagesPage.choosePaymentMethod(1);
        scroll(500);
        checkOutPagesPage.confirmOrder();
        Assert.assertEquals(checkOutPagesPage.returnResultat(), "Your order on My Store is complete.");
    }
}
