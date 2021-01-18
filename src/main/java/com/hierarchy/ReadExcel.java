package com.hierarchy;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	/*
	 * Use below for reading old excel files
	 */
	public void readExcelOld(String filename) {
		try {
		    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
		    
		    HSSFWorkbook wb = new HSSFWorkbook(fs);
		    HSSFSheet sheet = wb.getSheetAt(0);
		    HSSFRow row;
		    HSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();
		    System.out.println("Rows = " + rows);
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}		
	}
	
	/*
	 * Use below for reading new excel files
	 */
	public ArrayList<Employee> readExcel(String filename) {
	    ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			OPCPackage pkg = OPCPackage.open(new File(filename));
			XSSFWorkbook wb = new XSSFWorkbook(pkg);
		    XSSFSheet sheet = wb.getSheetAt(0);
		    XSSFRow row;
		    XSSFCell cell;

		    int rows; // No of rows
		    rows = sheet.getPhysicalNumberOfRows();
		    System.out.println("Rows = " + rows);
		    int cols = 0; // No of columns
		    int tmp = 0;

		    // This trick ensures that we get the data properly even if it doesn't start from first few rows
		    for(int i = 0; i < 10 || i < rows; i++) {
		        row = sheet.getRow(i);
		        if(row != null) {
		            tmp = sheet.getRow(i).getPhysicalNumberOfCells();
		            if(tmp > cols) cols = tmp;
		        }
		    }
		    for(int r = 0; r < rows; r++) {
		    	if (r == 0) continue; //Header row
		    	if (r == 10) break;
		    	
		        row = sheet.getRow(r);
		        if(row != null) {
		        	Employee bean = new Employee();
		            for(int c = 0; c < cols; c++) {
		                cell = row.getCell((short)c);
		                if(cell != null) {
		                    populateBean(c, cell.toString(), bean);
		                }
		            }
                    list.add(bean);
		        }
		    }
		    
		} catch(Exception ioe) {
		    ioe.printStackTrace();
		}		
		return list;
	}
	
	private void populateBean(int colno, String value, Employee bean) {
		switch (colno) {
		case 0: bean.setFiller(value); break;
		case 1: bean.setEmpid(value); break;
		case 2: bean.setName(value); break;
		case 3: bean.setLocation(value); break;
		case 4: bean.setEntity(value); break;
		case 5: bean.setDesignation(value); break;
		case 6: bean.setSkillgroup(value); break;
		case 7: bean.setEngagementType(value); break;
		case 8: bean.setRole(value); break;
		case 9: bean.setStatus(value); break;
		case 10: bean.setAccount(value); break;
		case 11: bean.setEmail(value); break;
		case 12: bean.setSupervisor_email(value); break;
		case 13: bean.setSupervisor_empid(value); break;
		case 14: bean.setMaster_record(value); break;
		}
	}
	public static void main(String args[]) {
		ReadExcel excel = new ReadExcel();
		String filename = "C:/MyData/myjob/skills/data/out/SCB/OUT-SCB-SVF - Resource View on 10252018-Chennai.xlsx";
		ArrayList<Employee> list = excel.readExcel(filename);
		for (Employee bean : list) {
			System.out.println(bean);
		}
	}
	
}
