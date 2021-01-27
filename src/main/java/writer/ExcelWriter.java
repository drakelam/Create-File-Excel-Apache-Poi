package writer;

import model.Thongtinbaihat;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ExcelWriter {
    private static String[] columns = {"Tên ca sĩ", "tên bài hát", "Ngay Sinh", "BXH", "Đánh giá", "Total Salary"};
    private static List<Thongtinbaihat> thongtinbaihat = new ArrayList<>();

    static {
        Calendar NgaySinh = Calendar.getInstance();
        NgaySinh.set(2001, 0, 26); 
        thongtinbaihat.add(new Thongtinbaihat("Lâm Định", "ok", NgaySinh.getTime(), 22d, 100d));
        NgaySinh.set(2001, 2, 15);
        thongtinbaihat.add(new Thongtinbaihat("Mạnh hùng", "ok", NgaySinh.getTime(), 21d, 120d));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        
        Workbook workbook = new XSSFWorkbook(); 

        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Thongtinbaihat");

        // Tạo Style cho file excel
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        int rowNum = 1;
        for (Thongtinbaihat thongtinbaihat : thongtinbaihat) {
            Row row = sheet.createRow(rowNum++);

            // Name of the song (Column A)
            row.createCell(0)
                    .setCellValue(thongtinbaihat.getName());

            // (Column B)
            row.createCell(1)
                    .setCellValue(thongtinbaihat.getSong());

            //(Column C)
            Cell dateOfBirth = row.createCell(2);
            dateOfBirth.setCellValue(thongtinbaihat.getNgaySinh());
            dateOfBirth.setCellStyle(dateCellStyle);

            //(Column D)
            row.createCell(3, CellType.NUMERIC)
                    .setCellValue(thongtinbaihat.getBXH());

            // (Column E)
            row.createCell(4, CellType.NUMERIC)
                    .setCellValue(thongtinbaihat.getDanhGia());

            //  (Column F = D * E)
            String formula = "D" + rowNum + " * E" + rowNum;
            row.createCell(5, CellType.FORMULA)
                    .setCellFormula(formula);
        }

        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("thongtinbaihat.xlsx");
        workbook.write(fileOut);
        fileOut.close();

       // Đóng workbook
        workbook.close();
    }
}
