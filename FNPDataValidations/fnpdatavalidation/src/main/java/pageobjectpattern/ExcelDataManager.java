package pageobjectpattern;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelDataManager {
    private static final String FILE_PATH = "C:\\Users\\Admin\\Downloads\\Book4.xlsx";

    public static Object[][] provideTestData() throws IOException {
        FileInputStream file = new FileInputStream(FILE_PATH);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] testData = new Object[rowCount][columnCount];
        for (int i = 1; i <= rowCount; i++) { // Starting from 1 to skip header row
            Row row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            testData[i - 1][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            testData[i - 1][j] = cell.getNumericCellValue();
                            break;
                        case BOOLEAN:
                            testData[i - 1][j] = cell.getBooleanCellValue();
                            break;
                        default:
                            testData[i - 1][j] = null;
                    }
                } else {
                    testData[i - 1][j] = null;
                }
            }
        }
        workbook.close();
        file.close();
        return testData;
    }
}
