package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement inputEmail;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement inputPassword;

    @FindBy (xpath = "(//img[contains(text(),'')])[1]")
    public WebElement libraryLogoInMainPage;

    @FindBy(xpath = "//span[contains(text(),'Test')]")
    public WebElement userNameArea;




    public void login(String email, String pass){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(pass , Keys.ENTER);
    }

}
