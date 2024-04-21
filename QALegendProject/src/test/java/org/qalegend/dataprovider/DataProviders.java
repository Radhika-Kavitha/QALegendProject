package org.qalegend.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="InvalidUserCredentials")
	public Object userCredentialsData()
	{
		Object data[][]	= new String [3][2];
		
		data[0][0]="admin";
		data[0][1]="8765";
		
		data[1][0]="adminhy";
		data[1][1]="123456";
		
		data[2][0]="efghjb";
		data[2][1]="34567";
		
		return data;
	}
}
