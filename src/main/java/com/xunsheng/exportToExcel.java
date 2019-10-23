package com.xunsheng;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class exportToExcel {

    private static final String[] columns = {"No.", "Matric", "Name", "Link"};


    public void exportExcel(ArrayList<Data>submit, ArrayList<Data>notSubmit,ArrayList<Data>unknown) throws IOException, InterruptedException {

        // Create a Workbook.
        Workbook workbook = new XSSFWorkbook();

        /* CreationHelper helps us create instances of various things like DataFormat,
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create Submitted Sheet.
        Sheet sheet1 = workbook.createSheet("Submitted");

        // Create a Font for styling header cells.
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font.
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);


        //set border style for header cells.
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);

        //set text to center.
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border.
        CellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);

        //Create row.
        Row headerRow = sheet1.createRow(0);

        // Create cells.
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);

        }

        // Print data to row.
        int rowNum = 1;
        for (Data submitTable : submit) {
            Row row = sheet1.createRow(rowNum++);


            Cell column1 = row.createCell(0);
            column1.setCellValue(submitTable.getNum());
            column1.setCellStyle(cellStyle);

            Cell column2 = row.createCell(1);
            column2.setCellValue(submitTable.getMatric());
            column2.setCellStyle(cellStyle);

            Cell column3 = row.createCell(2);
            column3.setCellValue(submitTable.getName());
            column3.setCellStyle(cellStyle);

            Cell column4 = row.createCell(3);
            column4.setCellValue(submitTable.getLink());
            column4.setCellStyle(cellStyle);

        }

        // Resize all columns to fit the content size.
        for (int i = 0; i < columns.length; i++) {
            sheet1.autoSizeColumn(i);
        }


        // Create Not Submitted Sheet.
        Sheet sheet2 = workbook.createSheet("Not Submitted");

        // Create a Font for styling header cells.
        Font headerFont2 = workbook.createFont();
        headerFont2.setBold(true);
        headerFont2.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font.
        CellStyle headerCellStyle2 = workbook.createCellStyle();
        headerCellStyle2.setFont(headerFont);


        //set border style for header cells.
        headerCellStyle2.setBorderRight(BorderStyle.THIN);
        headerCellStyle2.setBorderBottom(BorderStyle.THIN);

        //set text to center.
        headerCellStyle2.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border.
        CellStyle cellStyle2 = workbook.createCellStyle();

        cellStyle2.setBorderRight(BorderStyle.THIN);
        cellStyle2.setBorderLeft(BorderStyle.THIN);
        cellStyle2.setBorderTop(BorderStyle.THIN);
        cellStyle2.setBorderBottom(BorderStyle.THIN);

        //Create row.
        Row headerRow2 = sheet2.createRow(0);

        // Create cells.
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow2.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle2);

        }

        // Print data to row.
        int rowNum2 = 1;
        for (Data notSubmitTable : notSubmit) {
            Row row = sheet2.createRow(rowNum2++);


            Cell column1 = row.createCell(0);
            column1.setCellValue(notSubmitTable.getNum());
            column1.setCellStyle(cellStyle2);

            Cell column2 = row.createCell(1);
            column2.setCellValue(notSubmitTable.getMatric());
            column2.setCellStyle(cellStyle2);

            Cell column3 = row.createCell(2);
            column3.setCellValue(notSubmitTable.getName());
            column3.setCellStyle(cellStyle2);

            Cell column4 = row.createCell(3);
            column4.setCellValue(notSubmitTable.getLink());
            column4.setCellStyle(cellStyle2);

        }

        // Resize all columns to fit the content size.
        for (int i = 0; i < columns.length; i++) {
            sheet2.autoSizeColumn(i);
        }


        // Create Unknown Sheet.
        Sheet sheet3 = workbook.createSheet("Unknown List");

        // Create a Font for styling header cells.
        Font headerFont3 = workbook.createFont();
        headerFont3.setBold(true);
        headerFont3.setFontHeightInPoints((short) 16);


        // Create a CellStyle with the font.
        CellStyle headerCellStyle3 = workbook.createCellStyle();
        headerCellStyle3.setFont(headerFont);


        //set border style for header cells.
        headerCellStyle3.setBorderRight(BorderStyle.THIN);
        headerCellStyle3.setBorderBottom(BorderStyle.THIN);

        //set text to center.
        headerCellStyle3.setAlignment(HorizontalAlignment.CENTER);


        //create a  CellStyle with border.
        CellStyle cellStyle3 = workbook.createCellStyle();

        cellStyle3.setBorderRight(BorderStyle.THIN);
        cellStyle3.setBorderLeft(BorderStyle.THIN);
        cellStyle3.setBorderTop(BorderStyle.THIN);
        cellStyle3.setBorderBottom(BorderStyle.THIN);

        //Create row.
        Row headerRow3 = sheet3.createRow(0);

        // Create cells.
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow3.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle3);

        }

        // Print data to row.
        int rowNum3 = 1;
        for (Data unknownTable : unknown) {
            Row row = sheet3.createRow(rowNum3++);


            Cell column1 = row.createCell(0);
            column1.setCellValue(unknownTable.getNum());
            column1.setCellStyle(cellStyle3);

            Cell column2 = row.createCell(1);
            column2.setCellValue(unknownTable.getMatric());
            column2.setCellStyle(cellStyle3);

            Cell column3 = row.createCell(2);
            column3.setCellValue(unknownTable.getName());
            column3.setCellStyle(cellStyle3);

            Cell column4 = row.createCell(3);
            column4.setCellValue(unknownTable.getLink());
            column4.setCellStyle(cellStyle3);

        }

        // Resize all columns to fit the content size.
        for (int i = 0; i < columns.length; i++) {
            sheet3.autoSizeColumn(i);
        }

        // Write the output to a file.
        FileOutputStream fileOut = new FileOutputStream("Report.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        //Message for processing excel file.
        System.out.println("\n\n\n"+"Generating an Excel file for the report..");
        Thread.sleep(2000);
        System.out.println("An Excel file named 'Report' has been created in directory D.");

    }



}

