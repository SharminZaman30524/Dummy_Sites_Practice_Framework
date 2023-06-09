package utility;

import io.netty.util.internal.ObjectCleaner;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelFile {
    private static String path = System.getProperty("user.dir") +
            File.separator + "src" +
            File.separator + "test" +
            File.separator+ "resources" +
            File.separator + "TestData.xlsx";
    //src/test/resources/TestData.xlsx
    //src/test/resources/TestPromptData.xlsx
    public static FileInputStream fis;
    public static XSSFWorkbook xssfWorkbook;
    public static XSSFSheet sheet;

    public static String getValueFromCell(String sheetName, int row, int col) {
        String data = "";
        try {
            fis = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        sheet = xssfWorkbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();// return a string no matter the cell value
        data = dataFormatter.formatCellValue(sheet.getRow(row).getCell(col));//
        return data;
    }

    public static List<Object> getAllColValue(String sheetName, int col) {
        List<Object> data = new ArrayList<>();
        try {
            fis = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        sheet = xssfWorkbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();// return a string no matter the cell value
        int numRow = sheet.getLastRowNum();
        for (int i = 1; i <= numRow; i++) {
            data.add(dataFormatter.formatCellValue(sheet.getRow(i).getCell(col)));
        }
        return data;
    }

    public static List<String> getAllRowValue(String sheetName, int row) {
        List<String> data = new ArrayList<>();
        try {
            fis = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        sheet = xssfWorkbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();// return a string no matter the cell value
        int numCol = sheet.getRow(0).getLastCellNum();
        for (int i = 0; i < numCol; i++) {
            data.add(dataFormatter.formatCellValue(sheet.getRow(row).getCell(i)));
        }
        return data;
    }
    public static String[][] getAllValue(String sheetName){

        try {
            fis = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(fis);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        sheet = xssfWorkbook.getSheet(sheetName);
        DataFormatter dataFormatter = new DataFormatter();// return a string no matter the cell value
        int numRow = sheet.getLastRowNum();
        int numCol = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[numRow][numCol];
        for(int i = 1; i <=numRow; i ++){ //Start at row number 1, in case of header at row 0
            for(int j = 0; j < numCol; j ++){
                data[i-1][j] =  dataFormatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }
        return data;
    }

    public static void main(String[] args) {

        System.out.println(getValueFromCell("OrangeHRMSearches",1,0));
    }

}