package chapter01;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigNumberTest {

	public static void main(String []args) {
		//�������long�ǷŲ��µ�
		BigDecimal bigDecimal = new BigDecimal("1233243243243243243243243243243243241432423432");
		System.out.println("���ֵ�ԭʼֵ�ǣ�" + bigDecimal);
		
		//bigDecimal = bigDecimal.add(BigDecimal.TEN);
		//System.out.println("���10�Ժ�" + bigDecimal);
		
		//����������
		byte[] bytes = bigDecimal.toBigInteger().toByteArray();
		for(byte b : bytes) {
			String bitString = lpad(Integer.toBinaryString(b & 0xff) , '0' , 8);
			System.out.println(bitString);
		}
		//��ԭ���
		BigInteger bigInteger = new BigInteger(bytes);
		System.out.println("��ԭ���Ϊ��" + bigInteger);
	}
	
	private static String lpad(String end , char c , int paddingLength) {
		if(end == null) {
			end = "";
		}
		if(end.length() >= paddingLength) {
			return end;
		}
		StringBuilder buf = new StringBuilder(paddingLength);
		for(int i = 0 ,size = paddingLength - end.length() ; i < size ; i++) {
			buf.append(c);
		}
		return buf.append(end).toString();
	}
}
