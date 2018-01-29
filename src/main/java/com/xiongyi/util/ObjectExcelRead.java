package com.xiongyi.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 * @author GUXIONG
 * @description ��EXCEL���뵽���ݿ�
 *
 */
public class ObjectExcelRead {

	/**
	 * @param filepath //�ļ�·��
	 * @param filename //�ļ���
	 * @param startrow //��ʼ�к�
	 * @param startcol //��ʼ�к�
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();

		try {
			File target = new File(filepath, filename);
			FileInputStream fi = new FileInputStream(target);
			HSSFWorkbook wb = new HSSFWorkbook(fi);
			HSSFSheet sheet = wb.getSheetAt(sheetnum); 					//sheet ��0��ʼ
			int rowNum = sheet.getLastRowNum() + 1; 					//ȡ�����һ�е��к�

			for (int i = startrow; i < rowNum; i++) {					//��ѭ����ʼ
				
				PageData varpd = new PageData();
				HSSFRow row = sheet.getRow(i); 							//��
				int cellNum = row.getLastCellNum(); 					//ÿ�е����һ����Ԫ��λ��

				for (int j = startcol; j < cellNum; j++) {				//��ѭ����ʼ
					
					HSSFCell cell = row.getCell(Short.parseShort(j + ""));
					String cellValue = null;
					if (null != cell) {
						switch (cell.getCellType()) { 					// �ж�excel��Ԫ�����ݵĸ�ʽ�����������ת�����Ա�������ݿ�
						case 0:
							cellValue = String.valueOf((int) cell.getNumericCellValue());
							break;
						case 1:
							cellValue = cell.getStringCellValue();
							break;
						case 2:
							cellValue = cell.getNumericCellValue() + "";
							// cellValue = String.valueOf(cell.getDateCellValue());
							break;
						case 3:
							cellValue = "";
							break;
						case 4:
							cellValue = String.valueOf(cell.getBooleanCellValue());
							break;
						case 5:
							cellValue = String.valueOf(cell.getErrorCellValue());
							break;
						}
					} else {
						cellValue = "";
					}
					
					varpd.put("var"+j, cellValue);
					
				}
				varList.add(varpd);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return varList;
	}
}
