package com.thinkive.common.util;

/**
 * 随机数工具类
 * @author 
 *
 */
public class RandomUtil {

	public static int getRandomInt(int max){
		return (int)(1+Math.random()*max);
	}
	
}
