package seleniumbasic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigProp {
	
	static Properties prop;
	public static String output;
	
	public static String readProperties(String input) throws FileNotFoundException {
		
		File file=new File(System.getProperty("user.dir")+"\\"+"config.properties");	
		FileInputStream fInputStream;
		try {
			fInputStream = new FileInputStream(file);
		
		
		prop=new Properties();
		
		try {
			prop.load(fInputStream);
			output=prop.getProperty(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return output;
		
		
	}
	
public static String readPropertiesExtend() throws FileNotFoundException {
	
	
		File file=new File(System.getProperty("user.dir")+"\\"+"config.properties");	
		FileInputStream fInputStream;
		try {
			fInputStream = new FileInputStream(file);
		
		
		prop=new Properties();
		
		try {
			prop.load(fInputStream);
			output=prop.getProperty("reportConfigPath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return output;
		
		
	}


}
