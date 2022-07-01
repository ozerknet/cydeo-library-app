package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    public WebElement searchDropDownMenu;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement seachBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchSubmitButton;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement firstProductAfterSearch;


    @FindBy(xpath = "(//span[@class='a-price-whole'])[1]")
    public WebElement priceOfTheFirstProduct;

    @FindBy(xpath = "(//a[@class='a-size-base a-link-normal s-underline-text s-underline-link-text s-link-style a-text-bold'])[1]")
    public WebElement firstProductType;

    @FindBy (xpath = "(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[1]")
    public WebElement firstProductText;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToBasket;

    @FindBy(xpath = "//a[@class='a-button-text']")
    public WebElement goToBasket;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement productTitle;

    @FindBy(xpath = "//span[contains(text(),'Added to Basket')]")
    public WebElement addedToBasket;

    @FindBy(xpath = "//span[contains(text(),'    In stock.   ')]")
    public WebElement inStockText;

    @FindBy(xpath ="//span[@id='a-autoid-0']")
    public WebElement accepCookies;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    public WebElement totalProductInfoElement;

}
