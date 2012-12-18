package org.wminchina.crm.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.wmichina.crm.entity.SysRight;

public class NormalTest {
	@Test
	public void testAsd(){
		Integer[] ids = {1,2,3};
		System.out.println(Arrays.toString(ids).replace('[', '(').replace(']', ')'));

  	Map<Integer, String> amap = new HashMap<Integer, String>();
  	amap.put(1, "1");
  	amap.put(2, "2");
  	amap.put(3, "3");
  	amap.put(4, "4");
  	for(Map.Entry<Integer, String> entry : amap.entrySet()){
  		System.out.println(entry.getKey() + ":" + entry.getValue());
  	}
  	
  	String pattern = "^[a-zA-Z0-9_]+[@][a-zA-Z0-9]+[\\.][a-zA-Z0-9]{2,4}$";
  	
  	System.out.println("abc@abc.com".matches(pattern));
  	System.out.println("abc@abccom".matches(pattern));
  	System.out.println("abcabc.com".matches(pattern));
  	System.out.println("abc@ab.ccom".matches(pattern));
  	System.out.println("abc@abcc.om".matches(pattern));
  	System.out.println("abc@a.bccom".matches(pattern));
	}
	@Test
	public void testMath() {
		double i = 2, j = 2.1, k = 2.5, m = 2.9;
		System.out.println("舍掉小数取整:Math.floor(2)=" + (int) Math.floor(i));
		System.out.println("舍掉小数取整:Math.floor(2.1)=" + (int) Math.floor(j));
		System.out.println("舍掉小数取整:Math.floor(2.5)=" + (int) Math.floor(k));
		System.out.println("舍掉小数取整:Math.floor(2.9)=" + (int) Math.floor(m));
		System.out.println("四舍五入取整:(2)=" + new BigDecimal("2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.1)=" + new BigDecimal("2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.5)=" + new BigDecimal("2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(2.9)=" + new BigDecimal("2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("凑整:Math.ceil(2)=" + (int) Math.ceil(i));
		System.out.println("凑整:Math.ceil(2.1)=" + (int) Math.ceil(j));
		System.out.println("凑整:Math.ceil(2.5)=" + (int) Math.ceil(k));
		System.out.println("凑整:Math.ceil(2.9)=" + (int) Math.ceil(m));
		System.out.println("舍掉小数取整:Math.floor(-2)=" + (int) Math.floor(-i));
		System.out.println("舍掉小数取整:Math.floor(-2.1)=" + (int) Math.floor(-j));
		System.out.println("舍掉小数取整:Math.floor(-2.5)=" + (int) Math.floor(-k));
		System.out.println("舍掉小数取整:Math.floor(-2.9)=" + (int) Math.floor(-m));
		System.out.println("四舍五入取整:(-2)=" + new BigDecimal("-2").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.1)=" + new BigDecimal("-2.1").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.5)=" + new BigDecimal("-2.5").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("四舍五入取整:(-2.9)=" + new BigDecimal("-2.9").setScale(0, BigDecimal.ROUND_HALF_UP));
		System.out.println("凑整:Math.ceil(-2)=" + (int) Math.ceil(-i));
		System.out.println("凑整:Math.ceil(-2.1)=" + (int) Math.ceil(-j));
		System.out.println("凑整:Math.ceil(-2.5)=" + (int) Math.ceil(-k));
		System.out.println("凑整:Math.ceil(-2.9)=" + (int) Math.ceil(-m));
	}
	@Test
	public void testSingle(){
		float a= 8/3;
		double b= 8/3;
		double c= (double)8/3;

		System.out.println((int) Math.ceil(a));
		System.out.println((int) Math.ceil(b));
		System.out.println((int) Math.ceil((double)8/3));
		System.out.println((int) Math.ceil((double)8/3));
	}

	@Test
	public void testMobile(){
		String mobilePattern="^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|999)\\d{8}$";

		System.out.println("13198989898".matches(mobilePattern));
		System.out.println("13398989898".matches(mobilePattern));
		System.out.println("15198989898".matches(mobilePattern));
		System.out.println("15498989898".matches(mobilePattern));
		System.out.println("18198989898".matches(mobilePattern));
		System.out.println("18098989898".matches(mobilePattern));
		System.out.println("18898989898".matches(mobilePattern));
		System.out.println("9999898898".matches(mobilePattern));
		System.out.println("99798989898".matches(mobilePattern));
	}
	@Test
	public void testUpdateCollections(){
		List<SysRight> rights = new ArrayList<SysRight>();
		SysRight sysRight = new SysRight();
		sysRight.setRightCode("abc000");
		rights.add(sysRight);sysRight = new SysRight();
		sysRight.setRightCode("abc111");
		rights.add(sysRight);
		System.out.println(Arrays.toString(rights.toArray()));
		
		List<SysRight> rights_1 = new ArrayList<SysRight>();
		for(SysRight entry : rights){
			entry.setRightName("nnna");
			rights_1.add(entry);
		}
		System.out.println(Arrays.toString(rights.toArray()));
		System.out.println(Arrays.toString(rights_1.toArray()));
		
	}
	
}
