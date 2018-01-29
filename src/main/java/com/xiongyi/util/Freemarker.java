package com.xiongyi.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


/**
 * @author GUXIONG
 * @description Freemarker ģ��������
 */
public class Freemarker {

	/**
	 * ��ӡ������̨(������)
	 *  @param ftlName
	 */
	public static void print(String ftlName, Map<String,Object> root, String ftlPath) throws Exception{
		try {
			Template temp = getTemplate(ftlName, ftlPath);		//ͨ��Template���Խ�ģ���ļ��������Ӧ����
			temp.process(root, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����������ļ�
	 * @param ftlName   ftl�ļ���
	 * @param root		�����map
	 * @param outFile	�������ļ�ȫ��·��
	 * @param filePath	���ǰ���ļ��ϲ�·��
	 */
	public static void printFile(String ftlName, Map<String,Object> root, String outFile, String filePath, String ftlPath) throws Exception{
		try {
			File file = new File(PathUtil.getClasspath() + filePath + outFile);
			if(!file.getParentFile().exists()){				//�ж���û�и�·���������ж��ļ�����·���Ƿ����
				file.getParentFile().mkdirs();				//�����ھ�ȫ������
			}
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			Template template = getTemplate(ftlName, ftlPath);
			template.process(root, out);					//ģ�����
			out.flush();
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ͨ���ļ�������ģ��
	 * @param ftlName
	 */
	public static Template getTemplate(String ftlName, String ftlPath) throws Exception{
		try {
			Configuration cfg = new Configuration();  												//ͨ��Freemaker��Configuration��ȡ��Ӧ��ftl
			cfg.setEncoding(Locale.CHINA, "utf-8");
			cfg.setDirectoryForTemplateLoading(new File(PathUtil.getClassResources()+"/ftl/"+ftlPath));		//�趨ȥ�����ȡ��Ӧ��ftlģ���ļ�
			Template temp = cfg.getTemplate(ftlName);												//��ģ���ļ�Ŀ¼���ҵ�����Ϊname���ļ�
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
