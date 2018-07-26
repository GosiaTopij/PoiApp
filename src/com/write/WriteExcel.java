package com.write;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	private static String FILE_NAME = "C:\\Users\\Topij Ma³gorzata\\xlsx\\test.xlsx";

	public static void main(String[] args) throws FileNotFoundException {

		try {
			Lista lista = new Lista();
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Dane");

			Row rowHeading = sheet.createRow(0);
			rowHeading.createCell(0).setCellValue("ID");
			rowHeading.createCell(1).setCellValue("NAME");
			rowHeading.createCell(2).setCellValue("PRICE");

			for (int i = 0; i < 3; i++) {
				CellStyle stylerowHeading = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setBold(true);
				font.setFontName(HSSFFont.FONT_ARIAL);
				font.setFontHeightInPoints((short) 11);
				stylerowHeading.setFont(font);
				rowHeading.getCell(i).setCellStyle(stylerowHeading);
			}

			int r = 1;
			for (TestModel t : lista.findAll()) {
				Row row = sheet.createRow(r);
				Cell cell1 = row.createCell(0);
				cell1.setCellValue(t.getKol1());
				Cell cell2 = row.createCell(1);
				cell2.setCellValue(t.getKol2());
				Cell cell3 = row.createCell(2);
				cell3.setCellValue(t.getKol3());
				Cell cell4 = row.createCell(3);
				cell4.setCellValue(t.getKol4());
				r++;
			}

			for (int i = 0; i < 9; i++)
				sheet.autoSizeColumn(i);

			FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();
			System.out.print("excel written successfully");

		} catch (Exception e) {
			System.out.print("Something is Wrong");
		}
//		zapis();		
	}

	public static void zapis() throws FileNotFoundException {
		PrintWriter zapis = new PrintWriter("C:\\\\Users\\\\Topij Ma³gorzata\\\\xlsx\\\\test_a1.txt");
		Lista lista = new Lista();
		for (TestModel t : lista.findAll()) {
			zapis.println(t);
		}
		zapis.close();
	}
}