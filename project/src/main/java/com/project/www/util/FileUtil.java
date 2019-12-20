package com.project.www.util;
/**
 * 
 *  �� Ŭ������ ���� ���ε忡 �ʿ��� ����� ó���ϱ� ���ؼ� ���� ��ƿ��Ƽ�� Ŭ�����̴�.
 *  
 * 
 * @author keira
 * @since 2019.12.16
 * @version v.1.0
 * @see
 * 
 * 		 �����̷�
 * 
 * 				2019-12-16  	- Ŭ���� ���� 	-����� ������
 * 
 */

import java.io.*;


public class FileUtil {

	/*
	 ���� �̸��� �ߺ��Ǹ� ������ ���ε��� ���Ͽ� ����Ⱑ �ȴ�.
	 ���� Ȥ�� ���� �̸��� ������ �����ϸ� ���� �̸��� �ٲ㼭 ���� ����� �Ѵ�.
	 ������ ���ε��ߴ� ������ �̸��� ���ϵ� ������ �ǰ�
	 ���� ���� ���ε��ϴ� ���ϵ� ������ EHLSEK.
	 
	 
	 */

public static String rename(String path, String oldName) {

	/*
		 ��å ����]
		 
		 	Ȥ�� ���� �̸��� ������ �����ϸ� _1�� �ٿ��� �̸��� �ٲٴ� ����� ����ϰڴ�.
		 	
		 	��]
		 		sample.jpg ��� ������ ���ε� �Ϸ��ϴµ�
	`			�̹� ���ε� �� ������ �̸��� �����Ѵٸ� 
		 		sample_1.jpg�� �ٲ㼭 ����Ѵ�.
		 		
		 		
	 */
	
	
	int count=0; //������ ������ ��� �ٿ��� ��ȣ�� ����� ����	
	
/*
 
 
sample_1.jpg �� ���� ����
sample_2.jpg ��� �̸����� ������ ��������� �� ���̴�.
 
 */
	
	String tmpName = oldName; //�����̸��� ���� ����� ���´�.
	
	
	 File file = new File(path,oldName);
	 //���� oldName���� ������� ������ �ִ��� üũ�Ѵ�.
	 
	 while(file.exists()) {
		 //�� ���� �̹� oldName ���� �� ������ ���ε� �Ǿ� �ִ� ����̴�.
		 //���� �ٸ��̸����� �ٲ���� �Ѵ�.
		 //�̹� ������ �����ϴ� ���� 
		 // �̸��� �ٲ���� �Ѵ�.
		 // �̶� �츮��_�� ���ڸ� �ٿ��� �����̸��� ������ �ߴ�.
		count++;
		int len =tmpName.lastIndexOf(".");
		String tmp1 =tmpName.substring(0,len);
		oldName = tmp1 + "_" +count +tmpName.substring(len);
		
		
		file = new File (path ,oldName);
		
	 }
	 
	 // 	�� ���� ����Ǵ� ���� oldName ���� �Է��� ������ ���� ��� �Ǵ�
	 // 	 �� file.exists() �� ����� false �� ���
	
	 
	 
	return oldName;
	
	
}


}
