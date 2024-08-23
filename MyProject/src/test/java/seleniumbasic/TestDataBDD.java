package seleniumbasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import io.cucumber.messages.internal.com.google.common.collect.Maps;

public class TestDataBDD {
	
static String[][] dataArray=new String[3][3];

@DataProvider(name="my-custom-dp")
public static Object[][] dataProviderForBDD(){

    Map<Object, Object> m = Maps.newHashMap();
    m.put("username", "mercury");
    m.put("password", "mercury");

    Map<Object, Object> m1 = Maps.newHashMap();
    m.put("username", "mercury");
    m.put("password", "mercury");

    return new Object[][]{ {m},{m1}};
}

//	@DataProvider(name="my-custom-dp")
//	public static Object[][] readExcel(String fileName,String sheetName)throws IOException{
//		
//		File file=new File(System.getProperty("user.dir")+"\\"+fileName);
//		
//		FileInputStream fi=new FileInputStream(file);
//		
//		Workbook ws=new XSSFWorkbook(fi);
//		Sheet sh=ws.getSheet(sheetName);
//		
//		int totalRows=sh.getLastRowNum()-sh.getFirstRowNum();
//		
//		for(int i=0;i<=totalRows;i++) {
//			
//			Row r=sh.getRow(i);
//			
//			for(int j=0;j<r.getLastCellNum();j++) {
//				
//			if(!(r.getCell(i).toString().equals(null))) {
//				
//				dataArray[i][j]=r.getCell(j).toString();
//			}
//			else {
//				dataArray[i][j]="";
//			}
//			}
//		}
//		
//		return dataArray;
		
//	}
	


}
