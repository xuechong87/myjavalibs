package com.xuechong.learn.effectivejava.compare;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

/**
 * 由于BigDecimal类的equals方法与compare方法对于"相等"的判断逻辑不一致
 * @author xuechong
 */
public class TreeHashTester {
	
	@Test
	public void compareTest() {
		Set<BigDecimal> tree = new TreeSet<BigDecimal>();
		Set<BigDecimal> hash = new HashSet<BigDecimal>();
		putNums(tree);
		putNums(hash);
		System.out.println("tree:");
		write(tree);
		System.out.println("hash:");
		write(hash);
	}
	
	private void putNums(Set<BigDecimal> set){
		BigDecimal b1 = new BigDecimal("1.0");
		BigDecimal b2 = new BigDecimal("1.00");
		set.add(b1);
		set.add(b2);
	}
	
	private void write(Set<BigDecimal> set){
		for (BigDecimal bigDecimal : set) {
			System.out.print(bigDecimal.toString());
			System.out.print("|");
		}
		System.out.println();
	}
}
