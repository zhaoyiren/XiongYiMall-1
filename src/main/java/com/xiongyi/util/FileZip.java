package com.xiongyi.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author GUXIONG
 * @description ѹ����zip
 */
public class FileZip {

	/**
	 * @param inputFileName ��Ҫѹ�����ļ���(��������·��)
	 * @param zipFileName ѹ������ļ�(��������·��)
	 * @throws Exception
	 */
	public static Boolean zip(String inputFileName, String zipFileName) throws Exception {
		zip(zipFileName, new File(inputFileName));
		return true;
	}

	private static void zip(String zipFileName, File inputFile) throws Exception {
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
		zip(out, inputFile, "");
		out.flush();
		out.close();
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			//System.out.println(base);
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}
	
	 public static void main(String [] temp){       
		 try {           
			 zip("E:\\ftl","E:\\test.zip");//��Ҫѹ�����ļ���      ��  ѹ������ļ� 
			 }catch (Exception ex) {       
				 ex.printStackTrace();    
			 }   
		}
}



//=====================�ļ�ѹ��=========================
/*//���ļ�ѹ����zip
File zipFile = new File("E:/demo.zip");
//���������ļ���
InputStream input = new FileInputStream(file);
//����ѹ�������	
ZipOutputStream zipOut = null;
//ʵ����ѹ�������,���ƶ�ѹ���ļ������·��  ����E����,���ֽ� demo.zip
zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
zipOut.putNextEntry(new ZipEntry(file.getName()));
//����ע��
zipOut.setComment("www.demo.com");
int temp = 0;
while((temp = input.read()) != -1) {
	zipOut.write(temp);	
}		
input.close();
zipOut.close();*/
//==============================================
