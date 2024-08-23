package seleniumbasic;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorksheetDocument;

public class ReadExcelFile {
	
	static String[][] dataArray=new String[3][3];
	
	public static Object[][] readExcel(String fileName,String sheetName)throws IOException{
		
		File file=new File(System.getProperty("user.dir")+"\\"+fileName);
		
		FileInputStream fi=new FileInputStream(file);
		
		Workbook ws=new XSSFWorkbook(fi);
		Sheet sh=ws.getSheet(sheetName);
		
		int totalRows=sh.getLastRowNum()-sh.getFirstRowNum();
		
		for(int i=0;i<=totalRows;i++) {
			
			Row r=sh.getRow(i);
			
			for(int j=0;j<r.getLastCellNum();j++) {
				
			int colCount=r.getLastCellNum();
			if(!(r.getCell(i).toString().equals(null))) {
				
				dataArray[i][j]=r.getCell(j).toString();
			}
			else {
				dataArray[i][j]="";
			}
			}
		}
		
		return dataArray;
		
	}
	

}
