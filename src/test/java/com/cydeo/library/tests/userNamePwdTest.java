package com.cydeo.library.tests;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class userNamePwdTest {
    LoginPage loginPage = new LoginPage();

    @Test
    public void userNameTest() throws IOException {
        String filepath = "ExcelData.xlsx";
        FileInputStream in = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("Data");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String firstName = sheet.getRow(i).getCell(2).toString();
//            String lastName = sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName, password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 4);
            wait.until(ExpectedConditions.visibilityOf(loginPage.bookManagement));

            XSSFCell resultCell = sheet.getRow(i).getCell(3);

            String actualUserName = loginPage.actualUserName.getText();
            System.out.println(actualUserName);

            if (actualUserName.contains(firstName)) {
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            } else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");

            }
            loginPage.actualUserName.click();
            loginPage.logOut.click();

        }
        FileOutputStream out= new FileOutputStream(filepath);
        workbook.write(out);
        in.close();
        out.close();
        workbook.close();

    }
}
