package com.cydeo.library.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";

        File file =new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);


        //workbook>sheet>row>cell

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet =workbook.getSheet("Employees");

        System.out.println(sheet.getRow(1).getCell(0));
        System.out.println(sheet.getRow(2).getCell(2));


        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        for ( int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Ozer")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }

        }

        for ( int rowNum=0; rowNum<usedRows; rowNum++) {

                if(sheet.getRow(rowNum).getCell(0).toString().equals("Gokhan")){
                    System.out.println("Gokhan mobile number : "+ sheet.getRow(rowNum).getCell(2));
                }
        }




    }


}
