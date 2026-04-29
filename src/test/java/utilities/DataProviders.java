package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")  //This name should be different from one dataprovider to another dp
	public String[][] getData() throws IOException 
	{
	    String path = ".\\testData\\Opencart_LoginData.xlsx";  // taking xl file from testData
	    
	    ExcelUtility xlutil = new ExcelUtility(path);   // creating an object for XLUtility
	    
	    int totalrows = xlutil.getRowCount("Sheet1");
	    int totalcols = xlutil.getCellCount("Sheet1", 1);
	    
	    String logindata[][] = new String[totalrows][totalcols];  //created for two dimension array
	    
	    for(int i=1; i<=totalrows; i++) //1  //read the data from xl storing in two dimensional array
	    {
	        for(int j=0; j<totalcols; j++) // i is rows, j is col
	        {
	            logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
	        }
	    }
	    
	    return logindata; // returning two dimension array
	}
	
	//DataProvider 2
	
	//In future you can add dataproviders i this
	
	//DataProvider 3 
	
	
	//DataProvider 4
	
}
