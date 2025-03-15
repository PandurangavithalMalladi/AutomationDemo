package AutomationQA.AutomationDemo.Util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static int getColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) {
            throw new IllegalArgumentException("Header row is empty.");
        }
        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        throw new IllegalArgumentException("Column " + columnName + " does not exist.");
    }

    public static int getRowIndex(Sheet sheet, String rowName) {
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
            if (cell != null && cell.getStringCellValue().equalsIgnoreCase(rowName)) {
                return row.getRowNum();
            }
        }
        throw new IllegalArgumentException("Row " + rowName + " does not exist.");
    }

    public static String getCellValue(String filePath, String sheetName, String rowName, String columnName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
            }

            int rowNum = getRowIndex(sheet, rowName);
            int colNum = getColumnIndex(sheet, columnName);

            Row targetRow = sheet.getRow(rowNum);
            Cell targetCell = targetRow.getCell(colNum);

            if (targetCell == null) {
                throw new IllegalArgumentException("Cell at row " + rowName + " and column " + columnName + " does not exist.");
            }

            return targetCell.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String filePath = "src/main/Resources/sample_data.xlsx"; // Ensure this path is correct
        String sheetName = "Sheet1";
        String rowName = "David";
        String columnName = "Salary";

        String cellValue = getCellValue(filePath, sheetName, rowName, columnName);
        System.out.println("The cell value is: " + cellValue);
    }
}
