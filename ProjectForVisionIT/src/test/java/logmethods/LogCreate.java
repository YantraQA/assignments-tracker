package logmethods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class LogCreate 
{
	public static void function_Write_Logs_(String s_message)
	{
		BufferedWriter  bw = null;
		FileWriter fw = null;
		try
		{
			Date obj = new Date();
			//fw = new FileWriter(System.getProperty("User.dir")+"\\log.log",true);
			fw = new FileWriter("D:\\log_files\\Automationlog.log",true);
			bw = new BufferedWriter(fw);
			bw.write(obj.toString() +"|" + Thread.currentThread().getStackTrace()[2].getMethodName() + "|" + s_message);
			bw.newLine();
			System.out.println(obj.toString() + "|" + Thread.currentThread().getStackTrace()[2].getMethodName() + "|" + s_message);
		}
		catch(IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
				}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	public static String func_Genrate_Log_File_Name()
	{
		String  result;
		String y,mon,d,h,min,s,mil;
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		int millis = now.get(Calendar.MILLISECOND);
		y = Integer.toString(year);
		mon = Integer.toString(month);
		d= Integer.toString(day);
		h = Integer.toString(hour);
		min = Integer.toString(minute);
		s= Integer.toString(second);
		mil = Integer.toString(millis);
		result = y+mon+d+h+min+s;
		return result;
	}
	public static void main(String[] args) 
	{
		//LogCreate lg = new LogCreate();
		//String file_name=func_Genrate_Log_File_Name();
		//System.out.println(file_name);
		function_Write_Logs_("write a loge forn method");
	}
}
		
	
	
	/*public static void fun_Read_Config()
	{
		String s_config_file_path;
		XSSFSheet sourcesheet_user_details;
		s_config_file_path = Global.PATH_CONFIG_FILE_PATH;
		XSSFWorkbook srcBook;
		XSSFSheet sourceSheet;
		 try
		 {
			 srcBook = new XSSFWorkbook(s_config_file_path);
			 sourceSheet = srcBook.getSheetAt(0);
			 int rowcounter = sourceSheet.getLastRowNum();
			 int clmcounter = sourceSheet.getRow(0).getLastCellNum();
			 for(int i=1; i<=rowcounter;i++)
			 {
				 Global.CONFIG_DATA.put(sourceSheet.getRow(i).getCell(0).toString().trim(),
						 sourceSheet.getRow(i).getCell(1).trim());
			 }
			 sourcesheet_user_details = srcBook.getSheet("TEST_USERS");
			 rowcounter = sourcesheet_user_details.getLastRowNum();
			 clmcounter = sourceSheet.getRow(0).getLastCellNum();
			 String temp = "";
			 for(int i=1;i<=rowcounter;i++)
			 {
				 for (int j=1;j<clmcounter;j++)
				 {
					 if(temp.equals(""))
					 {
						 temp = sourcesheet_user_details.getRow(i).gwtCell(j).toString().trim();
					 }
					 else
					 {
						 if(j==2)
							 temp = temp + "~" + EncryptDecrypt.f_decrypt_text(sourcesheet_user_details.getRow(i).getCell(j).toString().trim());
						 else
							 temp = temp + "~" + EncryptDecrypt.f_decrypt_text(sourcesheet_user_details.getRow(i).getCell(j).toString().trim());
						 }
				 }
				 Global.CONFIG_DATA.put(sourcesheet_user_details.getRow(i).getCell(0).toString().trim(),temp);
				 temp = "";
			 }
			 catch(IOException e1)
			 {
				 LogCreate.func_Genrate_Log_File_Name ("fail_no_ss","Unable to read Config file: " + e1.getMessage());
			 }
			 catch(Exception e2)
			 {
				 LogCreate.func_Genrate_Log_File_Name ("fail_no_ss","Error Exception in Read Config file function: " + LogCreate.f_err_string(e2));
			 }
			 	srcBook = null;
				sourceSheet=null;
			 
}*/
