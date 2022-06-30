package com.cydeo.library.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class WriteExcel {
    String filePath = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");
//---------------------------------------------------
        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(20000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(30000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(40000);


        for ( int rowNum=0; rowNum<sheet.getLastRowNum(); rowNum++){

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Gokhan")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Mike");
            }

        }

//-------------------------------------------------------------------------------------
        FileOutputStream outputStream = new FileOutputStream(filePath);

        workbook.write(outputStream);




//------------------------------------------------------------------------------------
        outputStream.close();
        workbook.close();
        fileInputStream.close();



    }
}
