package reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {
    private static final String SAMPLE_XLSX_FILE_PATH = "./thongtinbaihat.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Tạo Workbook từ tệp Excel (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

        // 1. Lấy một sheetIterator và lặp lại
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Truy xuất Sheets bằng cách sử dụng Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        // 2. Sử dụng vòng lặp for-each
        System.out.println("Sử dụng vòng lặp for-each");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }

        // 3. sử dụng Java 8 forEach với lambda
        System.out.println("Truy xuất Sheet bằng Java 8 forEach với lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });

        // Lấy Trang tính ở chỉ số 0
        Sheet sheet = workbook.getSheetAt(0);

        // Em chào thầy ạ!
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();

        // Tạo DataFormatter để định dạng
        DataFormatter dataFormatter = new DataFormatter();

        // 1. Lấy một rowIterator và columnIterator rồi lặp lại.
        System.out.println("\n\nLặp lại các  Rows VÀ Columns bằng cách sử dụng Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Lặp lại các cột của hàng
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                System.out.print(getCellValue(cell,evaluator) + "\t");
            }
            System.out.println();
        }

        System.out.println("\n\nLặp lại hàng và cột, sử dụng vòng lặp for-each\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
            	
                System.out.print(getCellValue(cell,evaluator) + "\t");
            }
            System.out.println();
        }

        
        System.out.println("\n\nLặp lại Hàng và Cột, sử dụng Java 8 forEach với lambda\n");
        sheet.forEach(row -> {
            row.forEach(cell -> {
            	
                System.out.print(getCellValue(cell,evaluator) + "\t");
            });
            System.out.println();
        });

        workbook.close();
    }

    private static Object getCellValue(Cell cell, FormulaEvaluator evaluator) {
        CellValue cellValue = evaluator.evaluate(cell);
        switch (cellValue.getCellTypeEnum()) {
            case BOOLEAN:
                return cellValue.getBooleanValue();
            case NUMERIC:
                return cellValue.getNumberValue();
            case STRING:
                return cellValue.getStringValue();
            case BLANK:
                return "";
            case ERROR:
                return cellValue.getError(cell.getErrorCellValue()).getStringValue();
       
            case FORMULA:
            default:
                return null;
        }
    }
}
