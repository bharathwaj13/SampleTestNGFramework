package org.bharath.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bharath.constants.FrameworkConstants;
import org.bharath.exceptions.FrameworkException;
import org.bharath.exceptions.IncorrectExcelFilePathException;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetName) {
        List<Map<String, String>> list = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelPath());) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Map<String, String> map = null;

            int lastRowNum = sheet.getLastRowNum();
            short lastCellNum = sheet.getRow(0).getLastCellNum();
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastCellNum; j++) {
                    String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            //Customising the Stack Trace
            StackTraceElement[] stackTrace = e.getStackTrace();
            stackTrace[0] = new StackTraceElement("org.bharath.utils.ExcelUtils", "getTestDetails", "ExcelUtils.java", 24);
            e.setStackTrace(stackTrace);
            throw new IncorrectExcelFilePathException("Excel file you are trying to read is not found", e);
        } catch (IOException e) {
            throw new FrameworkException("Some IO Exception happened while reading the file");
        }
        return list;
    }
}
