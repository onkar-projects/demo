package GoogleNavigation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataFech {

	public static void main(String[] args) throws IOException {
		FileInputStream fi;
		FileOutputStream fo;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		XSSFRow row;
		XSSFCell cell;
		CellStyle style;

		String path = System.getProperty("user.dir") + "\\TestData\\HomeLyfDataSheet.xlsx";

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet("Sheet1");
		row = sheet.getRow(0);
		int col_num = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().equals("password")) {
				col_num = i;
				row = sheet.getRow(i);
			}
		}
		cell = row.getCell(col_num);
		String value = cell.getStringCellValue();
		System.out.println("Value of the Excel Cell is - "+ value);
	}
}
