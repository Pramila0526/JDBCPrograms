package com.bridgelabz.jdbc.utility;
import java.util.*;
/*********************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Utility Class
 *
 ***********************************************************************************************/
public class Utility{

	 static Scanner sc;

	public static int integerInput() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double doubleInput() {
		sc = new Scanner(System.in);
		return sc.nextDouble();
	}

	public static String stringInput() {
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static int longInput() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
	