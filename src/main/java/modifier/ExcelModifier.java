package modifier;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelModifier {
    private static final String SAMPLE_XLSX_FILE_PATH = "./thongtinbaihat.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
     
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

    
        Sheet sheet = workbook.getSheetAt(0);

        
        Row row = sheet.getRow(2);

        Cell cell;
    
        if (row.getCell(9) == null) {
            cell = row.createCell(9);
        } else {
            cell = row.getCell(9);
        }

        cell.setCellType(CellType.STRING);
        cell.setCellValue("Updated Value");

        // Ghi kết quả ra file
        FileOutputStream fileOut = new FileOutputStream("modifier-employee.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }
}
