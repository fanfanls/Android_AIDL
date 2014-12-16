package com.example.service;

public class FibonacciUtils {

	public static int javaRecursion(int n) {
		if (n == 1 || n == 2) {
			return 1;
		} else {
			try {
				return (javaRecursion(n - 1) + javaRecursion(n - 2));
			} catch (StackOverflowError e) {
				return -1;
			}
		}
	}

	public static int javaInterative(int n) {
		int n1 = 1;
		int n2 = 1;
		int result = 0;
		
		if (n == 1 || n == 2) {
			return n1;
		}
		for (int i = 3; i <= n; i++) {
			result = n1 + n2;
			n1 = n2;
			n2 = result;
		}
		
		return result;
	}

}
