package seleniumbasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReadWrite {
	@Test
	public void ExcelReadWrite() throws IOException {

		File f= new File(System.getProperty("user.dir")+"\\"+"ReadWrite.xlsx");

		FileInputStream rf=new FileInputStream(f);

		Workbook ws=new XSSFWorkbook(rf);
		Sheet sh=ws.getSheet("First");

		int totalRows=sh.getLastRowNum()-sh.getFirstRowNum();

		for(int i=0;i<=totalRows;i++) {

			Row r=sh.getRow(i);

			for(int j=0;j<r.getLastCellNum();j++) {



				if(!(r.getCell(j).toString().equals(null))) {

					if (r.getCell(j).toString().equalsIgnoreCase("SS")) {
						Cell cell = r.createCell(j);
						
						cell.setCellValue((String)"simbu");
						break;

					}
				}





			}
		}
		FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir")+"\\"+"ReadWrite.xlsx");
		ws.write(fos);
		fos.close();
		
		
		String str="@12abcXYZ(245uIiucba$56= sdfd";
		String exceptAlpha=str.replaceAll("(?i)[A-Z]", "").replaceAll("[0-9]", "");
		//(?i)-For Case Sensitivity
		System.out.println("Except Alphabets: "+exceptAlpha);
		String alphaStr=str.replaceAll("(?i)[^a-z]", "");
		System.out.println("Alphabets alone: "+alphaStr);
		String numStr=str.replaceAll("[^0-9]", "");
		System.out.println("numbers alone: "+numStr);
		
		String replaceI=str.replaceAll("(?i)i", "E");
		System.out.println("i to E replace: "+replaceI);
	}
}
