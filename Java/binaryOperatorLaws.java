package com.example.mathematikt1;

import java.util.Random;

public class binaryOperatorLaws {

	public static Boolean a = true;
	public static Boolean b = true;
	public static Boolean c = false;

	public static boolean proofAssociativeLaw(boolean a, boolean b, boolean c) {
		if (((a & b) & c) == (a & (b & c))){
			return true;
		}
		return false;
	}

	public static boolean proofCommutativeLaw(boolean a, boolean b, boolean c) {
		if((a & b) == (b & a)) {
			return true;
		}
		return false;
	}
	
	public static boolean proofDistributiveLaw(boolean a, boolean b, boolean c) {
		if(((a & (b | c)) && ((a & b) | (a & c)))
		== ((a & (b & c)) && ((a & b) & (a & c)))){
			return true;
		}
		return false;
	}
	
	public static boolean proofDeMorgan(boolean a, boolean b) {
		if(!(a & b) == !a | !b) {
			return true;
		}
		return false;
	}
	
	public static boolean[][] fillBool(boolean[][] bool){
		Random rnd = new Random();
		
		int numberOfColums = bool.length;
		
		for(int row = 0; row < numberOfColums; row++) {
			for(int col = 0; col < bool[row].length; col++) {
				bool[row][col] = rnd.nextBoolean();
			}
		
		}
		return bool;
	}
	
	public static void printBoolean(boolean[][] bool) {
		int numberOfColums = bool.length;
		int numberOfRows = bool[0].length;
		System.out.println(numberOfColums);
		System.out.println(numberOfRows);
		for(int row = 0; row < numberOfColums; row++) {
			for(int col = 0; col < bool[row].length; col++) {
				System.out.println(bool[row][col]);
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		/*boolean[][] bool = new boolean[1][3];
		printBoolean(bool);
		fillBool(bool); */
		/*boolean a = bool[0][0];
		boolean b = bool[0][1];
		boolean c = bool[0][2]; */
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		System.out.println("-------------------");
		
		System.out.println("Associative Law: " + proofAssociativeLaw(a, b, c));
		System.out.println("Commutative Law: " + proofCommutativeLaw(a, b, c));
		System.out.println("Distributive Law: " + proofDistributiveLaw(a, b, c));
		System.out.println("DeMorgan Law: " + proofDeMorgan(a, b));
	}

}
