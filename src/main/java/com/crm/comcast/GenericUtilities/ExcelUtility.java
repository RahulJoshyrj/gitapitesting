package com.crm.comcast.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author RJ
 *
 */
public class ExcelUtility {
	/**
	 * method to get data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.Excelpath));
		Cell data = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		DataFormatter format=new DataFormatter();
		String value=format.formatCellValue(data);
		return value;
		
	}
	public double getNumericDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.Excelpath));
		Cell data = workbook.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		double value=data.getNumericCellValue();
		return value;

	}
	/**
	 * method to insert/update data into excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void insertIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.Excelpath));
		Cell cell = workbook.getSheet(sheetname).getRow(rownum).createCell(cellnum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstream=new FileOutputStream(IConstants.Excelpath);
		workbook.write(fileoutputstream);
	}
	/**
	 * method to get last row number
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getLastRownumFromExcel(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IConstants.Excelpath));
		int row=workbook.getSheet(sheetname).getLastRowNum();
		return row;
	}
		
}
