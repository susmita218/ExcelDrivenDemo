import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestSample {

	public static void main(String[] args) throws Throwable {
		
		DataDriven d=new DataDriven();
		ArrayList<String> data=d.getData("Add Profile");
		int s=data.size();
		
		for (int i=0; i<s; i++)
		{
		System.out.println(data.get(i));
	
		}
	}

}
