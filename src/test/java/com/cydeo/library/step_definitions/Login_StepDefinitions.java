package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LibraryDashBoard;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.List;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    LibraryDashBoard libraryDashBoard = new LibraryDashBoard();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library1_url"));
    }

    @Given("user is on the login page library{int}.env")
    public void userIsOnTheLoginPageLibraryEnv(int arg0) {
        Driver.getDriver().get(ConfigurationReader.getProperty("library2_url"));
    }

    @When("user enters librarian username and password")
    public void userEntersLibrarianUsernameAndPassword() {
        loginPage.login(ConfigurationReader.getProperty("librarian_username"), ConfigurationReader.getProperty("librarian_pwd"));

    }

    @Then("user should see the dashboard")
    public void userShouldSeeTheDashboard() {
        Assert.assertTrue(loginPage.libraryLogoInMainPage.isDisplayed());
    }


    @When("user enters student username and pasword")
    public void userEntersStudentUsernameAndPasword() {
        loginPage.login(ConfigurationReader.getProperty("student1_username"), ConfigurationReader.getProperty("student1_pwd"));

    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String name) {
        wait.until(ExpectedConditions.visibilityOf(libraryDashBoard.userNameItem));
        String actualHolderName = libraryDashBoard.userNameItem.getText();
        Assert.assertEquals(name, actualHolderName);
    }


    @And("I click on users link")
    public void iClickOnUsersLink() {
        libraryDashBoard.usersLink.click();
    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> namesOfTheColumns) {
        List<WebElement> columnNames = libraryDashBoard.allColumns;  // webelemnts of columns found and put in List

        List<String> actualNamesOfTheColumn = new ArrayList<>();  // creat a empty arrayList to put the name of the columns

        for (WebElement each : columnNames) {
            actualNamesOfTheColumn.add(each.getText());  // all names of them are added
        }

        Assert.assertEquals(namesOfTheColumns, actualNamesOfTheColumn);   //  compared here

    }


}
