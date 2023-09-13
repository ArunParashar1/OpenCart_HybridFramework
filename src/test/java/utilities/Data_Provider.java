package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	
	@DataProvider(name = "loginData")
	public String[][] getdata() throws IOException
	{
		String path = ".\\testdata\\Opencart_LoginData.xlsx";
		
		ExcelUtility exlutil = new ExcelUtility(path);
		int rowcount = exlutil.getRowCount("Sheet1");
		int cellcount = exlutil.getCellCount("Sheet1", 1);
		
		String [][] logindata = new String[rowcount][cellcount];
		
		for(int i = 1; i<=rowcount; i++)
		{
			for(int j = 0 ; j<cellcount; j++)
			{
				logindata[i-1][j] = exlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return logindata;
	}

}
