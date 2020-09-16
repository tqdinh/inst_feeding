package Facebook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
//	String excelFilePath = "Facebook/DataAutoFB.xlsx";	
//	String sheetFB = "FB";	
	
	public List<String> listUsernameFB = new ArrayList<String>();
	public List<String> listPasswordFB = new ArrayList<String>();
	public List<String> listDeviceUIID = new ArrayList<String>();

	Workbook wb;

	public ExcelManager(String pathToExcelFile, String sheetName) {
		try {
			String userPath = System.getProperty("user.dir");
			File excelFile = new File(userPath + "/" + pathToExcelFile);
			wb = new XSSFWorkbook(excelFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readDataFromExcel(sheetName);
	}
	
	// ****************************************************
	// order begins from 1	
	public String getUsernameFB(int order) {
		return listUsernameFB.get(order);
	}

	public String getPasswordFB(int order) {
		return listPasswordFB.get(order);
	}

	public String getDeviceUIID(int order) {
		return listDeviceUIID.get(order);
	}
	
	
	// ****************************************************
	public void readDataFromExcel(String sheetName) {
		clearOldDataOfList();
		for (Sheet sheet : wb) {
			if (sheet.getSheetName().equalsIgnoreCase(sheetName)) {
				for (int i = 1; i <= sheet.getLastRowNum(); i++) {
					String userFB = sheet.getRow(i).getCell(1).getStringCellValue();
					String passFB = sheet.getRow(i).getCell(2).getStringCellValue();
					String deviceUIID = sheet.getRow(i).getCell(3).getStringCellValue();
					listUsernameFB.add(userFB);
					listPasswordFB.add(passFB);
					listDeviceUIID.add(deviceUIID);					
				}				
			}
		}
		closeExcel();
	}
	
	public void closeExcel() {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearOldDataOfList() {
		listUsernameFB.clear();
		listPasswordFB.clear();
		listDeviceUIID.clear();
	}
}