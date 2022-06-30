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

    @FindBy (xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
    public WebElement firstProductText;

    @FindBy(xpath = "(//input[@title='Add to Shopping Basket'])[1]")
    public WebElement addToBasket;

    @FindBy(xpath = "//a[@class='a-button-text']")
    public WebElement goToBasket;
}
