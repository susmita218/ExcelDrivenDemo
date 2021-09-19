import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public ArrayList<String> getData(String TestcaseName) throws Throwable
	{
		ArrayList<String> a=new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C://Users//Susmita//ExcelDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator(); // sheet is collection of
														// row
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection
															// of cells

				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						// desired column
						column = k;
						}
					k++;
				}
				System.out.println(column);
						// Once column is identified then scan the entire testcase column to identify purchase test case
						while (rows.hasNext()) {
							Row r = rows.next();
							if (r.getCell(column).getStringCellValue().equalsIgnoreCase(TestcaseName)) {
								Iterator<Cell> cv = r.cellIterator();
								while (cv.hasNext()) {
									Cell c=cv.next();
									if(c.getCellTypeEnum()==CellType.STRING)
									{
									a.add(c.getStringCellValue());

								}
									else {
										a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
										
									}
								}
							}
						}
						

					}

					
				

			
		}
		return a;
		
	}

	
}
