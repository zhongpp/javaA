package com.thinkive.common.util;


public class EncodedTest {
	public static void main(String[] args) throws Exception {
		String str ="˼��";
		System.out.println("utf-8��"+str.getBytes("ISO"));
		
		System.out.println("GBK��"+str.getBytes("GBK"));
		
		byte[] ub = str.getBytes("utf-8");
		System.out.println(new String(ub,"utf-8"));
		
		byte[] gb = str.getBytes("GBK");
		System.out.println(new String(gb,"GBK"));
	}
}
