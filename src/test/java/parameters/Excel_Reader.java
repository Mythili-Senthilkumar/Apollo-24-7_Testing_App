package parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public static String[][] readData()
	{
		String[][] data=null;
		String fileName="src\\test\\resources\\exceldata\\inputdata.xlsx";
		try {
			FileInputStream fis=new FileInputStream(fileName);
			   try (XSSFWorkbook workBook = new XSSFWorkbook(fis)) {
				XSSFSheet sheet=workBook.getSheet("Sheet1");
				
				
				int rowCount=sheet.getLastRowNum();
				
				int cellCount=sheet.getRow(0).getLastCellNum();
				
				DataFormatter df=new DataFormatter();
				
				XSSFCell cell;
				
				data=new String[rowCount][cellCount];
				
				for(int rowNo=1;rowNo<=rowCount;rowNo++)
				{
					for(int cellNo=0;cellNo<cellCount;cellNo++)
					{
						cell=sheet.getRow(rowNo).getCell(cellNo);
						data[rowNo-1][cellNo]=df.formatCellValue(cell);
					}
				}
			}
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
}
