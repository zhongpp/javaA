package com.thinkive.common.util;


public class EncodedTest {
	public static void main(String[] args) throws Exception {
		String str ="Ë¼µÏ";
		System.out.println("utf-8£º"+str.getBytes("ISO"));
		
		System.out.println("GBK£º"+str.getBytes("GBK"));
		
		byte[] ub = str.getBytes("utf-8");
		System.out.println(new String(ub,"utf-8"));
		
		byte[] gb = str.getBytes("GBK");
		System.out.println(new String(gb,"GBK"));
	}
}
