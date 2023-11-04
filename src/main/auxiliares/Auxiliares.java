package main.auxiliares;

public class Auxiliares {
	public static void pln(double a) {
		System.out.println(a);
	}
	public static void pln(int a) {
		System.out.println(a);
	}
	public static void pln(String a) {
		System.out.println(a);
	}
	
	public static void pln(Object a) {
		System.out.println(a);
	}
	
	public static void fpln(String str, Object... args) {
		System.out.printf(str, args);
	}
}

