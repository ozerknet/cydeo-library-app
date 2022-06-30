package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.AmazonPage;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Amazon_StepDefinitions {
    AmazonPage amazonPage = new AmazonPage();

    @When("Amazona gir")
    public void amazona_gir() {
        Driver.getDriver().get("https://www.amazon.co.uk/");
    }

    @When("Kategori olarak book sec")
    public void kategori_olarak_book_sec() {
        /*
        List<WebElement> dropDownMenu = amazonPage.searchDropDownMenu;  // webelemnts of columns found and put in List
        List<String> dropDownMenuString = new ArrayList<>();  // creat a empty arrayList to put the name of the columns
        for (WebElement each : dropDownMenu) {
            dropDownMenuString.add(each.getText());// all names of them are added
        }
        System.out.println("dropDownMenuString = " + dropDownMenuString);
        */

        Select simpleDropdown = new Select(amazonPage.searchDropDownMenu);
        System.out.println("simpleDropdown = " + simpleDropdown);
        List<WebElement> menu = simpleDropdown.getOptions();
        for (WebElement deparment : menu) {
            if (deparment.getText().contains("Book")) {
                deparment.click();
            }
        }


    }

    @And("Search kismina harry potter yaz")
    public void searchKisminaHarryPotterYaz() {
        amazonPage.seachBox.sendKeys("harry potter");
    }

    @And("Search butonuna bas")
    public void searchButonunaBas() {
        amazonPage.searchSubmitButton.click();
    }

    @And("Cikan sonucta ilk elemanin harry potter ismini icerdigini dogrula")
    public void cikanSonuctaIlkElemaninHarryPotterIsminiIcerdiginiDogrula() {
        Assert.assertTrue(amazonPage.firstProductAfterSearch.getText().contains("Harry Potter"));
    }

    @And("Fiyatin {string} oldugunu dogrula")
    public void fiyatinOldugunuDogrula(String price) {
        Assert.assertTrue(amazonPage.priceOfTheFirstProduct.getText().equals(price));

    }

    @And("Turun paperback oldugunu dogrula")
    public void turunPaperbackOldugunuDogrula() {
        Assert.assertTrue(amazonPage.firstProductType.getText().equals("Paperback"));
    }


    @And("Add to basket yap")
    public void addToBasketYap() {
        amazonPage.firstProductText.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-cart-button']")));



        amazonPage.addToBasket.click();

        amazonPage.goToBasket.click();
    }
}
